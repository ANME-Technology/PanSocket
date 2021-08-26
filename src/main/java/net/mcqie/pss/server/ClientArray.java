package net.mcqie.pss.server;/*
 * @author by MCqie
 *@date 2021/8/11.
 */

import net.mcqie.pss.PanSServer;
import net.mcqie.pss.protocol.packfactory.ConnectStatusPackFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ClientArray {
        int index=0;
    public ArrayList<Client> sockets = new ArrayList<>();

    /**
     * 添加客户
     *
     * @param socket 客户
     */
    public void add(Socket socket) throws IOException {
        index++;
        Client client=new Client(socket);
        client.setIndex(index);
        Thread t = new Thread(() -> {
            try {
                InputStreamReader isr = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                while (true) {
                    String s = null;
                    try {
                        s = br.readLine();
                    } catch (SocketException e) {
                        PanSServer.getConsole().warn(socket.getInetAddress()+"连接丢失");
                        break;
                    }
                    if (s != null) {
                        PanSServer.getServer().serverListener.ListenerHandler(client, s);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        },"Client"+index);
        sockets.add(client);
        client.setListener(t);
        t.start();

        ServerUtil.sendMessageToOne(client, ConnectStatusPackFactory.Make(0,true).toString());

    }
}
