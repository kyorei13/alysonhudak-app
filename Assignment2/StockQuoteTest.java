package assignment2;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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
        sampleStock = new StockQuote("Netflix");
    }
    
    /**
     * Positive Test of Constructor method, of class StockQuote.
     */
    @Test
    public void testConstructorPricePostive() 
    {
        StockQuote instance = sampleStock; 
        assertNotNull("testConstructorPricePostive", instance);
    }

    /**
     * Positive Test of setStockPrice method, of class StockQuote.
     */
    @Test
    public void testSetStockPricePostive() 
    {
        Double price = 700.0;
        StockQuote instance = sampleStock;
        instance.setStockPrice(price);
        assertEquals("setStockPrice Positive", price, instance.getStockPrice());
    }
    
      /**
     * Negative Test of setStockPrice method, of class StockQuote.
     */
    @Test
    public void testSetStockPriceNegative() 
    {
        Double price = 700.0;
        StockQuote instance = sampleStock;
        instance.setStockPrice(price);
        assertFalse("setStockPrice Negative", price + 1 == instance.getStockPrice());
    }  
}
