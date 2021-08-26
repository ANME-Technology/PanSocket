package net.mcqie.pss.server.listeners.bot.crino;/*
 * @author by MCqie
 *@date 2021/8/14.
 */

import net.mcqie.pss.PanSServer;
import net.mcqie.pss.protocol.packfactory.MessagePackFactory;
import net.mcqie.pss.server.Client;
import net.mcqie.pss.server.ServerUtil;
import net.mcqie.pss.server.listeners.bot.NativeBot;
import net.mcqie.pss.server.listeners.bot.crino.api.Bdxx;
import net.mcqie.pss.server.listeners.bot.crino.api.BdxxModuleUnit;

import java.util.ArrayList;
import java.util.HashMap;

public class Bot extends NativeBot {
    HashMap<Integer,ArrayList<BdxxModuleUnit>> infomap= new HashMap<>();
    @Override
  public void  Run(Client c, String message) throws Exception {
      String[] coms= message.split(" ");
      if(coms[0].toUpperCase().equals("SEARCH")&&coms.length==3){ //search XX XX
          StringBuilder a=new StringBuilder();
          ArrayList<BdxxModuleUnit> t = Bdxx.SerachModuleByName(coms[1], Integer.parseInt(coms[2]));
          if(t.size()<1){
             ServerUtil.sendDataToEvery(PanSServer.getServer(), MessagePackFactory.Make(0,"此页无信息或不存在","Cirno"));
          }else{
              int i=0;
              for (BdxxModuleUnit bdxxModuleUnit : t) {
                  i++;
                  a.append(i+"."+bdxxModuleUnit.toString()+"\r\n");
              }
              infomap.put(c.getIndex(),t);
              ServerUtil.sendDataToEvery(PanSServer.getServer(), MessagePackFactory.Make(0,a.toString(),"Cirno"));
          }
      }

      if(coms[0].toUpperCase().equals("PICK")&&coms.length==2){
          if(infomap.keySet().contains(c.getIndex())){
              ArrayList<BdxxModuleUnit> a = infomap.get(c.getIndex());
              if (a != null) {
                  ServerUtil.sendDataToEvery(PanSServer.getServer(), MessagePackFactory.Make(0,a.get(Integer.parseInt(coms[1])-1).AllInfo(),"Cirno"));
              };
          }else{
              ServerUtil.sendDataToEvery(PanSServer.getServer(), MessagePackFactory.Make(0,"请先输入 Search <芯片> <页码> 再选择操作对象","Cirno"));
          }
      }
  }

}
