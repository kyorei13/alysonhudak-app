package edu.alysonhudak.advancedjava.stockservice;

import edu.alysonhudak.advancedjava.model.StockQuote;

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

}