package net.mcqie.pss.protocol.packfactory;/*
 * @author by MCqie
 *@date 2021/8/14.
 */

import com.alibaba.fastjson.JSONObject;
import net.mcqie.pss.protocol.BasePack;
import net.mcqie.pss.protocol.DataPackage;
import net.mcqie.pss.protocol.DataType;

public class AccountPackFactory {
    public static DataPackage Make(int code, String name){
        JSONObject data=new JSONObject();
        data.put("name",name);
        DataPackage dataPackage=((DataPackage)new BasePack(DataType.account,code));
        dataPackage.getJson().put("data",data);
        return dataPackage;
    }
    public static DataPackage Makeindex(int code,int index,String name){
        JSONObject data=new JSONObject();
        data.put("name",name);
        data.put("index",index);
        DataPackage dataPackage=((DataPackage)new BasePack(DataType.connect,code));
        dataPackage.getJson().put("data",data);
        return dataPackage;
    }
}
