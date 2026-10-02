package com.utility;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReaderManager {
    public static Properties properties;
public static String fileReaderManager;

    public static String fileReaderManager(String propertyKey) {
        File file = new File("D:\\WorkSpace\\Naukri\\src\\main\\resources\\Test.properties");
        String value =null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            value = properties.getProperty(propertyKey);
        } catch (Exception e) {
            Assert.fail("Error");
        }
        return value;
    }
}
