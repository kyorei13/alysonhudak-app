package edu.alysonhudak.advancedjava;

import edu.alysonhudak.advancedjava.stockservice.StockService;
import edu.alysonhudak.advancedjava.stockservice.StockServiceFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Alyson Hudak
 */

public class StockServiceFactoryTest {

    /**
     * Positive Test of getStock method, of class edu.alysonhudak.advancedjava.stockservice.StockServiceFactory.
     */
    @Test
    public void testGetStockPositive() {
        StockService stockService = StockServiceFactory.getInstance();
        assertNotNull("Verify StockServiceFactory does not return  null", stockService);

    }

}
