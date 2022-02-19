package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        String filePath = "config.properties"; //fileName

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath); //To handle and read the file
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e){
            e.printStackTrace(); // in case of exception it will be caught
        }
    }

    public static String getProperty(String key){ // Method to read the file(will be used on Driver class)
        return properties.getProperty(key); //It will return the info from the file
    }
}