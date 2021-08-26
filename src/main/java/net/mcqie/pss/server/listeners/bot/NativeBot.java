package net.mcqie.pss.server.listeners.bot;/*
 * @author by MCqie
 *@date 2021/8/14.
 */

import net.mcqie.pss.Launch;
import net.mcqie.pss.PanSServer;
import net.mcqie.pss.server.Client;

import java.io.IOException;

public abstract class NativeBot {
public abstract void Run(Client c, String message) throws IOException, Exception;
public void handle(Client c, String message){
    try{
        Run(c, message);
    }catch (Exception e){
        if(Launch.debug){
            e.printStackTrace();
        }
        PanSServer.getConsole().info("Bot错误");
    }
}
}
