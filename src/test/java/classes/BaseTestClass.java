package classes;

import db.Neo4jConnection;
import misc.Configuration;
import misc.Environment;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BaseTestClass implements BeforeAllCallback {
  protected final Configuration configuration;

  public BaseTestClass() {
    configuration = new Configuration(new Environment());
  }

  @Override
  public void beforeAll(ExtensionContext extensionContext) {
    try (var connection = new Neo4jConnection(configuration)) {
      connection.flushDatabase("delete-all-nodes");
    }
  }
}
