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
        assertThrows(NumberFormatException.class, () -> App.PrintResultsAndStatistics(args));
    }

    @Test
    void TestOutputAndStatisticsForFizz() throws Exception {
        String[] args = {"6"};
        App.PrintResultsAndStatistics(args);
        assertEquals(App.FIZZ + " " + "\r"+ "\n" + App.FIZZ + ": " + args.length, outputStreamCaptor.toString().trim());
    }

    @Test
    void TestOutputAndStatisticsForBuzz() throws Exception {
        String[] args = {"5"};
        App.PrintResultsAndStatistics(args);
        assertEquals(App.BUZZ + " " + "\r"+ "\n" + App.BUZZ + ": " + args.length, outputStreamCaptor.toString().trim());
    }

    @Test
    void TestOutputAndStatisticsForFizzbuzz() throws Exception {
        String[] args = {"15"};
        App.PrintResultsAndStatistics(args);
        assertEquals(App.FIZZBUZZ + " " + "\r"+ "\n" + App.FIZZBUZZ + ": " + args.length, outputStreamCaptor.toString().trim());
    }

    @Test
    void TestOutputAndStatisticsForLucky() throws Exception {
        String[] args = {"3"};
        App.PrintResultsAndStatistics(args);
        assertEquals(App.LUCKY + " " + "\r"+ "\n" + App.LUCKY + ": " + args.length, outputStreamCaptor.toString().trim());
    }

    @Test
    void TestOutputAndStatisticsForInteger() throws Exception {
        String[] args = {"1"};
        App.PrintResultsAndStatistics(args);
        assertEquals("1" + " " + "\r"+ "\n" + App.INTEGER + ": " + args.length, outputStreamCaptor.toString().trim());
    }

    @Test
    void TestOutputAndStatisticsForIntegers() throws Exception {
        String[] args = {"1", "2"};
        App.PrintResultsAndStatistics(args);
        assertEquals("1 " + "2" + " " + "\r"+ "\n" + App.INTEGER + ": " + args.length, outputStreamCaptor.toString().trim());
    }

    @AfterEach
	public void tearDown() {
	    System.setOut(standardOut);
	}

}
