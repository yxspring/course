package com.yxs.generator.server;

import com.yxs.generator.util.GeneratorUtil;
import freemarker.template.TemplateException;

import java.io.IOException;

public class GeneratorServer {
    static String toPath = "generator\\src\\main\\java\\com\\yxs\\generator\\test\\";
    public static void main(String[] args) throws IOException, TemplateException {
        GeneratorUtil.initConfig("test.ftl");
        GeneratorUtil.generator(toPath+"Test.java");
    }
}
