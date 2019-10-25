package edu.alysonhudak.advancedjava;

import edu.alysonhudak.advancedjava.model.Quotes;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * A unit test for the Quotes class
 *
 * @author Alyson Hudak
 */
public class QuotesTest {

    public  static final Calendar timeStampCalendar = Calendar.getInstance();

    static {
        timeStampCalendar.set(2013, Calendar.JUNE, 10);
    }

    final static String symbol = "APPL";
    final static Timestamp time = new Timestamp(timeStampCalendar.getTimeInMillis() + 10000);
    final static BigDecimal price = new BigDecimal(100);

    /**
     * Testing helper method for generating Quotes test data
     *
     * @return a Quotes object that uses static constants for data
     */
    public static Quotes createQuote() {
        Quotes quote = new Quotes();
        quote.setSymbol(symbol);
        quote.setTime(time);
        quote.setPrice(price);
        return quote;
    }

    /**
     * A test that tests setters and getters in the Quotes class are both working correctly.
     */
    @Test
    public void testQuoteSettersAndGetters() {
        Quotes quote = createQuote();
        int id = 10;
        quote.setId(id);
        assertEquals("Symbol", symbol, quote.getSymbol());
        assertEquals("Time", time, quote.getTime());
        assertEquals("Price", price, quote.getPrice());
        assertEquals("id", id, quote.getId());

    }

    /**
     * A test that two separate instances of Quotes class can be created and
     * verified they are the same.
     */
    @Test
    public void testEquals() {
        Quotes quote = createQuote();
        assertTrue("Same objects are equal", quote.equals(createQuote()));
    }

    /**
     * A test that the toString method in Quotes returns the expected value
     * @throws Exception
     */
    @Test
    public void testToString() throws Exception{
        Quotes quote = createQuote();
        System.out.println(quote.toString());
        assertEquals("Verify toString works correctly", "Quote{id=0, symbol='" + symbol + "', time='" + time + "', price=" + price + "}", quote.toString());
    }
}
