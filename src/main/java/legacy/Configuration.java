package legacy;

public class Configuration {

    public static String getCustomersUrl() {
        // Read from local file-system or database
        //We do not have the sourcecode for this class ;)
        return "http://localhost:8080/customers";
    }
}