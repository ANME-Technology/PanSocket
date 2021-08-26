package net.mcqie.pss.server.listeners;/*
 * @author by MCqie
 *@date 2021/8/14.
 */

import com.alibaba.fastjson.JSONObject;
import net.mcqie.pss.PanSServer;
import net.mcqie.pss.protocol.DataType;
import net.mcqie.pss.protocol.packfactory.MessagePackFactory;
import net.mcqie.pss.server.Client;
import net.mcqie.pss.server.ClientMessageHandle;
import net.mcqie.pss.server.ServerUtil;

import java.io.IOException;

public class MessageListener  extends ClientMessageHandle {
    @Override
    public void Run(Client client, JSONObject msg, int type) throws IOException {

        if(type== DataType.message.getCode()){
            ServerUtil.sendDataToEvery(PanSServer.getServer(),
                    MessagePackFactory.Make(0,
                    msg.getJSONObject("data").getString("msg"),
                    msg.getJSONObject("data").getString("name")
                    )
            );
        }
    }
}
