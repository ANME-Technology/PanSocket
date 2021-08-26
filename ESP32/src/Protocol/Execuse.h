//
// Created by MCqie on 2021/8/18.
//

#ifndef SOCKETAPI_EXECUSE_H
#define SOCKETAPI_EXECUSE_H
#include "PansProtocol.h"
#include "stdlib.h"
class Execuse {
    void (*pf)(PansProtocol*);
    bool reged=0;
public:
    bool printable;
    PansProtocol *p;
    Execuse(bool printalbe);
    void exec(char* c);
    void reg(void (*USER_HANDLER_ptr)(PansProtocol*));
protected:
    void Services(PansProtocol *p);
    void printSerivce(PansProtocol *p);

};

#endif //SOCKETAPI_EXECUSE_H
