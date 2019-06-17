package edu.alysonhudak.advancedjava;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import edu.alysonhudak.advancedjava.model.StockQuote;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Alyson Hudak
 */

public class StockQuoteTest{
    private StockQuote sampleStock;
    private Date date = new Date();


    @Before
    public void setup() {
        Date date = new Date();
        sampleStock = new StockQuote("MICR", 8.7, date);
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
        StockQuote instance = new StockQuote("MICR", 8.7, null);
        assertNull("stockQuote instance is null", instance.getDateRecorded());
    }

    /**
     * Negative Test of the setStockPrice method, of class StockQuote.
     */
    @Test
    public void getDateRecordedNegative() throws ParseException {
        String sDate1="31/12/1999";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

        StockQuote instance = sampleStock;
        assertFalse("get date invlaid", instance.getDateRecorded() == date1);
    }
}