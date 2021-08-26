//
// Created by MCqie on 2021/8/18.
//

#include "Device.h"

void Device::ConncetServer(IPAddress ipAddress, const uint16_t port) {
    ServerIP = ipAddress;
    serverPort = port;
    Serial.println("尝试访问服务器");
    if (client.connect(ipAddress, port)) {
        Serial.println("访问成功");
    } else {
        Serial.println("访问失败");
    }
}

void Device::keepRun() {
    if (deviceConfig.RECONNECT) {
        if (!client.connected()) {
            Serial.println("重连");
            if (client.connect(serverIP, serverPort)) {
                Serial.println("重连成功");
                String line = client.readStringUntil('\n'); //读取数据到换行符
                Serial.println(line);
                reged = 0;
            } else {
                Serial.println("访问失败");
            }
        }
    } //重连
//send a data


    if (client.available()) {//数据可读
        String line = client.readStringUntil('\n'); //读取数据到换行符
        line.toCharArray(buffer, 1024);
        exec->exec(buffer);
    } //接收数据
    if (reged == 0) {
        reged = 1;
        MessageBuilder *mb = new MessageBuilder();
        client.println(mb->PANS_Buildregist(0, "1", this->Devicename));
        delete mb;
    } //注册名称
    //
    if(this->deviceConfig.SERIALREAD){
        String inputString;
        while (Serial.available()) {
            inputString = inputString + char(Serial.read());
            delay(2);
        }
        if (inputString.length() > 0) {
            inputString.toCharArray(buffer, 1024);
            MessageBuilder *builder = new MessageBuilder();
            client.println(builder->PANS_BuildMessage(0, "2", "Test", buffer));
            delete builder;
            //        Serial.println(inputString);
            inputString = "";

        }
    } //串口发数据
}

void Device::ConnectWifi(const char *id, const char *psw) {
    SSID = id;
    PWD = psw;
    WiFi.begin(id, psw);
    Serial.println("开始连接WiFi");
    while (WiFi.status() != WL_CONNECTED) {            //未连接上
        delay(500);
        Serial.print(".");
    }
    Serial.print(WiFi.SSID());
    Serial.println("已连接");
    Serial.print("IP:");
    Serial.println(WiFi.localIP());
    Serial.println("WiFi连接成功！");                //连接上
}



Device::Device(const char *name, DeviceConfig conf) {
    strcpy(Devicename, name);
    exec = new Execuse(conf.PRINTABLE);
}
