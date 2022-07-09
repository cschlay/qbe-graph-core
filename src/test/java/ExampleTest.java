import db.Example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExampleTest {
  @Test
  void test() {
    var result = new Example().test();
    Assertions.assertEquals(1, result);
  }
}
