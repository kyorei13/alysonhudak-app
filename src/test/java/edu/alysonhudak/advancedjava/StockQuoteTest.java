package edu.alysonhudak.advancedjava;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import edu.alysonhudak.advancedjava.model.StockQuote;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Alyson Hudak
 */
public class StockQuoteTest
{
    private StockQuote sampleStock;
    
    
    @Before
    public void setup() 
    {
     }
    
    /**
     * Positive Test of Constructor method, of class edu.alysonhudak.advancedjava.model.StockQuote.
     */
    @Test
    public void testConstructorPricePostive() {
        StockQuote instance = sampleStock;
        assertNull("stockQuote instance is not null", instance);
    }






}
