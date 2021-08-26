package net.mcqie.pss.console;/*
 * @author by MCqie
 *@date 2021/8/11.
 */

import net.mcqie.pss.PanSServer;

import java.util.ArrayList;;

public class CommandHandler {
    ArrayList<Command> commands=new ArrayList<>();
    ArrayList<String> refs =new ArrayList<>();

    /**
     * 处理指令
     * @param com 指令
     * @return 是否处理
     */
    public boolean Handle(String com){
        String[] coms=com.split(" ");
        boolean ref=false;
        if(coms[0].equals("/help") || coms[0].equals("?")){
            ref=true;
            for (Command command : commands) {
                PanSServer.getConsole().info(command.getBrief());
            }
        }else {
            for (Command command : commands) {
                {
                    if (command.run(coms, coms.length)) {
                        ref = true;
                        refs.add(command.getClass().getSimpleName());
                    }
                }
            }
        }
        if(ref){
            PanSServer.getConsole().info("指令运行完成");
            int i = 1;
            for (String e : refs) {
                PanSServer.getConsole().info(i + ":" + e.toString());
            }
            refs.clear();
        }else{
            PanSServer.getConsole().warn("未能找到此指令 输入/help 或 ?获取已安装的指令信息");
        }
        return (ref);
    }

    /**
     * 注册指令
     * @param com 指令实例
     */
    public void regist(Command com){
        commands.add(com);
    }
}
