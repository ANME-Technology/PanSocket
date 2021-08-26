package net.mcqie.pss.server;/*
 * @author by MCqie
 *@date 2021/8/14.
 */

import com.alibaba.fastjson.JSONObject;
import net.mcqie.pss.Launch;
import net.mcqie.pss.PanSServer;
import net.mcqie.pss.console.Console;

import java.io.IOException;

public abstract class ClientMessageHandle {
    public abstract void Run(Client client,JSONObject msg,int type) throws IOException, Exception;
    public void Handle(Client client,JSONObject msg,int type){
        try{
            Run(client,msg,type);
        }catch (Exception e){
            if(Launch.debug){
                e.printStackTrace();
            }
            PanSServer.getConsole().err("存在错误",this.getClass().getSimpleName());
        }
    }
}
