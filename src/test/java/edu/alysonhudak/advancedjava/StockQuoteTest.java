package edu.alysonhudak.advancedjava;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import edu.alysonhudak.advancedjava.model.StockQuote;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Alyson Hudak
 */
public class StockQuoteTest
{
    private StockQuote sampleStock;
    
    
    @Before
    public void setup() 
    {
     }
    
    /**
     * Positive Test of Constructor method, of class edu.alysonhudak.advancedjava.model.StockQuote.
     */
    @Test
    public void testConstructorPricePostive() {
        StockQuote instance = sampleStock;
        assertNotNull("stockQuote instance is not null", instance);
    }

    /**
     * Positive Test of setStockPrice method, of class edu.alysonhudak.advancedjava.model.StockQuote.
     */
    @Test
    public void testSetStockPricePostive() {
        Double price = 700.0;
        StockQuote instance = sampleStock;
        instance.setStockPrice(price);
        assertEquals("set stock price works", price, instance.getStockPrice());
    }

    /**
     * Positive Test of getDate method, of class edu.alysonhudak.advancedjava.model.StockQuote.
     */
    @Test
    public void getDateRecordedPostive() {
        StockQuote instance = sampleStock;
        assertEquals("get date runs properly", date, instance.getDateRecorded());
    }

    /**
     * Negative Test of Constructor method, of class edu.alysonhudak.advancedjava.model.StockQuote.
     */
    @Test
    public void testConstructorPriceNegative() {
        StockQuote instance = new StockQuote("AMZN", 9.9, null);
        assertNull("stockQuote instance is null", instance.getDateRecorded());
    }

      /**
     * Negative Test of setStockPrice method, of class edu.alysonhudak.advancedjava.model.StockQuote.
     */
      @Test
      public void testSetStockPriceNegative() {
          Double price = 700.0;
          StockQuote instance = sampleStock;
          instance.setStockPrice(price);
          assertFalse("set stock price with invalid data", price + 1 == instance.getStockPrice());
      }

    /**
     * Negative Test of setStockPrice method, of class edu.alysonhudak.advancedjava.model.StockQuote.
     */
    @Test
    public void getDateRecordedNegative() throws ParseException {
        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

        StockQuote instance = sampleStock;
        assertFalse("get date invlaid", instance.getDateRecorded() == date1);
    }

}
