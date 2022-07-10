package misc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
  private final Properties properties = new Properties();

  public Configuration() {
    this("src/main/resources/config.properties");
  }

  public Configuration(String configurationFilePath) {
    try (var configurationInputStream = new FileInputStream(configurationFilePath)) {
      properties.load(configurationInputStream);
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  public String getGraphDatabaseConnectionString() {
    return properties.getProperty("GRAPH_DATABASE_CONNECTION_STRING");
  }

  public boolean isDevelopment() {
    return properties.getProperty("ENVIRONMENT").equals("development");
  }
}
