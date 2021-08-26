package net.mcqie.pss.protocol.packfactory;/*
 * @author by MCqie
 *@date 2021/8/14.
 */

import com.alibaba.fastjson.JSONObject;
import net.mcqie.pss.protocol.BasePack;
import net.mcqie.pss.protocol.DataPackage;
import net.mcqie.pss.protocol.DataType;

public class MessagePackFactory {
    public static DataPackage Make(int code, String message,String name){
        JSONObject data=new JSONObject();
        data.put("msg",message);
        data.put("name",name);
        DataPackage dataPackage=((DataPackage)new BasePack(DataType.message,code));
        dataPackage.getJson().put("data",data);
        return dataPackage;
    }
}
