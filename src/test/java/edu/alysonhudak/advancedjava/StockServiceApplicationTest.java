package edu.alysonhudak.advancedjava;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for the simple StockQuoteApp.
 *
 * @author : Alyson Hudak
 */
public class StockServiceApplicationTest {

    /**
     * Negative Test of main method, of class StockQuoteApplication.
     */
    @Test(expected=NullPointerException.class)
    public void testMainNegative() throws Exception {
        String[] args = null;
        StockServiceApplication.main(args);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Tests the method the main method and calls for its functionality of getNumberInList method,
     * of class StockServiceApplication.
     */
    @Test
    public void testGetNumberInList() throws Exception {
        System.out.println("getNumberInList");
        String date1 = "01/01/1999";
        String date2 = "12/31/2001";
        int expResult = 0;
        int result = StockServiceApplication.getNumberInList(date2, date1);
        assertEquals(expResult, result);
    }
}