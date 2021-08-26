package net.mcqie.pss.protocol;/*
 * @author by MCqie
 *@date 2021/8/12.
 */

import com.alibaba.fastjson.JSONObject;

import javax.xml.crypto.Data;

/**
 * JSON
 * - type Data Type 类型
 * — data JsonObject 数据
 * - code int 状态  0 1 2 / I W E
 */
public class BasePack extends DataPackage{
    public BasePack(DataType type, int Code) {
        JSONObject json=new JSONObject();
        json.put("type",type.toString());
        json.put("code",Code);
        data=json;
    }
    public JSONObject getJson(){
        return data;
    }
}
