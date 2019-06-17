package edu.alysonhudak.advancedjava;

import edu.alysonhudak.advancedjava.stockservice.StockService;
import edu.alysonhudak.advancedjava.stockservice.StockServiceFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Simple tests as the more developed tests are included in the other test classes.
 *
 * @author Alyson Hudak
 */

public class StockServiceFactoryTest {

    /* Positive test of the Stock Factory*/
    @Test
    public void testGetStockPostive() {
        StockService expResult = null;
        StockService result = StockServiceFactory.getStock();
        assertNotNull("Stock factory works", result);
    }

    /* Negative test of the Stock Factory*/
    @Test
    public void testGetStockNegative() {
        StockService expResult = null;
        StockService result = StockServiceFactory.getStock();
        assertFalse("Stock factory works with null", result == expResult);
    }

}
