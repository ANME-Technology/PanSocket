//
// Created by MCqie on 2021/8/18.
//

#include "PansProtocol.h"

cJSON *PansProtocol::BuildJSON(cJSON *data) {
        this->data=data;
        this->json=cJSON_CreateObject();
        cJSON_AddStringToObject(json,"type",this->type);
        cJSON_AddNumberToObject(json,"code",code);
        cJSON_AddItemToObject(json,"data",data);
        return this->json;
}
PansProtocol::PansProtocol(char *string) {
    json= cJSON_Parse(string);
    code= cJSON_GetObjectItem(json,"code")->valueint;
    strcpy(type,cJSON_GetObjectItem(json,"type")->valuestring);
    data= cJSON_GetObjectItem(json,"data");
}
PansProtocol::PansProtocol(int code, char *type) {
    this->code=code;
    strcpy(this->type,type);
}

