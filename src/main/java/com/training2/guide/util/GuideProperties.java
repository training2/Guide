package com.training2.guide.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class GuideProperties {

    static FileInputStream fis;
    static Properties properties = new Properties();

    public static String getURL(){
        String URL="";
        try {
            fis=new FileInputStream("src/main/resources/com.training2.guide/config.properties");
            properties.load(fis);

            URL = properties.getProperty("url");

            return URL;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return URL;
    }


    public static String getUsername(){
        String username="";
        try {

            fis=new FileInputStream("src/main/resources/com.training2.guide/config.properties");
            properties.load(fis);
            username = properties.getProperty("username");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return username;
    }

    public static String getPassword(){
        String password="";
        try {

            fis=new FileInputStream("src/main/resources/com.training2.guide/config.properties");
            properties.load(fis);
            password = properties.getProperty("password");
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return password;
    }
}
