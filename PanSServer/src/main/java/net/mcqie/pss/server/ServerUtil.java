package net.mcqie.pss.server;/*
 * @author by MCqie
 *@date 2021/8/11.
 */

import net.mcqie.pss.PanSServer;
import net.mcqie.pss.protocol.DataPackage;
import sun.misc.Cleaner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

public class ServerUtil {

    public static void sendMessageToOne(Client client,String message) throws IOException {
        OutputStreamWriter osw=new OutputStreamWriter(client.getSocket().getOutputStream(), StandardCharsets.UTF_8);
        BufferedWriter bw=new BufferedWriter(osw);
        message=message;
        bw.write(message+"\r\n");
        bw.flush();
    }
    public static void sendMessageToEvery(Server server,String message) throws IOException {
        for (Client client : server.clientArray.sockets) {
            try {
                sendMessageToOne(client,message);
            }catch (Exception e){
                client.getListener().stop();
                closeClient(client);
            }
        }
    }
    public static void sendDataToOne(Client client, DataPackage message) throws IOException {
        OutputStreamWriter osw=new OutputStreamWriter(client.getSocket().getOutputStream(), StandardCharsets.UTF_8);
        BufferedWriter bw=new BufferedWriter(osw);
        String message2=message.toString();
        bw.write(message2+"\r\n");
        bw.flush();
    }
    public static void sendDataToEvery(Server server,DataPackage message) throws IOException {
        for (Client client : server.clientArray.sockets) {
            try {
                sendDataToOne(client,message);
            }catch (Exception e){
                client.getListener().stop();
                closeClient(client);
            }
        }
    }
    public static void closeClient(Client client){
        Client willremove;
        new Thread(()-> {
            Iterator<Client> iterator = PanSServer.getServer().getClientArray().sockets.iterator();
            while (iterator.hasNext()) {
                Client c = iterator.next();
                if (c.equals(client))
                    iterator.remove();   //??????????????????
            }
        }).start();
       }
    public static boolean isServerClose(Socket socket){
        try{
            socket.sendUrgentData(0xFF);//??????1???????????????????????????????????????????????????????????????????????????????????????????????????????????????
            return false;
        }catch(Exception se){
            return true;
        }
    }
}

