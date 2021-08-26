package net.mcqie.pss.console.commands;/*
 * @author by MCqie
 *@date 2021/8/11.
 */

import net.mcqie.pss.PanSServer;
import net.mcqie.pss.console.Command;

public class AnyCommand extends Command {
    protected static final String CommandString="/Hello";
    protected static final String brief="一个测试插件";
    protected static final String Name="HelloWorld";
    @Override
    public String getBrief() {
        return CommandString+"     ---"+"["+Name+"]"+brief;
    }

    @Override
    public boolean run(String[] com, int num) {
        if(num==1&&com[0].equalsIgnoreCase("/Hello")){
            PanSServer.getConsole().info("你好 控制台！",this.getClass().getSimpleName());
            return true;
        }
        return false;
    }
}
