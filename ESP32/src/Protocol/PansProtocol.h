//
// Created by MCqie on 2021/8/18.
//

#ifndef CJSON_PANSPROTOCOL_H
#define CJSON_PANSPROTOCOL_H
#include "string.h"
#include "../cJSON.h"
#include "iostream"
class PansProtocol {
public:
    int code;
    char type[8];
    cJSON *json;
    cJSON* data;
    PansProtocol(int code,char* type);
    PansProtocol(char* string);
    cJSON* BuildJSON(cJSON *data);
};
#endif //CJSON_PANSPROTOCOL_H
