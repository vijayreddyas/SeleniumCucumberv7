package ecommerce.helpers;

import java.util.Properties;

/**
 * LoadConfigs uses singleton pattern to control object creation, limiting the number of objects to only one
 * For loading the config details from the properties file
 * @author Vijay
 * Dec 29, 2021
 */
public class LoadConfigs {
    private final Properties properties;
    //Private static variable of the same class that is the only instance of the class.
    private static LoadConfigs loadConfigs;

    /**
     * Private constructor to restrict instantiation of the class from other classes
     * @author Vijay
     * Dec 29, 2021
     */
    private LoadConfigs() {
        properties = LoadProperties.loadProperties("src/test/resources/configs/application.properties");
    }

    /**
     * Public static method that returns the instance of the class, this is the global access point for outer world to get the instance of the singleton class.
     * @author Vijay
     * Dec 29, 2021
     */
    public static LoadConfigs getInstance() {
        if (loadConfigs == null) {
            loadConfigs = new LoadConfigs();
        }
        return loadConfigs;
    }

    /**
     * Get the url from properties file
     * @author Vijay
     * Dec 29, 2021
     */
    public String getUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else
            throw new RuntimeException("url property is not specified in the application_properties file");
    }

    /**
     * Get the browser from properties file
     * @author Vijay
     * Dec 29, 2021
     */
    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser != null) return browser;
        else
            throw new RuntimeException("browser property is not specified in the application_properties file");
    }

    /**
     * Get the runType from properties file
     * @author Vijay
     * Dec 29, 2021
     */
    public String getRunType() {
        String runType = properties.getProperty("runType");
        if (runType != null) return runType;
        else
            throw new RuntimeException("runType property is not specified in the application_properties file");
    }

    /**
     * Get the host from properties file
     * @author Vijay
     * Dec 29, 2021
     */
    public String getHost() {
        String host = properties.getProperty("host");
        if (host != null) return host;
        else
            throw new RuntimeException("host property is not specified in the application_properties file");
    }

    /**
     * Get the port from properties file
     * @author Vijay
     * Dec 29, 2021
     */
    public String getPort() {
        String port = properties.getProperty("port");
        if (port != null) return port;
        else
            throw new RuntimeException("port property is not specified in the application_properties file");
    }

    /**
     * Get the grid bind exception timeout from properties file
     * @author Vijay
     * Dec 29, 2021
     */
    public String getBindExceptionTimeOut(String defaultBindExceptionTimeOut) {
        String bindExceptionTimeOut = properties.getProperty("bindExceptionTimeOut", defaultBindExceptionTimeOut);
        if (bindExceptionTimeOut != null) return bindExceptionTimeOut;
        else
            throw new RuntimeException("bindExceptionTimeOut property is not specified in the application_properties file");
    }
}