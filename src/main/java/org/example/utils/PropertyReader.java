package org.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    //Read the browser = chrome  --> Give to drivermanager

    public PropertyReader() {
    }

    public static String readKey(String key) {
        FileInputStream fileInputStream = null;
        Properties p = null;
        try {
            // /Users/promode/IdeaProjects/ATB7xWebAutomationFramework
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data.property");
            p = new Properties();
            p.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return p.getProperty(key);
    }


}
