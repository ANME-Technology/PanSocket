//
// Created by MCqie on 2021/8/18.
//

#include "Execuse.h"
#include "Arduino.h"
Execuse::Execuse(bool printalbe){
    this->printable=printalbe;

}
void Execuse::exec(char *c) {
        p=new PansProtocol(c);
        Services(p);

}
void Execuse::Services(PansProtocol *p) {
    if(this->printable){
        printSerivce(p);
    }
    if(reged){
        (*pf)(p);
    }
}

void Execuse::printSerivce(PansProtocol *p) {
if(atoi(p->type)!=3){
    Serial.println(cJSON_PrintUnformatted(p->json));
}
}

void Execuse::reg(void (*USER_HANDLER_ptr)(PansProtocol*)) {
    reged=1;
    pf=USER_HANDLER_ptr;
}
