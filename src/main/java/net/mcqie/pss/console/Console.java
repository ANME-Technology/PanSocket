
package net.mcqie.pss.console;

import net.mcqie.pss.console.commands.AnyCommand;
import net.mcqie.pss.console.commands.SendMessageCommand;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;


/**
 * @author MCqie
 * @date
 */
public class Console {
    CommandHandler commandHandler=new CommandHandler();
    private Date date=new Date();
    //定义格式
    public static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //控制台名称
    public String ConsoleName;

    public String getTime() {
        date=new Date();
        return "["+sdf.format(date)+"]";
    }
    /**
     * 使用名称实例化控制台
     * @param Consolename 控制台名称
     */
    public Console(String Consolename){
        this.ConsoleName=Consolename;
        commandHandler.regist(new AnyCommand());
        commandHandler.regist(new SendMessageCommand());
    }

    /**
     * 使用默认名称实例化控制台
     */
    public Console(){
        new Console("System");
    }
    public FileWriter fw;
    public void startConsole() throws IOException {
        File fp=new File("log");
        if(!fp.exists()){
            fp.mkdir();
        }
        File f=new File("log\\"+new Date().getTime()+".log");
        f.createNewFile();
        fw=new FileWriter(f);


        InputStreamReader inputStreamReader=new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader br=new BufferedReader(inputStreamReader);
        new Thread(()->{
            String s="";
            while(true){
                try {
                    s=br.readLine();
                    if(s!=null){
                        commandHandler.Handle(s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    /**
     * 获取基本打印信息
     * @param s 打印信息
     * @return  打印信息
     */
    protected String getBaseMessage(String s){
        return (getTime()+":"+s);
    }

    /**
     * 打印信息
     * @param s 信息
     * @param form 来源
     */
    public void info(String s,String form){
        String O="[info]["+form+"]"+getBaseMessage(s);
        System.out.println(O);
        try {
            fw.write(O + "\r\n");
            fw.flush();
        }catch (Exception e){
            errNoLog("打印info失败");
        }
    }

    private void errNoLog(String form) {
        String O="[err]["+ConsoleName+"]"+getBaseMessage(form);
        System.out.println(O);
    }

    /**
     * 打印信息
     * @param s 信息
     */
    public void info(String s){
      info(s,ConsoleName);
    }

    /**
     * 打印错误信息
     * @param s 错误信息
     * @param form 来源
     */
    public void err(String s,String form){
        String O="[err]["+form+"]"+getBaseMessage(s);
        System.out.println(O);
        try {
            fw.write(O + "\r\n");
            fw.flush();
        }catch (Exception e){
            errNoLog("打印error失败");
        }
    }

    /**
     * 打印错误信息
     * @param s 错误信息
     */
    public void err(String s){
       err(s,ConsoleName);
    }

    /**
     * 打印警告信息
     * @param s 警告信息
     * @param form 来源
     */
    public void warn(String s,String form){
        String O="[warn]["+form+"]"+getBaseMessage(s);
        System.out.println(O);
        try {
            fw.write(O + "\r\n");
            fw.flush();
        }catch (Exception e){
            errNoLog("打印warn失败");
        }
    }

    /**
     * 打印警告信息
     * @param s 信息
     */
    public void warn(String s){
        warn(s,ConsoleName);


    }

}
