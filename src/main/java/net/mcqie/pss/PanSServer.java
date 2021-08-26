package net.mcqie.pss;/*
 * @author by MCqie
 *@date 2021/8/11.
 */

import net.mcqie.pss.console.Console;
import net.mcqie.pss.server.Server;
import net.mcqie.pss.server.listeners.bot.BotList;

import java.io.IOException;

/**
 * Server主类
 */
public class PanSServer {
    private static Console console;
    private static Server server;
    private static BotList bots;

    PanSServer() {
        try {
            server = new Server();
            bots=new BotList();
            if(Launch.UseBot) {
                console.info("注册bot");
                PanSServerLauncher.regBot();
                console.info("注册bot完成");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Server getServer() {
        return server;
    }

    public static BotList getBots() {
        return bots;
    }

    public static Console getConsole() {
        return console;
    }

    public static void setConsole(Console console) {
        PanSServer.console = console;
    }

}
