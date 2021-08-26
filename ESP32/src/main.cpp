#include <Arduino.h>
#include "Device/Device.h"

const char *id = "CMCC-HLCS";
const char *psw = "123456..";
DeviceConfig  deviceConfig={
        .PRINTABLE=1,
        .RECONNECT=1,
        .SERIALREAD=1,
};
void Exece(PansProtocol* p);
Device *device = new Device("Test",deviceConfig);
const IPAddress serverIP(81, 68, 179, 134);
uint16_t serverPort = 7788;
bool LED=0;
void setup() {
    pinMode(4,OUTPUT);
    Serial.begin(115200);
    device->ConnectWifi(id,psw);
    device->ConncetServer(serverIP, serverPort);
    device->exec->reg(Exece);
}
void loop() {
    device->keepRun();
}

void Exece(PansProtocol* p){
    cJSON *jsons=p->data;
    if(!strcmp(p->type,"2")){
        cJSON *jsons2= cJSON_GetObjectItem(jsons,"msg");
        char* s=jsons2->valuestring;
        if(!strcmp(s,"c")){
                    if(LED){
                        LED=0;
                        digitalWrite(4,LOW);
                    }else{
                        LED=1;
                        digitalWrite(4,HIGH);
                    }
        }
    }
//    if(cJSON_GetObjectItem(jsons,"msg")->valuestring=="C"&&p->type=="2"){
//        if(LED){
//            digitalWrite(4,LOW);
//        }else{
//            digitalWrite(4,HIGH);
//        }
//    }
}