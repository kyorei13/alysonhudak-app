package edu.alysonhudak.advancedjava.model;

import edu.alysonhudak.advancedjava.model.StockQuote;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Alyson Hudak
 */
public class StockQuoteTest {

    /**
     * Positive Test of Constructor method, of class edu.alysonhudak.advancedjava.model.StockQuote.
     */
    @Test
    public void testConstructorPostive() {
        BigDecimal stockPrice = new BigDecimal(100);
        Date time = Calendar.getInstance().getTime();
        String appl = "APPL";
        StockQuote stockQuote = new StockQuote(appl, stockPrice, time);

        assertEquals("stockQuote price is correct", stockPrice, stockQuote.getStockPrice());
        assertEquals("stockQuote date is correct", time, stockQuote.getTransactionDate());
        assertEquals("stockQuote symbol is correct", appl, stockQuote.getStockSymbol());
        assertTrue("stockQuote toString contains symbol", stockQuote.toString().contains(appl));

    }

}
