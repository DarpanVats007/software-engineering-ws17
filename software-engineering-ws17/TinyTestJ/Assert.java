// minimal Assertion handler example, based on https://github.com/junit-team/junit4/blob/master/src/main/java/org/junit/Assert.java

package TinyTestJ;

public class Assert {

  protected Assert() {} // protect constructor since it is a static only class

  // assertXYZ methods

  public static void assertEquals(String message, double expected, double actual, double delta) {
    if (doubleIsDifferent(expected, actual, delta)) {
      failNotEquals(message, Double.valueOf(expected), Double.valueOf(actual));
    }
  }

  public static void assertEquals(double expected, double actual, double delta) {
     assertEquals(null, expected, actual, delta);
  }

  // helper methods to format strings etc.

  public static void fail(String message) {
    if (message == null) {
      throw new AssertionError();
    }
    throw new AssertionError(message);
  }

  public static void fail() {
    fail(null);
  }

  static String format(String message, Object expected, Object actual) {
    String formatted = "";
    if (message != null && !"".equals(message)) {
      formatted = message + " ";
    }
    String expectedString = String.valueOf(expected);
    String actualString = String.valueOf(actual);
    if (equalsRegardingNull(expectedString, actualString)) {
      return formatted + "expected: "
             + formatClassAndValue(expected, expectedString)
             + " but was: " + formatClassAndValue(actual, actualString);
    } else {
      return formatted + "expected: <" + expectedString + "> but was: <"
             + actualString + ">";
    }
  }

  private static String formatClass(Class<?> value) {
    String className = value.getCanonicalName();
    return className == null ? value.getName() : className;
  }

  private static String formatClassAndValue(Object value, String valueString) {
    String className = value == null ? "null" : value.getClass().getName();
    return className + "<" + valueString + ">";
  }

  private static boolean equalsRegardingNull(Object expected, Object actual) {
    if (expected == null) {
      return actual == null;
    }
    return isEquals(expected, actual);
  }

  private static boolean isEquals(Object expected, Object actual) {
    return expected.equals(actual);
  }

  private static void failEquals(String message, Object actual) {
    String formatted = "Values should be different. ";
    if (message != null) {
      formatted = message + ". ";
    }
    formatted += "Actual: " + actual;
    fail(formatted);
  }

  private static void failNotEquals(String message, Object expected, Object actual) {
    fail(format(message, expected, actual));
  }
  
  private static boolean doubleIsDifferent(double d1, double d2, double delta) {
    if (Double.compare(d1, d2) == 0) {
      return false;
    }
    if ((Math.abs(d1 - d2) <= delta)) {
      return false;
    }
    return true;
  }


  /**
   * Asserts that an object isn't null. If it is an {@link AssertionError} is
   * thrown with the given message.
   *
   * @param message the identifying message for the {@link AssertionError} (<code>null</code>
   * okay)
   * @param object Object to check or <code>null</code>
   */
  public static void assertNotNull(String message, Object object) {
      assertTrue(message, object != null);
  }

  /**
   * Asserts that an object isn't null. If it is an {@link AssertionError} is
   * thrown.
   *
   * @param object Object to check or <code>null</code>
   */
  public static void assertNotNull(Object object) {
      assertNotNull(null, object);
  }
  
  /**
   * Asserts that an object is null. If it is not, an {@link AssertionError}
   * is thrown with the given message.
   *
   * @param message the identifying message for the {@link AssertionError} (<code>null</code>
   * okay)
   * @param object Object to check or <code>null</code>
   */
  public static void assertNull(String message, Object object) {
      if (object == null) {
          return;
      }
      failNotNull(message, object);
  }

  /**
   * Asserts that an object is null. If it isn't an {@link AssertionError} is
   * thrown.
   *
   * @param object Object to check or <code>null</code>
   */
  public static void assertNull(Object object) {
      assertNull(null, object);
  }

  private static void failNotNull(String message, Object actual) {
      String formatted = "";
      if (message != null) {
          formatted = message + " ";
      }
      fail(formatted + "expected null, but was:<" + actual + ">");
  }
  /**
   * Asserts that two objects refer to the same object. If they are not, an
   * {@link AssertionError} is thrown with the given message.
   *
   * @param message the identifying message for the {@link AssertionError} (<code>null</code>
   * okay)
   * @param expected the expected object
   * @param actual the object to compare to <code>expected</code>
   */
  public static void assertSame(String message, Object expected, Object actual) {
      if (expected == actual) {
          return;
      }
      failNotSame(message, expected, actual);
  }

  /**
   * Asserts that two objects refer to the same object. If they are not the
   * same, an {@link AssertionError} without a message is thrown.
   *
   * @param expected the expected object
   * @param actual the object to compare to <code>expected</code>
   */
  public static void assertSame(Object expected, Object actual) {
      assertSame(null, expected, actual);
  }
  


  private static void failSame(String message) {
      String formatted = "";
      if (message != null) {
          formatted = message + " ";
      }
      fail(formatted + "expected not same");
  }

  private static void failNotSame(String message, Object expected,
          Object actual) {
      String formatted = "";
      if (message != null) {
          formatted = message + " ";
      }
      fail(formatted + "expected same:<" + expected + "> was not:<" + actual
              + ">");
  }

  /**
   * Asserts that a condition is true. If it isn't it throws an
   * {@link AssertionError} with the given message.
   *
   * @param message the identifying message for the {@link AssertionError} (<code>null</code>
   * okay)
   * @param condition condition to be checked
   */
  public static void assertTrue(String message, boolean condition) {
      if (!condition) {
          fail(message);
      }
  }

  /**
   * Asserts that a condition is true. If it isn't it throws an
   * {@link AssertionError} without a message.
   *
   * @param condition condition to be checked
   */
  public static void assertTrue(boolean condition) {
      assertTrue(null, condition);
  }

  /**
   * Asserts that a condition is false. If it isn't it throws an
   * {@link AssertionError} with the given message.
   *
   * @param message the identifying message for the {@link AssertionError} (<code>null</code>
   * okay)
   * @param condition condition to be checked
   */
  public static void assertFalse(String message, boolean condition) {
      assertTrue(message, !condition);
  }

}
