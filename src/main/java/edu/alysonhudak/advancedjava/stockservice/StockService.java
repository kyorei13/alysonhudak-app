package edu.alysonhudak.advancedjava.stockservice;

import edu.alysonhudak.advancedjava.model.StockQuote;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

    /**
     * This interface describes API for getting stock data.
     * It contains three methods that take in different parameters,
     * each returning a unique type of stock data.
     *
     * @author : Alyson Hudak
     */

    public interface StockService {

        /**
         * Return the price of a share of stock  for the given symbol
         *
         * @param symbol represents the stock symbol name
         * @return a <CODE>StockQuote</CODE> instance
         */

        StockQuote getQuote(String symbol, Date date);

        /**
         * get a historical list of stock quotes based on date range
         *
         * @param symbol represents the stock symbol name
         * @param from from date of first stock
         * @param until until date of last stock quote
         * @param interval specifies the frequency of the stock requested
         * @return a list of StockQuote Instances
         * one for each day in date range
         */
        List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, IntervalEnum interval);
    }