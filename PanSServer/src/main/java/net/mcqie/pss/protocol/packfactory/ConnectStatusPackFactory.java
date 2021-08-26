package net.mcqie.pss.protocol.packfactory;/*
 * @author by MCqie
 *@date 2021/8/12.
 */

import com.alibaba.fastjson.JSONObject;
import net.mcqie.pss.protocol.BasePack;
import net.mcqie.pss.protocol.DataPackage;
import net.mcqie.pss.protocol.DataType;
import net.mcqie.pss.protocol.pack.ConnectStatusPack;

public class ConnectStatusPackFactory {
   public static DataPackage Make(int code,boolean isconnected){
       JSONObject data=new JSONObject();
       data.put("status",isconnected?1:0);
       DataPackage dataPackage=((DataPackage)new BasePack(DataType.connect,0));
       dataPackage.getJson().put("data",data);
       return dataPackage;
    }
}
