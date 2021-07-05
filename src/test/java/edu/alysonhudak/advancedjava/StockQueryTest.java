package edu.alysonhudak.advancedjava;;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for the StockQuery Class
 *
 * @author Alyson Hudak
 */
public class StockQueryTest {

    @Test
    public void testBasicConstruction() throws Exception{
        String symbol = "APPL";
        StockQuery stockQuery = new StockQuery(symbol,"2010/08/08","2011/08/08");
        assertEquals("Verify construction.", symbol, stockQuery.getSymbol());
    }
}