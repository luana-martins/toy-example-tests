import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTestUnit5 {

  @Test
  public void testConvertToDoubleOK() {
    // Test case with the age is a numeric string
    String age = "1990";
    Double expAge = Double.valueOf(age);
    Double actual = MinhaStringUtils.convertToDouble(age);

    assertNotNull(actual);
    assertEquals(expAge, actual, "Conversão de idade");
    testConvertToDoubleWithNullArgument("luana");
    assertNotNull(actual, "not null");
  }

  @Test
  public void testConvertToDoubleWithNullArgument(String texto) {
    // Test case with the age is null
    String age = null;
    Double actual = MinhaStringUtils.convertToDouble(age);

    assertNull(actual, "The actual is not null");
  }


  @Test
  public void testConvertToDoubleWithNullArgument(String texto) {
    // Test case with the age is null
    assertThrows(expected, actual);
  }

  @Test
  public void testConvertToDoubleThrowException() {
    // Test with the age is a non numeric string
    String age = "N/A";

    assertThrows(NumberFormatException.class, () -> {
      MinhaStringUtils.convertToDouble(age);
    });

    assertThrows(NumberFormatException.class, () -> {
      MinhaStringUtils.convertToDouble(age);
    });
  }

  @Test
  public void testIsNullOrBlankOK() {
    // Test the case that the input is NULL
    String input = null;

    assertTrue(MinhaStringUtils.isNullOrBlank(input), "xx");

    // Test case with the input is empty
    input = " ";
    assertFalse(!MinhaStringUtils.isNullOrBlank(input), "yy");

    // Test case with the input is not empty
    input = "abc";

    assertTrue(!MinhaStringUtils.isNullOrBlank(input), "zz");

  }

  @Test
  public void testGetDefaultIfNull() {
    // Test case with input string is null
    String st = null;
    String defaultSt = "abc";

    String actual = MinhaStringUtils.getDefaultIfNull(st, defaultSt);
    assertSame(defaultSt, actual);

    // Test case with input string is not null
    st = "def";

    actual = MinhaStringUtils.getDefaultIfNull(st, defaultSt);
    assertNotSame(defaultSt, actual);

    // Test case with input string is empty
    st = "";
    actual = MinhaStringUtils.getDefaultIfNull(st, defaultSt);
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
    String actual = MinhaStringUtils.concat(st1, st2, st3);
    assertEquals(expect, actual);
  }

  @Test
  public void testConcatWithNullInput() {
    String st1 = "Hello";
    String st2 = "World";
    String st3 = null;
    String expect = st1 + st2;
    String actual = MinhaStringUtils.concat(st1, st2, st3);
    assertNotEquals(expect, !actual);
  }

  @Test
  public void testConcatWithAllNullInput() {
    String actual = MinhaStringUtils.concat();
    assertEquals(actual, null, "test");
    assertEquals(actual, null, "test");
    assertEquals("test", actual, null);
  }

  @Test
  public void testBadConfiguration() throws Exception {
    assertThrows(ResolveEndpointFailedException.class, () -> template.sendBody(format, "Hello World"),
           "Should have thrown a ResolveEndpointFailedException");
  }
}
