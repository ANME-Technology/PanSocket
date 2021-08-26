package net.mcqie.pss.server;/*
 * @author by MCqie
 *@date 2021/8/11.
 */

import com.alibaba.fastjson.JSONObject;
import net.mcqie.pss.PanSServer;
import net.mcqie.pss.protocol.BasePack;
import net.mcqie.pss.protocol.DataPackage;
import net.mcqie.pss.protocol.DataType;
import net.mcqie.pss.server.listeners.ClientRegist;
import net.mcqie.pss.server.listeners.MessageListener;
import net.mcqie.pss.server.listeners.Printer;
import net.mcqie.pss.server.listeners.ServerBot;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Server {
    PssServer pss;
    ClientArray clientArray;
    ServerListener serverListener;
    /**
     * 服务器实例 用于构造服务器
     * @throws IOException
     */
    public Server() throws IOException {
        PanSServer.getConsole().info("正在启动服务器");
        pss= PssServer.init();
        clientArray=new ClientArray();
        serverListener=new ServerListener();
        serverListener.lh.regist(new Printer());
        serverListener.lh.regist(new ClientRegist());
        serverListener.lh.regist(new MessageListener());
        serverListener.lh.regist(new ServerBot());
        new Thread(()->{
            while(true){
                try {
                    Socket socket=pss.accept();
                    PanSServer.getConsole().info(socket.getInetAddress()+"用户已连接");
                    clientArray.add(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        serverBeat();
        PanSServer.getConsole().info("心跳包就绪！");
        PanSServer.getConsole().info("服务器已启动！");

    }

    public ClientArray getClientArray() {
        return clientArray;
    }

    public static void serverBeat(){
        Timer t=new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                JSONObject beatbase=new BasePack(DataType.beat,0).getJson();
                JSONObject b=new JSONObject();
                b.put("time",new Date().getTime());
                beatbase.put("data",b);
                try {
                    ServerUtil.sendDataToEvery(PanSServer.getServer(),new DataPackage(beatbase));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        },0,10000);

    }
}
