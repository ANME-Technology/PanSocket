package net.mcqie.pss.server.listeners.bot;/*
 * @author by MCqie
 *@date 2021/8/14.
 */

import net.mcqie.pss.server.Client;

import java.util.ArrayList;

public class BotList {
    ArrayList<NativeBot> nativeBots=new ArrayList<>();
    public void registBot(NativeBot nb){
        nativeBots.add(nb);
    }
    public void Handle(Client c, String message){
        nativeBots.forEach((Bot)->{
            Bot.handle(c,message);
        });
    }
}
