  #include <Arduino.h>
  #include <WiFi.h>
  #include <HTTPClient.h>
  #include <ArduinoJson.h>

  // WiFi设置
  const char* ssid = "105A";
  const char* password = "10152886";
  String s = " ";


  // 服务器URL
  const char* serverUrl = "http://192.168.3.10:8102/api/data1/soil";



void setup() {
    Serial.begin(115200);
    // 连接WiFi
    WiFi.begin(ssid, password);
    while (WiFi.status() != WL_CONNECTED) {
      delay(1000);
      Serial.println("Connecting to WiFi...");
    }
    Serial.println("WIFI 连接成功!");
    pinMode(16,OUTPUT);
}

void loop() {
 qingqiu();

    if ( s !="0"){
      digitalWrite(35, HIGH); 
      Serial.println("开始浇水");        
      }else{
      digitalWrite(35,LOW); 
      Serial.println("停止浇水");
      }
 delay(20000);
}

void qingqiu(){

   if (WiFi.status() == WL_CONNECTED) {
        HTTPClient http;

        String url = serverUrl;
        
        http.begin(url); // 初始化GET请求

        int httpCode = http.GET(); // 发送GET请求

        if (httpCode > 0) { // 请求成功
            String payload = http.getString();
            // Serial.println("[HTTP] GET... code: " + String(httpCode));
            Serial.println("[HTTP] GET... payload: " + payload);
            s = payload;
        } else {
            Serial.println("[HTTP] GET... failed, error: " + String(httpCode));
        }

        http.end(); // 关闭HTTP客户端连接
        delay(5000); // 每隔5秒请求一次（根据实际情况调整）
    }
}
