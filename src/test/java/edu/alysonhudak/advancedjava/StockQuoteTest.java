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
    public void testConstructorPricePostive() 
    {
        StockQuote instance = sampleStock; 
        //assertNotNull("testConstructorPricePostive", instance);
    }

    /**
     * Positive Test of setStockPrice method, of class edu.alysonhudak.advancedjava.model.StockQuote.
     */
    @Test
    public void testSetStockPricePostive() 
    {
        Double price = 700.0;
        StockQuote instance = sampleStock;
        // assertEquals("setStockPrice Positive", price, instance.getStockPrice());
    }
    
      /**
     * Negative Test of setStockPrice method, of class edu.alysonhudak.advancedjava.model.StockQuote.
     */
    @Test
    public void testSetStockPriceNegative() 
    {
        Double price = 700.0;
        StockQuote instance = sampleStock;
     }
}
