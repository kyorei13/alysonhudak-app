package assignment2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alyson Hudak
 */

public class TechTest 
{
    
    /**
     * Positive Test of getQuote method, of class Retail.
     */
    @Test
    public void testGetQuotePositive() 
    {
        String symbol = "MICR";
        Tech instance = new Tech();
        StockQuote result = instance.getQuote(symbol);
        assertTrue("testGetQuotePositive Retail", result.getStockPrice() > 20);
    }
    
     
    /**
     * Negative Test of getQuote method, of class Retail.
     */
    @Test
    public void testGetQuoteNegative() 
    {
        String symbol = "MICR";
        Tech instance = new Tech();
        StockQuote result = instance.getQuote(symbol);
        assertFalse("testGetQuoteNegative Retail", result.getStockPrice() < 20);
    }   
}
