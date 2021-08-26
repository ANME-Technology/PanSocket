package net.mcqie.pss.server.listeners;/*
 * @author by MCqie
 *@date 2021/8/14.
 */

import com.alibaba.fastjson.JSONObject;
import net.mcqie.pss.PanSServer;
import net.mcqie.pss.server.Client;
import net.mcqie.pss.server.ClientMessageHandle;

public class Printer extends ClientMessageHandle {

    @Override
    public void Run(Client client, JSONObject msg, int type) {
        PanSServer.getConsole().info(client.getIndex()+"."+client.getName()+":"+msg.toString());
    }
}
