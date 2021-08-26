package net.mcqie.pss.protocol.pack;/*
 * @author by MCqie
 *@date 2021/8/14.
 */

import com.alibaba.fastjson.JSONObject;
import net.mcqie.pss.protocol.DataPackage;

public class MessagePack extends DataPackage{
    public MessagePack(JSONObject json) {
        super(json);
    }
    public MessagePack(DataPackage pack) {
        new ConnectStatusPack(pack.getJson());
    }
    @Override
    public String  toString(){
        return this.getJson().toString();
    }
}
