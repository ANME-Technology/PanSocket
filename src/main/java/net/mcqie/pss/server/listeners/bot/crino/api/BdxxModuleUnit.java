package net.mcqie.pss.server.listeners.bot.crino.api;

import java.io.IOException;

public class BdxxModuleUnit {
    String id;
    String module;
    String desc;
    String brand_name;
    String update_time;

    public BdxxModuleUnit(String id, String module, String desc, String brand_name, String update_time) {
        this.id = id;
        this.module = module;
        this.desc = desc;
        this.brand_name = brand_name;
        this.update_time = update_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "名称:" + module + '\'' +
                ", 生产厂商:" + brand_name + '\'' +
                ", 更新日期:" + update_time + '\'';

    }

    public String AllInfo() throws IOException {
        return "名称:" + module + "\r\n" +
                "生产厂商:" + brand_name + "\r\n" +
                "id:" + id + "\r\n" +
                "描述:" + desc + "\r\n" +
                "相关文档:" + Bdxx.getpdf(id) + "\r\n" ;


    }
}
