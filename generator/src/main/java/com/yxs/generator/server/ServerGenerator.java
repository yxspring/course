package com.yxs.generator.server;

import com.yxs.generator.util.FreemarkerUtil;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServerGenerator {
    static String MODULE="business";
    static String toServicePath = "server\\src\\main\\java\\com\\yxs\\server\\service\\";
    static String toControllerPath =MODULE+"\\src\\main\\java\\com\\yxs\\"+MODULE+"\\controller\\admin\\";
    public static void main(String[] args) throws IOException, TemplateException {
        String Domain="Section";
        String domain="section";
        String tableNameCn="小节";
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("Domain",Domain);
        map.put("domain",domain);
        map.put("tableNameCn",tableNameCn);
        map.put("module",MODULE);
        /*生成service*/
        FreemarkerUtil.initConfig("service.ftl");
        FreemarkerUtil.generator(toServicePath+Domain+"Service.java",map);
        /*生成controller*/
        FreemarkerUtil.initConfig("controller.ftl");
        FreemarkerUtil.generator(toControllerPath+Domain+"Controller.java",map);
    }
}
