package net.mcqie.pss.console.commands;/*
 * @author by MCqie
 *@date 2021/8/11.
 */

import net.mcqie.pss.PanSServer;
import net.mcqie.pss.console.Command;
import net.mcqie.pss.protocol.packfactory.MessagePackFactory;
import net.mcqie.pss.server.Client;
import net.mcqie.pss.server.ServerUtil;

import java.io.IOException;

public class SendMessageCommand extends Command {
    protected static final String CommandString="/send";
    protected static final String brief="发送消息";
    protected static final String Name="";
    @Override
    public String getBrief() {
        return CommandString+"     ---"+"["+Name+"]"+brief;
    }

    @Override
    public boolean run(String[] com, int num) {
        if(com[0].equalsIgnoreCase("/send")&&num==2){
            try {
                ServerUtil.sendDataToEvery(PanSServer.getServer(), MessagePackFactory.Make(0,com[1],"Server"));
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
                ServerUtil.sendDataToOne(c, MessagePackFactory.Make(0,com[2],"Server"));
                PanSServer.getConsole().info("发送完成",this.getClass().getSimpleName());
                return true;
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
