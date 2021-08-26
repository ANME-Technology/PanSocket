package net.mcqie.pss.console.commands;/*
 * @author by MCqie
 *@date 2021/8/11.
 */

import net.mcqie.pss.console.Command;

public class CommandTemple extends Command {
    protected static final String CommandString="";
    protected static final String brief="";
    protected static final String Name="";
    @Override
    public String getBrief() {
        return CommandString+"     ---"+"["+Name+"]"+brief;
    }

    @Override
    public boolean run(String[] com, int num) {
        return false;
    }
}
