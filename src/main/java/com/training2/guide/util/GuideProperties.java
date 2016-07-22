package com.training2.guide.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class GuideProperties {

    private static FileInputStream fis;
    private static Properties properties = new Properties();

    private static String PROPERTIES_FILE_NAME = "src/main/resources/com.training2.guide/config.properties";

    public static String getParameter(String parameterName){
        String parameter="";
        try {
            fis=new FileInputStream(PROPERTIES_FILE_NAME);
            properties.load(fis);
            parameter = properties.getProperty(parameterName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parameter;
    }
}
