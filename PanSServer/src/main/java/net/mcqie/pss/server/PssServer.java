package net.mcqie.pss.server;

import net.mcqie.pss.PanSServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class PssServer extends ServerSocket{
    public static final int __ServerPort=7788;

    /**
     * 保护原有构造方法
     * @throws IOException
     */
    protected PssServer() throws IOException {
    }

    protected PssServer(int port) throws IOException {
        super(port);
    }

    protected PssServer(int port, int backlog) throws IOException {
        super(port, backlog);
    }

    protected PssServer(int port, int backlog, InetAddress bindAddr) throws IOException {
        super(port, backlog, bindAddr);
    }

    /**
     * 初始化服务器
     * @return
     * @throws IOException
     */
    public static PssServer init() throws IOException {
        PssServer pssServer= new PssServer(__ServerPort);
        return pssServer;
    }
}
