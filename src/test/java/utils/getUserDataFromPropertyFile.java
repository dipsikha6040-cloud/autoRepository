package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class getUserDataFromPropertyFile {
    static Properties prop;
    public static Properties loadProperties() throws IOException {
        prop=new Properties();
        //fileinputstream is used to read data from property file
        //fileoutputstream is used to set the data in property file

        FileInputStream file=new FileInputStream("src/test/resources/property/userData.properties");
        prop.load(file);
        return prop;

    }
}
