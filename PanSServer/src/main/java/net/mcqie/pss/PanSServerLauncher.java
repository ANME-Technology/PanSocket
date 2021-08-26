package net.mcqie.pss;/*
 * @author by MCqie
 *@date 2021/8/11.
 */

import net.mcqie.pss.console.Console;
import net.mcqie.pss.server.Server;
import net.mcqie.pss.server.listeners.bot.crino.Bot;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class PanSServerLauncher {

    public static void ServerStart() throws IOException {
        PanSServer.setConsole(new Console("PanSServer"));
        PanSServer.getConsole().info("正在启动控制台");
        PanSServer.getConsole().startConsole();
        new PanSServer();
        PanSServer.getConsole().info("控制台已启动!");


    }
    public static void regBot(){
        PanSServer.getBots().registBot(new Bot());
    }
}
