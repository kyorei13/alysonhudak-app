package edu.alysonhudak.advancedjava;

import edu.alysonhudak.advancedjava.model.StockQuote;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;
import static java.util.EnumSet.of;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import junit.framework.TestCase;
import static junit.framework.Assert.assertNull;


/**
 * @author Alyson Hudak
 */

public class BasicStockServiceTest extends TestCase {
    private Date startDate = new Date();

    /**
     * Positive Test of the first getQuote method, of class BasicStockService.
     */
    public void testGetQuoteFirstMethodPositive() {
        String symbol = "Name";
        BasicStockService instance = new BasicStockService();
        StockQuote result = instance.getQuote(symbol, startDate);
        assertNotNull("getQuote is not null", result);
    }

    /**
     * Positive Test of the second getQuote method, of class BasicStockService.
     */
    public void testGetQuotesSecondMethodPositive() {

        Calendar from = Calendar.getInstance(); //get instance of calender
        from.setTime(startDate); //set calender time to start date from params

        Calendar until = Calendar.getInstance(); //get instance of calender
        until.setTime(startDate);
        until.add(Calendar.DAY_OF_YEAR, 3); //add days to 'until'

        String symbol = "Test";

        BasicStockService instance = new BasicStockService();
        List<StockQuote> result = instance.getQuote(symbol, from, until);
        assertNotNull("second getQuote is not null", result);
        assertEquals("second getQuote returns correct list", result.size(), 3);
    }

    /**
     * Positive Test of the third getQuote method, of class BasicStockService.
     */
    public void testGetQuotesThirdMethodPositive() {
        IntervalEnum intveralTime = IntervalEnum.Years;

        Calendar from = Calendar.getInstance(); //get instance of calender
        from.setTime(startDate); //set calender time to start date from params

        Calendar until = Calendar.getInstance(); //get instance of calender
        until.setTime(startDate);
        until.add(Calendar.DAY_OF_YEAR, 365); //add days to 'until' (for a years worth of days)

        String symbol = "Test";

        edu.alysonhudak.advancedjava.BasicStockService instance = new edu.alysonhudak.adancedjava.BasicStockService();
        List<StockQuote> result = instance.getQuote(symbol, from, until, intveralTime);
        assertNotNull("second getQuote is not null", result);
        assertTrue("tird getQuote returns correct list", result.size() <= 2);
    }

    /**
     * Negative Test of the first getQuote method, of class BasicStockService.
     */
    public void testGetQuoteFirstMethodNegative() {
        String symbol = "Name";
        BasicStockService instance = new BasicStockService();
        StockQuote result = instance.getQuote(null, null);
        assertNull("getQuote is null", result.getDateRecorded());
    }

    /**
     * NegativeTest of the second getQuote method, of class BasicStockService.
     */
    public void testGetQuotesSecondMethodNegative() {

        Calendar from = Calendar.getInstance(); //get instance of calender
        from.setTime(startDate); //set calender time to start date from params

        Calendar until = Calendar.getInstance(); //get instance of calender
        until.setTime(startDate);
        until.add(Calendar.DAY_OF_YEAR, 2); //add days to 'until'

        String symbol = "Test";

        BasicStockService instance = new BasicStockService();
        List<StockQuote> result = instance.getQuote(symbol, from, until);

        assertFalse("second getQuote returns incorrect list", result.size() == 3);
    }

    /**
     * Negative Test of the third getQuote method, of class BasicStockService.
     */
    public void testGetQuotesThirdMethodNegative() {
        IntervalEnum intveralTime = IntervalEnum.Years;

        Calendar from = Calendar.getInstance(); //get instance of calender
        from.setTime(startDate); //set calender time to start date from params

        Calendar until = Calendar.getInstance(); //get instance of calender
        until.setTime(startDate);
        until.add(Calendar.DAY_OF_YEAR, 365); //add days to 'until'

        String symbol = "Test";

        edu.alysonhudak.advancedjava.BasicStockService instance = new edu.alysonhudak.advancedjava.BasicStockService();
        List<StockQuote> result = instance.getQuote(symbol, from, until, IntervalEnum.Days);

        assertFalse("third getQuote returns incorrect list", result.size() <= 2);
    }
}