package net.mcqie.pss.protocol.pack;/*
 * @author by MCqie
 *@date 2021/8/12.
 */

import com.alibaba.fastjson.JSONObject;
import net.mcqie.pss.protocol.DataPackage;
import net.mcqie.pss.protocol.DataType;

import javax.xml.crypto.Data;

public class ConnectStatusPack extends DataPackage {

    public ConnectStatusPack(JSONObject json) {
        super(json);
    }
    public ConnectStatusPack(DataPackage pack) {
        new ConnectStatusPack(pack.getJson());
    }
    @Override
    public String  toString(){
        return this.getJson().toString();
    }

}
