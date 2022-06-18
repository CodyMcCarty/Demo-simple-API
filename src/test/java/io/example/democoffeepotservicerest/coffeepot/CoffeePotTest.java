package io.example.democoffeepotservicerest.coffeepot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CoffeePotTest {

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link CoffeePot#CoffeePot()}
   *   <li>{@link CoffeePot#setAge(int)}
   *   <li>{@link CoffeePot#setBrand(String)}
   *   <li>{@link CoffeePot#setId(Long)}
   *   <li>{@link CoffeePot#setReleaseDate(LocalDate)}
   *   <li>{@link CoffeePot#setSku(String)}
   *   <li>{@link CoffeePot#getBrand()}
   *   <li>{@link CoffeePot#getId()}
   *   <li>{@link CoffeePot#getReleaseDate()}
   *   <li>{@link CoffeePot#getSku()}
   * </ul>
   */
  @Test
  void testConstructor() {
    // Arrange and Act
    CoffeePot actualCoffeePot = new CoffeePot();
    actualCoffeePot.setAge(1);
    actualCoffeePot.setBrand("Brand");
    actualCoffeePot.setId(123L);
    LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
    actualCoffeePot.setReleaseDate(ofEpochDayResult);
    actualCoffeePot.setSku("Sku");

    // Assert
    assertEquals("Brand", actualCoffeePot.getBrand());
    assertEquals(123L, actualCoffeePot.getId().longValue());
    assertSame(ofEpochDayResult, actualCoffeePot.getReleaseDate());
    assertEquals("Sku", actualCoffeePot.getSku());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link CoffeePot#CoffeePot(String, String, LocalDate)}
   *   <li>{@link CoffeePot#setAge(int)}
   *   <li>{@link CoffeePot#setBrand(String)}
   *   <li>{@link CoffeePot#setId(Long)}
   *   <li>{@link CoffeePot#setReleaseDate(LocalDate)}
   *   <li>{@link CoffeePot#setSku(String)}
   *   <li>{@link CoffeePot#getBrand()}
   *   <li>{@link CoffeePot#getId()}
   *   <li>{@link CoffeePot#getReleaseDate()}
   *   <li>{@link CoffeePot#getSku()}
   * </ul>
   */
  @Test
  void testConstructor2() {
    // Arrange and Act
    CoffeePot actualCoffeePot = new CoffeePot("Brand", "Sku", LocalDate.ofEpochDay(1L));
    actualCoffeePot.setAge(1);
    actualCoffeePot.setBrand("Brand");
    actualCoffeePot.setId(123L);
    LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
    actualCoffeePot.setReleaseDate(ofEpochDayResult);
    actualCoffeePot.setSku("Sku");

    // Assert
    assertEquals("Brand", actualCoffeePot.getBrand());
    assertEquals(123L, actualCoffeePot.getId().longValue());
    assertSame(ofEpochDayResult, actualCoffeePot.getReleaseDate());
    assertEquals("Sku", actualCoffeePot.getSku());
  }

  /** Method under test: {@link CoffeePot#getAge()} */
  @Test
  @Disabled("TODO: Complete this test")
  void testGetAge() {
    // TODO: Complete this test.
    //   java.lang.NullPointerException: Cannot invoke
    // "java.time.LocalDate.until(java.time.chrono.ChronoLocalDate)" because "startDateInclusive" is
    // null
    //       at java.time.Period.between(Period.java:389)
    //       at io.example.democoffeepotservicerest.coffeepot.CoffeePot.getAge(CoffeePot.java:81)
    //   In order to prevent getAge()
    //   from throwing NullPointerException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   getAge().

    // Arrange and Act
    (new CoffeePot()).getAge();
  }

  /** Method under test: {@link CoffeePot#getAge()} */
  @Test
  @Disabled("TODO: Complete this test")
  void testGetAge2() {
    // TODO: Complete this test.
    //   Reason: Method may be time-sensitive.
    //   The assertions no longer passed when run at an alternate date, time and
    //   timezone. Try refactoring the method to take a java.time.Clock instance so
    //   that the time can be parameterized during testing.

    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");

    // Act
    coffeePot.getAge();
  }

  /** Method under test: {@link CoffeePot#equals(Object)} */
  @Test
  @Disabled("TODO: Complete this test")
  void testEquals7() {
    // TODO: Complete this test.
    //   Reason: No inputs found that don't throw a trivial exception.
    //   java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "str" is null
    //       at io.example.democoffeepotservicerest.coffeepot.CoffeePot.equals(CoffeePot.java:117)
    //   In order to prevent equals(Object)
    //   from throwing NullPointerException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   equals(Object).

    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand(null);
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");

    // Act and Assert
    assertThrows(NullPointerException.class, () -> coffeePot.equals(coffeePot1));
  }

  /** Method under test: {@link CoffeePot#equals(Object)} */
  @Test
  @Disabled("TODO: Complete this test")
  void testEquals9() {
    // TODO: Complete this test.
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Method under test threw
    //   java.lang.NullPointerException: Cannot invoke "java.lang.Long.equals(Object)" because
    // "this.id" is null
    //       at io.example.democoffeepotservicerest.coffeepot.CoffeePot.equals(CoffeePot.java:116)
    //   In order to prevent equals(Object)
    //   from throwing NullPointerException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   equals(Object).

    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(null);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");

    // Act and Assert
    assertThrows(NullPointerException.class, () -> coffeePot.equals(coffeePot1));
  }

  /** Method under test: {@link CoffeePot#equals(Object)} */
  @Test
  @Disabled("TODO: Complete this test")
  void testEquals11() {
    // TODO: Complete this test.
    //   Reason: No inputs found that don't throw a trivial exception.
    //   The method under test threw
    //   java.lang.NullPointerException: Cannot invoke "java.time.LocalDate.equals(Object)" because
    // "this.releaseDate" is null
    //       at io.example.democoffeepotservicerest.coffeepot.CoffeePot.equals(CoffeePot.java:119)
    //   In order to prevent equals(Object)
    //   from throwing NullPointerException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   equals(Object).

    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(null);
    coffeePot.setSku("Sku");

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");

    // Act and Assert
    assertThrows(NullPointerException.class, () -> coffeePot.equals(coffeePot1));
  }

  /** Method under test: {@link CoffeePot#equals(Object)} */
  @Test
  @Disabled("TODO: Complete this test")
  void testEquals13() {
    // TODO: Complete this test.
    //   Reason: No inputs found that don't throw a trivial exception.
    //   The method under test threw
    //   java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "str" is null
    //       at io.example.democoffeepotservicerest.coffeepot.CoffeePot.equals(CoffeePot.java:118)
    //   In order to prevent equals(Object)
    //   from throwing NullPointerException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   equals(Object).

    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku(null);

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");

    // Act and Assert
    assertThrows(NullPointerException.class, () -> coffeePot.equals(coffeePot1));
  }

  /** Method under test: {@link CoffeePot#equals(Object)} */
  @Test
  void testEquals() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");

    // Act and Assert
    assertNotEquals(coffeePot, null);
  }

  /** Method under test: {@link CoffeePot#equals(Object)} */
  @Test
  void testEquals2() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");

    // Act and Assert
    assertNotEquals(coffeePot, "Different type to CoffeePot");
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link CoffeePot#equals(Object)}
   *   <li>{@link CoffeePot#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");

    // Act and Assert
    assertEquals(coffeePot, coffeePot);
    int expectedHashCodeResult = coffeePot.hashCode();
    assertEquals(expectedHashCodeResult, coffeePot.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link CoffeePot#equals(Object)}
   *   <li>{@link CoffeePot#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");

    // Act and Assert
    assertEquals(coffeePot, coffeePot1);
    int expectedHashCodeResult = coffeePot.hashCode();
    assertEquals(expectedHashCodeResult, coffeePot1.hashCode());
  }

  /** Method under test: {@link CoffeePot#equals(Object)} */
  @Test
  void testEquals5() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(0);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");

    // Act and Assert
    assertNotEquals(coffeePot, coffeePot1);
  }

  /** Method under test: {@link CoffeePot#equals(Object)} */
  @Test
  void testEquals6() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Demo");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");

    // Act and Assert
    assertNotEquals(coffeePot, coffeePot1);
  }

  /** Method under test: {@link CoffeePot#equals(Object)} */
  @Test
  void testEquals8() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(1L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");

    // Act and Assert
    assertNotEquals(coffeePot, coffeePot1);
  }

  /** Method under test: {@link CoffeePot#equals(Object)} */
  @Test
  void testEquals10() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(0L));
    coffeePot.setSku("Sku");

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");

    // Act and Assert
    assertNotEquals(coffeePot, coffeePot1);
  }

  /** Method under test: {@link CoffeePot#equals(Object)} */
  @Test
  void testEquals12() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("NewSku");

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");

    // Act and Assert
    assertNotEquals(coffeePot, coffeePot1);
  }
}
