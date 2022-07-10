package misc;

import classes.BaseTestClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ConfigurationTest extends BaseTestClass {
  @Test
  @DisplayName("Returns the connection string to graph database")
  void getGraphDatabaseConnectionString() {
    assertEquals("bolt://localhost:7687", configuration.getGraphDatabaseConnectionString());
  }

  @Test
  @DisplayName("Development mode defaults to false")
  void isDevelopmentReturnsFalse() {
    assertFalse(configuration.isDevelopment());
  }

  @Test
  @DisplayName("Development mode is true when DEBUG=true")
  void isDevelopmentReturnsTrue() {
    Environment mockEnvironment = mock(Environment.class);
    when(mockEnvironment.getValue(Environment.DEBUG)).thenReturn("true");

    var configuration = new Configuration(mockEnvironment);
    assertTrue(configuration.isDevelopment());
  }
}
