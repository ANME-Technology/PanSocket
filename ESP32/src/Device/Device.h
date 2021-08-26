//
// Created by MCqie on 2021/8/18.
//

#ifndef SOCKETAPI_DEVICE_H
#define SOCKETAPI_DEVICE_H
#include "../Protocol/PansProtocol.h"
#include "../Protocol/MessageBuilder.h"
#include "../Protocol/Execuse.h"
#include "WiFi.h"
#include "Client.h"
typedef struct {
    bool PRINTABLE;
    bool RECONNECT;
    bool SERIALREAD;
} DeviceConfig;
class Device {

public:

    const char *SSID;
    const char *PWD;
    IPAddress ServerIP;
    const IPAddress serverIP;
    uint16_t serverPort;
    Execuse *exec;
    char Devicename[32];
    WiFiClient client=WiFiClient();
    DeviceConfig  deviceConfig;
    char reged= 0;
    char buffer[1024];
    Device(const char *name,DeviceConfig conf);
    void ConncetServer(IPAddress ipAddress, const uint16_t port);

    void keepRun();

    void ConnectWifi(const char *id,const char *psw);
};


#endif //SOCKETAPI_DEVICE_H
