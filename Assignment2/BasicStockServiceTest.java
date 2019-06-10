package assignment2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alyson Hudak
 */

public class BasicStockServiceTest 
{
 
    /**
     * Test of the getStockQuote method, of class BasicStockService.
     */
    @Test
    public void testGetStockQuote() 
    {
        String industry = "Tech";
        String name = "MICR";
        StockQuote expResult = null;
        StockQuote result = BasicStockService.getStockQuote(industry, name);
        assertTrue("testGetStockQuote",result != expResult);
    }   
}
