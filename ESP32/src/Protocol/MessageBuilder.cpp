//
// Created by MCqie on 2021/8/18.
//

#include "MessageBuilder.h"
char* MessageBuilder::PANS_BuildConnect(int code,char *type,int status){
    data=cJSON_CreateObject();
    cJSON_AddNumberToObject(data,"status",status);
    p=new PansProtocol(code,type);
    return cJSON_PrintUnformatted(p->BuildJSON(data));
}
char* MessageBuilder::PANS_Buildregist(int code,char *type,char* name){
    data=cJSON_CreateObject();
    cJSON_AddStringToObject(data,"name",name);
    p=new PansProtocol(code,type);
    return cJSON_PrintUnformatted(p->BuildJSON(data));
}
char* MessageBuilder::PANS_BuildMessage(int code,char *type,char* name,char* msg){
    data=cJSON_CreateObject();
    cJSON_AddStringToObject(data,"name",name);
    cJSON_AddStringToObject(data,"msg",msg);
    p=new PansProtocol(code,type);
    return cJSON_PrintUnformatted(p->BuildJSON(data));
}