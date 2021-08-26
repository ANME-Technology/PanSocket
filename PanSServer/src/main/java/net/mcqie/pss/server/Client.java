package net.mcqie.pss.server;/*
 * @author by MCqie
 *@date 2021/8/11.
 */

import java.net.Socket;

public class Client {
    int index;

    Socket socket;
    Thread listener;
    boolean response;
    String name="UNKNOWN";

    public Client(Socket socket) {
        this.socket = socket;

        this.index=0;
        this.name="UNKNOWN";
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public Socket getSocket() {
        return socket;
    }

    public Thread getListener() {
        return listener;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setListener(Thread listener) {
        this.listener = listener;
    }
    public void close(){
        listener.stop();
    }
}
