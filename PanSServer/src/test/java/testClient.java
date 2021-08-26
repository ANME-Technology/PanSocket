import net.mcqie.pss.PanSServer;
import net.mcqie.pss.protocol.packfactory.MessagePackFactory;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class testClient {
    public static Socket socket;
    public static void main(String[] args) throws IOException {
//        socket = new Socket("81.68.179.134", 7788);
//        socket = new Socket("61.160.223.38", 35933);
        socket=new Socket("127.0.0.1",7788);
        OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
//        bw.write("HELLO!\r\n");
        bw.flush();

        Thread t = new Thread(() -> {
            try {
                InputStreamReader isr = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                while (true) {
                    String s = null;
                    try {
                        s = br.readLine();
                    } catch (SocketException e) {
                        PanSServer.getConsole().warn(socket.getInetAddress() + "连接丢失");
                        break;
                    }
                    if (s != null) {
                        System.out.println(s);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t.start();
        startConsole();
    }

    public static void startConsole() throws IOException {
        InputStreamReader inputStreamReader=new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader br=new BufferedReader(inputStreamReader);
        OutputStreamWriter osw=new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
        BufferedWriter bw=new BufferedWriter(osw);
        new Thread(()->{
            String s="";
            while(true){
                try {
                    s=br.readLine();
                    if(s!=null){
                        bw.write(MessagePackFactory.Make(0,s,"test")+"\r\n");
                        bw.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
