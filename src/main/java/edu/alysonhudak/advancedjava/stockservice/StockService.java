package edu.alysonhudak.advancedjava.stockservice;

import edu.alysonhudak.advancedjava.model.StockQuote;

import java.util.Calendar;
import java.util.List;

/**
 *
 */
public interface StockService {

    /**
     * Return the price of a share of stock  for the given symbol
     *
     * @param symbol represents the stock symbol name
     * @return a <CODE>edu.alysonhudak.advancedjava.model.StockQuote</CODE> instance
     */
    StockQuote getQuote(String symbol);

    /**
     * get a historical list of stock quotes based on date range
     *
     * @param symbol represents the stock symbol name
     * @param from   date of first stock
     * @param until  date of last stock quote
     * @return a list of StockQuote Instances
     * one for each day in date range
     */
    List<StockQuote> getQuote(String symbol, Calendar from, Calendar until);
}