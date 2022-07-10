package db;

import interfaces.GraphDatabaseConnectable;
import misc.Configuration;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;

import java.util.function.Function;

public class Neo4jConnection implements GraphDatabaseConnectable {
  private final Driver driver;

  public Neo4jConnection(Configuration configuration) {
    driver = GraphDatabase.driver(configuration.getGraphDatabaseConnectionString());
  }

  public int getNodeCount() {
    return executeTransaction(
        tx -> tx.run("MATCH () RETURN count(*) as count").single().get(0).asInt());
  }

  public void flushDatabase(String safeWord) {
    if (safeWord.equals("delete-all-nodes")) {
      executeTransaction(tx -> tx.run("MATCH (node) DETACH DELETE node"));
    }
  }

  @Override
  public void close() {
    driver.close();
  }

  private <T> T executeTransaction(Function<Transaction, T> callback) {
    try (Session session = driver.session()) {
      return session.writeTransaction(callback::apply);
    }
  }
}
