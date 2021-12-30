package ecommerce.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * LoadProperties For loading the properties file
 * @author Vijay
 * Dec 29, 2021
 */
public class LoadProperties {
    /**
     * Load the properties file from the given file path
     * @param filePath
     * @return {@link java.util.Properties} instance.
     * @author Vijay
     * Dec 29, 2021
     */
    public static Properties loadProperties(String filePath) {
        Properties properties = new Properties();
        BufferedReader bufferedReader;
        try{
            bufferedReader = new BufferedReader(new FileReader(filePath));
            try{
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("failed to load the properties files located at :: " + filePath);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("required properties file not found at the given file path :: " + filePath);
        }
        return properties;
    }
}