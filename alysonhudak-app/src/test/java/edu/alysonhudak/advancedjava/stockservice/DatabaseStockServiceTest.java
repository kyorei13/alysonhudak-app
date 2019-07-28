package edu.alysonhudak.advancedjava;

import edu.alysonhudak.advancedjava.model.StockData;
import edu.alysonhudak.advancedjava.model.StockQuote;
import edu.alysonhudak.advancedjava.stockservice.DatabaseStockService;
import edu.alysonhudak.advancedjava.stockservice.StockServiceException;
import edu.alysonhudak.advancedjava.util.DatabaseInitializationException;
import edu.alysonhudak.advancedjava.util.DatabaseUtils;
import edu.alysonhudak.advancedjava.util.Interval;

import org.junit.After;
import org.junit.Before;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * The unit tests for the DatabaseStockService
 *
 * @author Alyson Hudak
 */
public class DatabaseStockServiceTest {

    /**
     * Declare an instance of DatabaseStockService
     * that can be used throughout this test class
     */
    private DatabaseStockService databaseStockService;

    /**
     * Initialize the database through the DatabaseUtils class and then
     * initialize databaseStockService variable to a new instance of DatabaseStockService class
     * @throws DatabaseInitializationException
     */
    @Before
    public void setUp() throws DatabaseInitializationException{
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
        databaseStockService = new DatabaseStockService();
    }

    /**
     * A test to check that a single quote can be retrieved from the database using the
     * getQuote method
     * @throws StockServiceException
     */
    @Test
    public void testGetQuote() throws StockServiceException {
        String symbol = "APPL";
        StockQuote stockQuote = databaseStockService.getQuote(symbol);
        assertNotNull("Verify a stock quote can be retrieved from the database.", stockQuote);
        assertEquals("Make sure the symbols match.", symbol, stockQuote.getSymbol());
    }

    /**
     * A test to check that there are no records retrieved from the database with a symbol
     * that is known to not be present
     * @throws StockServiceException
     */
    @Test (expected = StockServiceException.class)
    public void testGetQuoteNegative() throws StockServiceException{
        String symbol = "JKLD";
        StockQuote stockQuote = databaseStockService.getQuote(symbol);
        assertNotNull("Verify a stock quote can be retrieved from the database.", stockQuote);
        assertTrue("Ensure there are no records for the given symbol.", stockQuote.getSymbol().isEmpty());
    }

    /**
     * Tests that a list of stock quotes are able to be retrieved from the database
     * with the getQuote method when passing in a symbol and from/until dates.
     * @throws ParseException
     * @throws StockServiceException
     */
    @Test
    public void testGetQuoteList() throws ParseException, StockServiceException{
        String symbol = "APPL";
        String fromDate = "2012-008-04 00:00:00";
        String untilDate = "2012-09-06 23:59:59";

        Calendar fromCalendar = convertStringToDate(fromDate);
        Calendar untilCalendar = convertStringToDate(untilDate);

        List<StockQuote> stockQuotes = databaseStockService.getQuote(symbol, fromCalendar, untilCalendar);
        assertNotNull("Verify a stock quote can be retrieved from the database.", stockQuotes);
        assertFalse("Ensure the list of stockQuotes is not empty.", stockQuotes.isEmpty());
    }

    /**
     * A test that checks that the list of stock quotes retrieved from the database is empty when
     * give symbol/dates that are known to not be present in the database
     * with the getQuote method when passing in a symbol, and from and until dates.
     * @throws ParseException
     * @throws StockServiceException
     */
    @Test (expected = StockServiceException.class)
    public void testGetQuoteListNegative() throws ParseException, StockServiceException{
        String symbol = "APPL";
        String fromDate = "2017-01-18 00:00:00";
        String untilDate = "2017-04-17 23:59:59";

        Calendar fromCalendar = convertStringToDate(fromDate);
        Calendar untilCalendar = convertStringToDate(untilDate);

        List<StockQuote> stockQuotes = databaseStockService.getQuote(symbol, fromCalendar, untilCalendar);
        assertTrue("Ensure the list of stockQuotes is empty.", stockQuotes.isEmpty());
    }

    /**
     * A test that checks a list of stock quotes are able to be retrieved from the database
     * with the getQuote method  when passing in a symbol, from and until dates, and interval.
     * @throws ParseException
     * @throws StockServiceException
     */
    @Test
    public void testGetQuoteListWithInterval() throws ParseException, StockServiceException{
        String symbol = "AMZN";
        String fromDate = "2006-07-04 00:00:01";
        String untilDate = "2012-02-13 23:59:59";

        Calendar fromCalendar = convertStringToDate(fromDate);
        Calendar untilCalendar = convertStringToDate(untilDate);

        List<StockQuote> stockQuotes = databaseStockService.getQuote(symbol, fromCalendar, untilCalendar, IntervalEnum.HOUR);
        assertNotNull("Verify a stock quote can be retrieved from the database.", stockQuotes);
        assertFalse("Ensure the list of stockQuotes is not empty.", stockQuotes.isEmpty());
    }

    /**
     * A tests that checks the list of stock quotes retrieved from the database is empty when
     * given symbol/dates that are known to not be present in the database
     * with the getQuote method  when passing in a symbol, from/until dates, and interval.
     * @throws ParseException
     * @throws StockServiceException
     */
    @Test (expected = StockServiceException.class)
    public void testGetQuoteListWithIntervalNegative() throws ParseException, StockServiceException{
        String symbol = "GOOG";
        String fromDate = "2017-03-27 00:00:01";
        String untilDate = "2018-07-10 23:59:59";

        Calendar fromCalendar = convertStringToDate(fromDate);
        Calendar untilCalendar = convertStringToDate(untilDate);

        List<StockQuote> stockQuotes = databaseStockService.getQuote(symbol, fromCalendar, untilCalendar, IntervalEnum.HOUR);
        assertNotNull("Verify a stock quote can be retrieved from the database.", stockQuotes);
        assertTrue("Ensure list of stockQuotes is empty.", stockQuotes.isEmpty());
    }

    /**
     * This method converts a date of type String to a date of type Calendar
     * @param dateEntered the date needed to convert
     * @return converted date of type Calendar
     * @throws ParseException
     */
    public static Calendar convertStringToDate(String dateEntered)throws ParseException{
        /**
         * Create a new instance of SimpleDateFormat that will be used to
         * parse the string arguments to obtain desired start and end dates
         */
        DateFormat dateFormatter = new SimpleDateFormat(StockData.dateFormat);
        Date date = dateFormatter.parse(dateEntered);
        Calendar convertedDate = Calendar.getInstance();
        convertedDate.setTime(date);

        return convertedDate;
    }
}