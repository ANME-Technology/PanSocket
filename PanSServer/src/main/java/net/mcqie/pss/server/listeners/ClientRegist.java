package net.mcqie.pss.server.listeners;/*
 * @author by MCqie
 *@date 2021/8/14.
 */

import com.alibaba.fastjson.JSONObject;
import net.mcqie.pss.PanSServer;
import net.mcqie.pss.protocol.DataType;
import net.mcqie.pss.protocol.pack.AccountPack;
import net.mcqie.pss.protocol.packfactory.AccountPackFactory;
import net.mcqie.pss.server.Client;
import net.mcqie.pss.server.ClientMessageHandle;
import net.mcqie.pss.server.ServerUtil;

import java.io.IOException;

public class ClientRegist extends ClientMessageHandle {
    @Override
    public void Run(Client client, JSONObject msg, int type) throws IOException {
        if(type==DataType.account.getCode()){
            client.setName(msg.getJSONObject("data").getString("name"));
            PanSServer.getConsole().info("Client "+client.getIndex()+"名称已注册为"+client.getName());
            ServerUtil.sendDataToOne(client, AccountPackFactory.Makeindex(0,client.getIndex(),client.getName()));
        }
    }
}
