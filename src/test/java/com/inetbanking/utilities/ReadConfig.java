package com.inetbanking.utilities;

import com.aventstack.extentreports.gherkin.model.ScenarioOutline;
import org.apache.commons.io.input.MemoryMappedFileInputStream;

import java.io.*;
import java.util.Properties;

public class ReadConfig
{
    //We have create the one object for Properties class
    Properties properties;

    public ReadConfig()
    {
        File src = new File("./Configurations/config.properties");

        try{
            FileInputStream fis = new FileInputStream(src);
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

//    private Properties properties;
//    private final String propertyFilePath= "./Configurations/config.properties";
//
//
//    public ReadConfig()
//    {
//        BufferedReader reader;
//        try {
//            reader = new BufferedReader(new FileReader(propertyFilePath));
//            properties = new Properties();
//            properties.load(reader);
//            //reader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            }
//    }


    public String getApplicationUrl()
    {
        String url = properties.getProperty("baseURL");
        return url;
    }

    public String getUsername()
    {
        String username = properties.getProperty("username");
        return username;
    }

    public String getPassword()
    {
        String password = properties.getProperty("password");
        return password;
    }

    public String getFirefoxPath()
    {
        String firefoxpath = properties.getProperty("firefoxpath");
        return firefoxpath;
    }



}
