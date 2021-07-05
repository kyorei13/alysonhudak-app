package edu.alysonhudak.advancedjava.stockservice;

import edu.alysonhudak.advancedjava.model.StockQuote;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 * An edu.alysonhudak.advancedjava.stockservice.BasicStockService Class that has a method that returns an instance of edu.alysonhudak.advancedjava.model.StockQuote
 * based on date range passed in
 *
 * @author Alyson Hudak
 */

public class BasicStockService implements StockService {

    /**
     * Returns the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for, such as: APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     *
     */
    @Override
    public StockQuote getQuote(String symbol) {
        // a basic implementation.
        return new StockQuote(new BigDecimal(100), Calendar.getInstance().getTime(), symbol);
    }

    /**
     * Get a historical list of stock quotes for the provided symbol
     *
     * @param symbol the stock symbol to search for
     * @param from date of the first stock quote
     * @param until the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws StockServiceException if using the service generates an exception.
     *
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) {
        // a basic implementation.
        List<StockQuote> stockQuotes = new ArrayList<>();
        Date aDay = from.getTime();
        while (until.after(aDay)) {
            stockQuotes.add(new StockQuote(new BigDecimal(100), aDay, symbol));
            from.add(Calendar.DAY_OF_YEAR, 1);
            aDay = from.getTime();
        }
        return stockQuotes;
    }
}