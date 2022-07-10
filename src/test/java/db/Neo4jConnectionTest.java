package db;

import classes.BaseTestClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class Neo4jConnectionTest extends BaseTestClass {
  @Test
  @DisplayName("Test Neo4j Connection")
  void testConnection() {
    try (var connection = new Neo4jConnection(configuration)) {
      assertEquals(0, connection.getNodeCount());
    } catch (Exception e) {
      fail("Failed to connect, ensure that database is running and connection string is correct.");
    }
  }
}
