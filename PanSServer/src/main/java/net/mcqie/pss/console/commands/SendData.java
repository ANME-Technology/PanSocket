package net.mcqie.pss.console.commands;/*
 * @author by MCqie
 *@date 2021/8/14.
 */

import net.mcqie.pss.PanSServer;
import net.mcqie.pss.console.Command;
import net.mcqie.pss.protocol.packfactory.MessagePackFactory;
import net.mcqie.pss.server.Client;
import net.mcqie.pss.server.ServerUtil;

import java.io.IOException;

public class SendData extends Command {
    protected static final String CommandString="/senddata";
    protected static final String brief="发送数据";
    protected static final String Name="";
    @Override
    public String getBrief() {
        return CommandString+"     ---"+"["+Name+"]"+brief;
    }

    @Override
    public boolean run(String[] com, int num) {
        if(com[0].equalsIgnoreCase("/send")&&num==2){
            try {
                ServerUtil.sendMessageToEvery(PanSServer.getServer(), com[1]);
                PanSServer.getConsole().info("发送完成",this.getClass().getSimpleName());
                return true;
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(com[0].equalsIgnoreCase("/send")&&num==3){
            Client c=null;
            for (Client socket : PanSServer.getServer().getClientArray().sockets) {
                if(socket.getName().equals(com[1])){
                    c=socket;
                }
            }
            if(c==null){
                PanSServer.getConsole().info("无此人信息");
                return true;
            }
            try {
                ServerUtil.sendMessageToOne(c,com[2]);
                PanSServer.getConsole().info("发送完成",this.getClass().getSimpleName());
                return true;
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return false;
    }

}
