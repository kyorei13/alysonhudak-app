package edu.alysonhudak.advancedjava;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple StockQuoteApp.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test
     */
    public void testApp() {
        assertTrue(true);
    }

    /**
     * Negative Test of main method, of class StockQuoteApplication.

     @Test(expected=NullPointerException.class) public void testMainNegative() throws Exception {
     String[] args = null;
     AppTest.main(args);
     ByteArrayOutputStream outContent = new ByteArrayOutputStream();
     System.setOut(new PrintStream(outContent));
     */
}
