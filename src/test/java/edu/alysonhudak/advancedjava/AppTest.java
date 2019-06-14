package edu.alysonhudak.advancedjava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit test for simple StockQuoteApp.
 */
public class AppTest {


    /**
     * Rigourous Test
     */
    public void testApp() {
        assertTrue(true);
    }

    /**
     * Negative Test of main method, of class StockQuoteApplication.
     */
    @Test //(expected = NullPointerException.class)
    public void testMainNegative() throws Exception {
        String[] args = null;
        App.main(args);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }
}
