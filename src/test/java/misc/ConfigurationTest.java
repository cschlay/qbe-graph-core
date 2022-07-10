package misc;

import classes.BaseTestClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ConfigurationTest extends BaseTestClass {
  @Test
  @DisplayName("Returns the connection string to graph database")
  void getGraphDatabaseconnectionString() {
    assertEquals("bolt://localhost:7687", configuration.getGraphDatabaseConnectionString());
  }

  @Test
  @DisplayName("Development mode defaults to false")
  void isDevelopment() {
    assertFalse(configuration.isDevelopment());
  }
}
