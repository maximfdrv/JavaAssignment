package gr1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


/**
 * Unit test for simple App.
 */
class AppTest {
    private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void TestExceptionIfArgsIsNull() throws Exception {
        String[] args = null;
        assertThrows(Exception.class, () -> App.IsArgsNullOrEmpty(args));
    }

    @Test
    void TestExceptionIfArgsIsEmpty() throws Exception {
        String[] args = new String[0];
        assertThrows(Exception.class, () -> App.IsArgsNullOrEmpty(args));
    }

    @Test
    void TestNoExceptionIfArgsIsNotEmpty() throws Exception {
        String[] args = new String[1];
        assertDoesNotThrow(() -> App.IsArgsNullOrEmpty(args));
    }

    @Test
    void TestExceptionIfArgsNotInts() throws Exception {
        String[] args = {"a"};
        assertThrows(NumberFormatException.class, () -> App.PrintResults(args));
    }

    @Test
    void TestOutputIfNumsMultiplyOfFifteen() throws Exception {
        String[] args = {"15"};
        App.PrintResults(args);
        assertEquals("fizzbuzz", outputStreamCaptor.toString().trim());
    }

    @Test
    void TestOutputIfNumsMultiplyOfFive() throws Exception {
        String[] args = {"5"};
        App.PrintResults(args);
        assertEquals("buzz", outputStreamCaptor.toString().trim());
    }

    @Test
    void TestOutputIfNumsMultiplyOfThree() throws Exception {
        String[] args = {"3"};
        App.PrintResults(args);
        assertEquals("fizz", outputStreamCaptor.toString().trim());
    }

    @Test
    void TestOutputIfOutputIsDigit() throws Exception {
        String[] args = {"2"};
        App.PrintResults(args);
        assertEquals("2", outputStreamCaptor.toString().trim());
    }

    @AfterEach
	public void tearDown() {
	    System.setOut(standardOut);
	}

}
