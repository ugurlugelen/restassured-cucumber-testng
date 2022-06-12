package io.testexample.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class JavaUtils {
    private static FileInputStream fileInputStream;
    private static FileOutputStream fileOutputStream;

    public static void setBaseURI(String baseURI){

        try {
            fileInputStream = new FileInputStream("configuration.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.setProperty("baseURI", baseURI);
        try {
            fileOutputStream = new FileOutputStream("configuration.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.store(fileOutputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
