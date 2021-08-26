package net.mcqie.pss.server.listeners.bot.crino.api;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Bdxx {
    public static ArrayList<BdxxModuleUnit> SerachModuleByName(String name,int page) throws IOException {
        String html= JsoupUtil.Jsoup_fangfa("https://www.semiee.com/bdxx-api/chip/search?pageIndex="+page+"&pageSize=10&model="+name);
        System.out.println(html);
        JSONObject jsonMeta= (JSONObject) JSONObject.parse(html);
        JSONArray ja=jsonMeta.getJSONArray("result");
        ArrayList<BdxxModuleUnit> dbs=new ArrayList<>();
        for(Object a:ja){
            JSONObject unit= (JSONObject) a;
            BdxxModuleUnit db=new BdxxModuleUnit(
                    unit.getString("id"),
                    unit.getString("model"),
                    unit.getString("descr"),
                    unit.getString("brand_name"),
                    unit.getString("update_time")
            );
            dbs.add(db);
        }
        return dbs;
    }
    public static String  getpdf(String id) throws IOException {
//        Document doc = Jsoup.connect("http://www.semiee.com/" + id + ".html").get();
        StringBuilder sb=new StringBuilder();
        Document doc = Jsoup.parse(JsoupUtil.gethtmlAdv("http://www.semiee.com/"+id+".html"));
        Elements e1 = doc.getElementsByClass("downloadFile");
        int i=0;
        for (Element te : e1) {
            for(Element tee :te.getElementsByTag("a")){
                i++;
                sb.append(i+".  "+tee.attr("href")+"\r\n");
            }
        }
    return sb.toString();
}
    public static void main(String[] args) throws IOException {
//       for(BdxxModuleUnit u:Bdxx.SerachModuleByName("AT",1)){
//           System.out.println(u.toString());
//       };
        System.out.println(getpdf("000bc245-b96a-498c-bc1c-54fb22460743"));
    }
}
