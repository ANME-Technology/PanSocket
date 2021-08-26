package net.mcqie.pss.server;/*
 * @author by MCqie
 *@date 2021/8/14.
 */

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public class ListenerHandler {
    ArrayList<ClientMessageHandle> cs=new ArrayList<>();
    public void handle(Client client,JSONObject msg,int type){
        for (ClientMessageHandle c:cs){
            c.Handle(client,msg,type);
        }
    }
    public void regist(ClientMessageHandle listener){
        cs.add(listener);
    }
    public void uninst(ClientMessageHandle listener){
        cs.remove(listener);
    }
}
