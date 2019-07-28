package edu.alysonhudak.advancedjava;

import edu.alysonhudak.advancedjava.model.StockQuery;
import edu.alysonhudak.advancedjava.model.StockQuote;
import edu.alysonhudak.advancedjava.stockservice.StockService;
import edu.alysonhudak.advancedjava.stockservice.StockServiceException;
import edu.alyosnhudak.advancedjava.util.Interval;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.text.ParseException;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests for the BasicStockQuoteApplication
 *
 * @author Alyson Hudak
 */
public class BasicStockQuoteApplicationTest {

    private BasicStockQuoteApplication basicStockQuoteApplication;
    private StockService stockServiceMock;

    /**
     * Set up mocking for StockService class before each test by initializing
     * stockServiceMock instance to a mock object
     */
    @Before
    public void setUp() {
        stockServiceMock = mock(StockService.class);
    }

    /**
     * Tests that the basicStockQuoteApplication instance can be initialized correctly
     * and is not null.
     */
    @Test
    public void testValidConstruction() {
        basicStockQuoteApplication = new BasicStockQuoteApplication(stockServiceMock);
        assertNotNull("Basic construction works", basicStockQuoteApplication);
    }

    /**
     * Tests that the basicStockQuoteApplication instance can be initialized correctly,
     * stockQuote successfully retrieved from the database through the StockQuote class.
     * @throws ParseException
     * @throws StockServiceException
     */
    @Test
    public void testDisplayResults() throws ParseException, StockServiceException {
        basicStockQuoteApplication = new BasicStockQuoteApplication(stockServiceMock);
        String symbol = "APPL";
        String from = "2011-10-29 12:12:12";
        String until = "2014-11-29 12:12:12";
        StockQuery stockQuery = new StockQuery(symbol, from, until, Interval.HOUR);

        List<StockQuote> stockQuotes = new ArrayList<>();
        StockQuote stockQuoteFromDate = new StockQuote(new BigDecimal(100), stockQuery.getFrom().getTime(), stockQuery.getSymbol());
        stockQuotes.add(stockQuoteFromDate);
        StockQuote stockQuoteUntilDate = new StockQuote(new BigDecimal(100), stockQuery.getUntil().getTime(), stockQuery.getSymbol());
        stockQuotes.add(stockQuoteUntilDate);

        when(stockServiceMock.getQuote(any(String.class),
                any(Calendar.class),
                any(Calendar.class),
                any(Interval.class))).thenReturn(stockQuotes);

        String output = basicStockQuoteApplication.displayStockQuotes(stockQuery);
        assertTrue("Make sure that the symbol appears in output", output.contains(symbol));
        assertTrue("Make sure the from date appears in output", output.contains(from));
        assertTrue("Make sure the until date appears in output", output.contains(until));

    }
    /**
     * Test that a null pointer exception is thrown when a null value is passed into the
     * main method of the application.
     */
    @Test(expected = NullPointerException.class)
    public void testMainNegative() {
        BasicStockQuoteApplication.main(null);
    }
}