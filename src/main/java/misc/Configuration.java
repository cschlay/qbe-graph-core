package misc;

import org.jetbrains.annotations.Nullable;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.function.Function;

public class Configuration {
  private final Properties properties = new Properties();
  private final Environment environment;

  public Configuration(Environment environment) {
    this(environment, "src/main/resources/config.properties");
  }

  public Configuration(Environment environment, String configurationFilePath) {
    this.environment = environment;
    try (var configurationInputStream = new FileInputStream(configurationFilePath)) {
      properties.load(configurationInputStream);
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  public String getGraphDatabaseConnectionString() {
    return readProperty(Environment.GRAPH_DATABASE_CONNECTION_STRING);
  }

  public boolean isDevelopment() {
    return readProperty(Environment.DEBUG, Boolean::parseBoolean);
  }

  private String readProperty(String key) {
    @Nullable String environmentVariable = environment.getValue(key);
    if (environmentVariable != null) {
      return environmentVariable;
    }
    return properties.getProperty(key);
  }

  private <T> T readProperty(String key, Function<String, T> typeCast) {
    return typeCast.apply(readProperty(key));
  }
}
