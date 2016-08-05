/**
 * This class return string from property file
 * @author Kirill Bugrim on 20.07.2016.
 * version 1.1
 */

package com.training2.guide.util;
import com.sun.org.apache.bcel.internal.util.ClassLoader;
import com.training2.guide.dao.jdbc.mysql.utils.DAOFactory;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class GuideProperties {

    private static final Logger LOG = Logger.getLogger(DAOFactory.class);

    private static InputStream inputStream = null;
    private static Properties properties = new Properties();

    private static String PROPERTIES_FILE_NAME = "/config.properties";

    public static String getParameter(String parameterName){
        String parameter="";
        try {
            inputStream = GuideProperties.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
            properties.load(inputStream);
            parameter = properties.getProperty(parameterName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parameter;
    }
}
