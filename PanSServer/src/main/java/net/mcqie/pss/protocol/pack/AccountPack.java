package net.mcqie.pss.protocol.pack;/*
 * @author by MCqie
 *@date 2021/8/14.
 */

import com.alibaba.fastjson.JSONObject;
import net.mcqie.pss.protocol.DataPackage;

public class AccountPack  extends DataPackage {
    public AccountPack(JSONObject json) {
        super(json);
    }
    public AccountPack(DataPackage pack) {
        new AccountPack(pack.getJson());
    }
    @Override
    public String  toString(){
        return this.getJson().toString();
    }
}
