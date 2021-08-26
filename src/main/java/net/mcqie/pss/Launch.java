package net.mcqie.pss;

import net.mcqie.pss.server.listeners.bot.crino.Bot;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Launch {
    public static final boolean debug=true;
    public static final boolean UseBot =true;
    public static void main(String[] args) throws IOException {
        PanSServerLauncher.ServerStart();
    }
}
