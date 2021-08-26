package net.mcqie.pss.protocol;/*
 * @author by MCqie
 *@date 2021/8/12.
 */

import com.alibaba.fastjson.JSONObject;

import javax.xml.crypto.Data;

public class DataPackage {
    JSONObject data=new JSONObject();
    public DataPackage(JSONObject json){
        this.data=json;
    }
    protected DataPackage(){
    }
    public static DataPackage parse(String message){
        JSONObject data=JSONObject.parseObject(message);
        return new DataPackage(data);
    }

    public JSONObject getJson() {

        return data;
    }
    @Override
    public String toString(){
        return data.toString();
    }
    public int getType(){
        return data.getInteger("type");
    }
    public int getCode(){
        return data.getInteger("code");
    }

}
