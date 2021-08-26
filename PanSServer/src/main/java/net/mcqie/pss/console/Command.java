package net.mcqie.pss.console;/*
 * @author by MCqie
 *@date 2021/8/11.
 */

import java.util.ArrayList;

public abstract class Command implements Helpable{
    public abstract String getBrief();

    /**
     * 指令运行代码
     * @param com 指令
     * @param num 指令长度
     * @return
     */
    public abstract boolean run(String[] com,int num);

    @Override
    /**
     * 获取帮助
     */
    public String gethelp() {
        return null;
    }
}
