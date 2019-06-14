package edu.alysonhudak.advancedjava.stockservice;

import edu.alysonhudak.advancedjava.model.StockQuote;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Alyson Hudak
 */

public class BasicStockServiceTest {

    /**
     * Test of the getStockQuote method, of class edu.alysonhudak.advancedjava.stockservice.BasicStockService.
     */
    @Test
    public void testGetStockQuote() {
        BasicStockService basicStockService = new BasicStockService();
        StockQuote stockQuote = basicStockService.getQuote("APPL");
        assertNotNull("Verify basic service returns a stock quote", stockQuote);
        assertNotNull("Verify basic service returns a stock price", stockQuote.getStockPrice());
        assertNotNull("Verify basic service returns a stock stock symbol", stockQuote.getStockSymbol());
        assertNotNull("Verify basic service returns a stock date", stockQuote.getTransactionDate());

    }
}
