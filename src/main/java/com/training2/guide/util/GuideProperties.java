/**
 * This class return string from property file
 * @author Kirill Bugrim on 20.07.2016.
 * version 1.1
 */

package com.training2.guide.util;
import com.training2.guide.dao.jdbc.mysql.utils.DAOFactory;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class GuideProperties {

    private static final Logger LOG = Logger.getLogger(DAOFactory.class);

    private static FileInputStream fis;
    private static Properties properties = new Properties();

    private static String PROPERTIES_FILE_NAME = "src/main/resources/com/training2/guide/config.properties";

    public static String getParameter(String parameterName){
        String parameter="";
        try {
            fis= FileInput.getInstance(PROPERTIES_FILE_NAME);
            properties.load(fis);
            parameter = properties.getProperty(parameterName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parameter;
    }
}
