package edu.alysonhudak.advancedjava;

import edu.alysonhudak.advancedjava.model.StockQuote;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Alyson Hudak
 */

public class StockQuoteTest {
    private StockQuote sampleStock;
    private Date date = new Date();
    private BigDecimal stockPrice;

    @Before
    public void setup() {
        Date date = new Date();
        stockPrice = new BigDecimal(5.7);
        sampleStock = new StockQuote("MICR", stockPrice, date);
    }

    /**
     * Positive Test of the Constructor method, of class StockQuote.
     */
    @Test
    public void testConstructorPricePostive() {
        StockQuote instance = sampleStock;
        assertNotNull("stockQuote instance is not null", instance);
    }

    /**
     * Positive Test of the getDate method, of class StockQuote.
     */
    @Test
    public void getDateRecordedPostive() {
        StockQuote instance = sampleStock;
        //assertEquals("get date runs properly", date, instance.getDateRecorded());
    }

    /**
     * Negative Test of the Constructor method, of class StockQuote.
     */
    @Test
    public void testConstructorPriceNegative() {
        StockQuote instance = new StockQuote("MICR", stockPrice, null);
        assertNull("stockQuote instance is null", instance.getTransactionDate());
    }

    /**
     * Negative Test of the setStockPrice method, of class StockQuote.
     */
    @Test
    public void getDateRecordedNegative() throws ParseException {
        String sDate1 = "31/12/1999";
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

        StockQuote instance = sampleStock;
        assertFalse("get date invlaid", instance.getTransactionDate() == date1);
    }
}