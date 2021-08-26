package net.mcqie.pss.server;/*
 * @author by MCqie
 *@date 2021/8/11.
 */

import net.mcqie.pss.PanSServer;
import net.mcqie.pss.protocol.DataPackage;

import java.net.Socket;
import java.util.logging.Handler;

public class ServerListener {
    public  ListenerHandler lh=new ListenerHandler();

    public void ListenerHandler(Client form, String message){
        PanSServer.getConsole().info(message);
        DataPackage dp=DataPackage.parse(message);
        Client c = null;
        lh.handle(form,dp.getJson(),dp.getJson().getInteger("type"));
    }



}
