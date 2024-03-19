#include <Wire.h>
#include <BH1750.h>
#include "Adafruit_SGP30.h"
#include "DHT.h"
#include <WiFi.h>
#include <HTTPClient.h>
#include <ArduinoJson.h>

// WiFi设置
const char* ssid = "105A";//"TP-LINK_"
const char* password = "10152886";//"20040606zyy"

// 服务器URL
const char* serverUrl = "http://192.168.3.10:8102/api/data1/insert_data1";

struct DeviceData {
  String name;
  //int deviceID;
  //int type;
  float humidity;
  float lux;
  float temperature;
  // 根据实际情况添加或删除传感器数据字段
  int TVOC; // 假设这是一个额外的传感器读数字段
  float co2; // 假设这是从SGP30获取的数据
};

DeviceData device;


#define SDA_PIN 21
#define SCL_PIN 22
#define DHTPIN 18
#define DHTTYPE DHT22 // 使用DHT22温湿度传感器

BH1750 lightMeter;
Adafruit_SGP30 sgp;
DHT dht(DHTPIN, DHTTYPE); // 使用实际连接的DHT引脚

void setup() {
  Serial.begin(115200);
  Wire.begin(SDA_PIN, SCL_PIN);

  dht.begin();
  Serial.println("DHT 初始化成功!");

  lightMeter.begin();
  Serial.println("BH1750 初始化成功!");

  if (!sgp.begin()) {
    Serial.println("SGP30 初始化失败!");
    
  }
  else {
    Serial.println("SGP30 初始化成功!");
  }
  // 连接Wi-Fi
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.print("Connecting to WiFi...");
  }
  Serial.println("Connected to WiFi");
}

void loop() {
  readSensorsData();

  // 每隔一段时间（例如每分钟）发送一次数据
  sendDataToServer();

  delay(600); // 每60秒发送一次
}

void readSensorsData() {
  float humidity = dht.readHumidity();
  float temperature = dht.readTemperature();
  float lux = lightMeter.readLightLevel();
  
  // 假设可以从SGP30获取到co2和TVOC数据
  if (sgp.IAQmeasure()) {
    float co2 = sgp.eCO2;
    int TVOC = sgp.TVOC; 
    device.co2 = co2;
    device.TVOC = TVOC;
  } else {
    Serial.println("SGP30 数据读取失败!");
    device.co2 = 0;
    device.TVOC = 0;
  }
  Serial.print("lux:");
  Serial.println(lux);
  Serial.print("hum:");
  Serial.println(humidity);
  Serial.print("temp:");
  Serial.println(temperature);

  //device.name = "Device 1";
  //device.deviceID = 123222;
  //device.type = 1222;
  device.humidity = humidity;
  device.lux = lux;
  device.temperature = temperature;
}

void sendDataToServer() {
  DynamicJsonDocument doc(1024);
  //doc["name"] = device.name;
  //doc["deviceID"] = device.deviceID;
  //doc["type"] = device.type;
  doc["humidity"] = device.humidity;
  doc["lux"] = device.lux;
  doc["temperature"] = device.temperature;
  //doc["TVOC"] = device.TVOC;
  doc["co2"] = device.co2;

  String jsonPayload;
  serializeJson(doc, jsonPayload);

  HTTPClient http;
  http.begin(serverUrl);
  http.addHeader("Content-Type", "application/json");

  int httpCode = http.POST(jsonPayload);

  if (httpCode == HTTP_CODE_OK || httpCode == HTTP_CODE_CREATED) {
    Serial.println("[HTTP] POST 成功, 状态码: " + String(httpCode));
  } else {
    Serial.println("[HTTP] POST 失败, 错误: " + String(httpCode));
  }

  http.end();
}