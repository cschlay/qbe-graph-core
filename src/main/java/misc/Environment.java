package misc;

public class Environment {
    public static final String DEBUG = "DEBUG";
    public static final String GRAPH_DATABASE_CONNECTION_STRING = "GRAPH_DATABASE_CONNECTION_STRING";

    public String getValue(String key) {
        return System.getenv(key);
    }
}
