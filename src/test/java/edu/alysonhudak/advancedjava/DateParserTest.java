package edu.alysonhudak.advancedjava;;

import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alyson Hudak
 */

public class DateParserTest {
    
    
    /**
     * Positive Test of the getDateParsed method, of class DateParser.
     */
    @Test
    public void testGetDateParsedPostive() {
        String dateInString = "01/01/2000";
        Calendar expResult = DateParser.getDateParsed("01/03/2000");
        Calendar result = DateParser.getDateParsed(dateInString);
        assertTrue("Date Parser works with bad values", expResult.after(result));
    }

    /**
     * Negative Test of the getDateParsed method, of class DateParser.
     */
    @Test
    public void testGetDateParsedNegative() {
        String dateInString = "01/01/2000";
        Calendar expResult = null;
        Calendar result = DateParser.getDateParsed(dateInString);
        assertFalse("Date Parser works with bad values", expResult == result);
    }
    
    /**
     * Second Negative Test of the getDateParsed method, of class DateParser.
     */
    @Test
    public void testGetDateParsedNegativeWithBadDates() {
        String dateInString = "01/01/1999";
        Calendar expResult = DateParser.getDateParsed("01/05/1999");
        Calendar result = DateParser.getDateParsed(dateInString);
        assertFalse("Date Parser works with bad values", expResult.before(result));
    }
}
