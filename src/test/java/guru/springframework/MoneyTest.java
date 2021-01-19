package guru.springframework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class MoneyTest {

  @Test
  void testMultiplicationDollar() {
    Dollar five = new Dollar(5);
    Dollar product = five.times(2);
    assertEquals(new Dollar(10), product);
    product = five.times(3);
    assertEquals(new Dollar(15), product);
    assertNotEquals(new Dollar(5), new Franc(5));
  }

  @Test
  void testEqualityDollar() {
    assertEquals(new Dollar(5), new Dollar(5));
    assertNotEquals(new Dollar(5), new Dollar(8));
  }


  @Test
  void testMultiplicationFranc() {
    Franc five = new Franc(5);
    Franc product = five.times(2);
    assertEquals(new Franc(10), product);
    product = five.times(3);
    assertEquals(new Franc(15), product);
  }

  @Test
  void testEqualityFranc() {
    assertEquals(new Franc(5), new Franc(5));
    assertNotEquals(new Franc(5), new Franc(8));
  }
}

