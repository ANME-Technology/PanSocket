package net.mcqie.pss.server.listeners;/*
 * @author by MCqie
 *@date 2021/8/14.
 */

import com.alibaba.fastjson.JSONObject;
import net.mcqie.pss.PanSServer;
import net.mcqie.pss.protocol.DataType;
import net.mcqie.pss.server.Client;
import net.mcqie.pss.server.ClientMessageHandle;

public class ServerBot extends ClientMessageHandle {

    @Override
    public void Run(Client client, JSONObject msg, int type) throws Exception {
        if (type == DataType.message.getCode()) {
            String message = msg.getJSONObject("data").getString("msg");
            String name = msg.getJSONObject("data").getString("name");
            PanSServer.getBots().Handle(client,message);
        }
    }
}
