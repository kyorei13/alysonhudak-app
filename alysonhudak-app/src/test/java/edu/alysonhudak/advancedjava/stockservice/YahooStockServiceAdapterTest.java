package edu.alysonhudak.advancedjava;


import edu.alysonhudak.advancedjava.model.StockQuote;
import edu.alysonhudak.advancedjava.stock.model.database.Quotes;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static edu.alysonhudak.advancedjava.stock.utilities.TestUtility.parseDateString;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import static org.junit.Assert.*;

/**
 * This class is for testing the YahooStockServiceAdapter class.
 *
 * @author Alyson Hudak
 */
public class YahooStockServiceAdapterTest {

    private final BigDecimal stockPriceExpected = BigDecimal.valueOf(227.26);
    private final BigDecimal stockPriceNotExpected = BigDecimal.valueOf(-1.0);

    private StockQuote quoteNow0;
    private StockQuote quoteNow1;

    private StockQuote quoteOnDate;

    private List<StockQuote> dailyStockQuoteList;
    private final List<StockQuote> dailyStockQuoteListExpected = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        LocalDate localDate = LocalDate.of(2019, 06, 01);
        Date stockDate = java.sql.Date.valueOf(localDate);

        YahooStockServiceAdapter stockService = new YahooStockServiceAdapter();

        /*
          prepares to test versions of getStockQuote that return a single quote
         */
        String stockSymbol = "APPL";
        this.quoteNow0 = stockService.getLatestStockQuote(stockSymbol);
        this.quoteNow1 = stockService.getLatestStockQuote(stockSymbol);
        this.quoteOnDate = stockService.getStockQuote(stockSymbol, stockDate);

        /*
          prepares to test the getStockQuoteList on the daily interval
         */
        this.dailyStockQuoteList = stockService.getStockQuoteList(stockSymbol, parseDateString("06/01/2019"), parseDateString("07/04/20189"), StockService.StockQuoteInterval.DAILY);

        this.dailyStockQuoteListExpected.add(
                new StockQuote(
                        stockSymbol,
                        new BigDecimal(227.26).setScale(2, RoundingMode.HALF_UP),
                        java.sql.Date.valueOf(LocalDate.of(2019,06,1 ))));
        this.dailyStockQuoteListExpected.add(
                new StockQuote(
                        stockSymbol,
                        new BigDecimal(229.28).setScale(2, RoundingMode.HALF_UP),
                        java.sql.Date.valueOf(LocalDate.of(2019,06,2 ))));
        this.dailyStockQuoteListExpected.add(
                new StockQuote(
                        stockSymbol,
                        new BigDecimal(232.07).setScale(2, RoundingMode.HALF_UP),
                        java.sql.Date.valueOf(LocalDate.of(2019,06,3 ))));
    }

    @Test
    public void testGetStockQuotePositive() {
        assertEquals("Prices returned by two sequential calls match.", this.quoteNow0.getStockPrice(), this.quoteNow1.getStockPrice());
    }

    @Test
    public void testGetStockQuoteNegative() {
        assertNotSame("price is not 100.00", this.stockPriceNotExpected, this.quoteNow0.getStockPrice());
    }

    @Test
    public void testGetStockQuoteWithDatePositive() {
        assertEquals("price is 100.00", this.stockPriceExpected, this.quoteOnDate.getStockPrice());
    }

    @Test
    public void testGetStockQuoteWithDateNegative() {
        assertNotSame("price is not 100.00", this.stockPriceNotExpected, this.quoteOnDate.getStockPrice());
    }

    @Test
    public void testGetDailyStockQuotePositive() {
        assertThat("stock quote list obtained equals stock quote list expected", this.dailyStockQuoteList, is(this.dailyStockQuoteListExpected));
    }

    @Test
    public void testGetDailyStockQuotesNegative() {
        assertThat("stock quote list obtained does not equal empty stock quote list ", this.dailyStockQuoteList, is(not(new ArrayList<DAOStockQuote>())));
    }
}