//
// Created by MCqie on 2021/8/18.
//

#ifndef SOCKETAPI_MESSAGEBUILDER_H
#define SOCKETAPI_MESSAGEBUILDER_H
#include "PansProtocol.h"

class MessageBuilder {
    cJSON *data;
    PansProtocol *p;
public:
    char* PANS_BuildConnect(int code,char *type,int status);
    char* PANS_Buildregist (int code,char *type,char* name);
    char* PANS_BuildMessage(int code,char *type,char* name,char* msg);
};

#endif //SOCKETAPI_MESSAGEBUILDER_H
