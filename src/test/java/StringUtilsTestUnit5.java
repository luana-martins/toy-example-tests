import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTestUnit5 {

  @Test
  public void testConvertToDoubleOK() {
    // Test case with the age is a numeric string
    String age = "1990";
    Double expAge = Double.valueOf(age);
    Double actual = StringUtils.convertToDouble(age);

    assertNotNull(actual);
    assertEquals(expAge, actual, "Conversão de idade");
  }

  @Test
  public void testConvertToDoubleWithNullArgument() {
    // Test case with the age is null
    String age = null;
    Double actual = StringUtils.convertToDouble(age);

    assertNull(actual, "The actual is not null");
  }

  @Test
  public void testConvertToDoubleThrowException() {
    // Test with the age is a non numeric string
    String age = "N/A";

    assertThrows(NumberFormatException.class, () -> {
      StringUtils.convertToDouble(age);
    });

    assertThrows(NumberFormatException.class, () -> {
      StringUtils.convertToDouble(age);
    });
  }

  @Test
  public void testIsNullOrBlankOK() {
    // Test the case that the input is NULL
    String input = null;

    assertTrue(StringUtils.isNullOrBlank(input));

    // Test case with the input is empty
    input = " ";
    assertFalse(!StringUtils.isNullOrBlank(input));

    // Test case with the input is not empty
    input = "abc";

    assertTrue(!StringUtils.isNullOrBlank(input));

  }

  @Test
  public void testGetDefaultIfNull() {
    // Test case with input string is null
    String st = null;
    String defaultSt = "abc";

    String actual = StringUtils.getDefaultIfNull(st, defaultSt);
    assertSame(defaultSt, actual);

    // Test case with input string is not null
    st = "def";

    actual = StringUtils.getDefaultIfNull(st, defaultSt);
    assertNotSame(defaultSt, actual);

    // Test case with input string is empty
    st = "";
    actual = StringUtils.getDefaultIfNull(st, defaultSt);
    if (actual.equals(defaultSt)) {
      fail();
    }

  }

  @Test
  public void testConcatWithRegularInput() {
    String st1 = "Hello";
    String st2 = "World";
    String st3 = "!";
    String expect = st1 + st2 + st3;
    String actual = StringUtils.concat(st1, st2, st3);
    assertEquals(expect, actual);
  }

  @Test
  public void testConcatWithNullInput() {
    String st1 = "Hello";
    String st2 = "World";
    String st3 = null;
    String expect = st1 + st2;
    String actual = StringUtils.concat(st1, st2, st3);
    assertEquals(expect, actual);
  }

  @Test
  public void testConcatWithAllNullInput() {
    String actual = StringUtils.concat();
    assertTrue(actual == null);
  }
}
