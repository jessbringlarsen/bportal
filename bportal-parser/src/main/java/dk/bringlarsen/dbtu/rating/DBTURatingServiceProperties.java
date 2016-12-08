package dk.bringlarsen.dbtu.rating;

import java.util.Properties;

public class DBTURatingServiceProperties {
    private static final String PROPERTIES_FILE = "DBTURatingServices-config.properties";
    private Properties properties = new Properties();

    String getDBTURatingPageURL() {
        return properties.getProperty("dbtuRatingPageURL");
    }

    String getDBTURatingPrintPageURL() {
        return getDBTURatingPageURL() + properties.getProperty("dbtuRatingPrintPageURL");
    }
}
