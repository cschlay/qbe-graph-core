package _classes;

import db.Neo4jConnection;
import misc.Configuration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BaseTestClass implements BeforeAllCallback {
  protected final Configuration configuration;

  public BaseTestClass() {
    configuration = new Configuration();
  }

  @Override
  public void beforeAll(ExtensionContext extensionContext) {
    try (var connection = new Neo4jConnection(configuration)) {
      connection.flushDatabase("delete-all-nodes");
    }
  }
}
