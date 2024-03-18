#include <Arduino.h>
#include <WiFi.h>
#include <HTTPClient.h>
#include <ArduinoJson.h>

// WiFi设置
const char* ssid = "105A";
const char* password = "10152886";

// 服务器URL
const char* serverUrl = "http://192.168.3.10:8102/api/data1/insert_soil";

int sensorPin[8] = {27, 14, 12, 13, 4, 0, 2, 15};
float sensorValue[8] = {0};
float soil[8] = {0};
//float soil1, soil2, soil3, soil4, soil5, soil6, soil7, soil8;

void setup() {
    Serial.begin(115200);

    for (int i = 0; i < 8; i++) {
    pinMode(sensorPin[i], INPUT);
    }
}

void loop() {

    readSensors();
    lianjie();
    sendSoilDataToServer();
    delay(30000); // 每30秒发送一次数据
    // ESP.deepSleep(20 * 60 * 1000000); // 深度睡眠20分钟，单位为微秒
}

void lianjie(){
    // 连接WiFi
    WiFi.begin(ssid, password);
    while (WiFi.status() != WL_CONNECTED) {
      delay(1000);
      Serial.println("Connecting to WiFi...");
    }
    Serial.println("WIFI 连接成功!");
}
void readSensors() {
    for (int i = 0; i < 8; i++) {
      sensorValue[i] = analogRead(sensorPin[i]);
      soil[i] = (1-(sensorValue[i] / 4095.0)) * 100;
      float soil1 = soil[0];
      float soil2 = soil[1];
      float soil3 = soil[2];
      float soil4 = soil[3];
      float soil5 = soil[4];
      float soil6 = soil[5];
      float soil7 = soil[6];
      float soil8 = soil[7];
    }
    Serial.println("数据采集完成!");
}

void sendSoilDataToServer() {
  
  String jsonBody = "{\"soil1\":\"" + String(soil[0]) +
                  "\",\"soil2\":\"" + String(soil[1]) +
                  "\",\"soil3\":\"" + String(soil[2]) +
                  "\",\"soil4\":\"" + String(soil[3]) +
                  "\",\"soil5\":\"" + String(soil[4]) +
                  "\",\"soil6\":\"" + String(soil[5]) +
                  "\",\"soil7\":\"" + String(soil[6]) +
                  "\",\"soil8\":\"" + String(soil[7]) + "\"}";

    Serial.println("传感器数据:"+ String(jsonBody));
    String jsonPayload;
    HTTPClient http;
    http.begin(serverUrl);
    http.addHeader("Content-Type", "application/json");

    int httpCode = http.POST(jsonBody);

    if (httpCode == HTTP_CODE_OK || httpCode == HTTP_CODE_CREATED) {
      Serial.println("[HTTP] POST successful, code: " + String(httpCode));
      String responsePayload = http.getString();
      Serial.println("数据发送成功!");
    } else {
      Serial.println("[HTTP] POST failed, error: " + String(httpCode));
    }
    http.end();
    // 关闭Wi-Fi以降低功耗
    WiFi.disconnect(true); 
    WiFi.mode(WIFI_OFF);

}