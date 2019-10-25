package edu.alysonhudak.advancedjava.stockservice;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * This class models a stock service that gets stock data from the Yahoo Finance web service
 * (https://financequotes-api.com/).  It does not implement interface {@code StockService}. Use the adapter
 * class YahooStockServiceAdapter if need access to its functionality from a class that does.
 *
 * @author Alyson Hudak
 */
public class YahooStockService  {

    /**
     * Get a stock quote with current price for the company indicated by the given symbol.
     *
     * @param symbol                    a stock symbol of a company, e.g. "APPL" for Apple
     * @return                          an instance of {@code Stock} (containing the current price) for the
     *                                  company with the given symbol
     * @throws IOException              if an exception occurs when trying to get the quote
     */
    public Stock getLatestStockQuote(@NotNull String symbol) throws IOException {

        Stock stockQuote = null;

        stockQuote = YahooFinance.get(symbol);

        return stockQuote;
    }

    /**
     * Get a list of stock quotes for the company indicated by the given symbol, one for each day in the given date
     * range.
     *
     * @param symbol                    a stock symbol of a company, e.g. "APPL" for Apple
     * @param from                      the date of the first stock quote
     * @param until                     the date of the last stock quote
     * @return                          a list of stock quotes for the company with the given symbol, one for each day
     *                                  in the date range given
     * @throws IOException              if an exception occurs when trying to get the quote list
     */
    public List<HistoricalQuote> getStockQuoteList(@NotNull String symbol, @NotNull Calendar from, @NotNull Calendar until) throws IOException {

        List<HistoricalQuote> stockQuoteList = new ArrayList<>();

        if (!from.after(until)) {
            Stock stock = YahooFinance.get(symbol);
            stockQuoteList = stock.getHistory(from, until, Interval.DAILY);
        }

        return stockQuoteList;
    }

    /**
     * Get a list of stock quotes for the company indicated by the given symbol, one for each period in the given
     * interval in the given date range.
     *
     * @param symbol                    a stock symbol of a company, e.g. "APPL" for Apple
     * @param from                      the date of the first stock quote
     * @param until                     the date of the last stock quote
     * @param interval                  the interval between which stock quotes should be obtained, i.e. if DAILY, then
     *                                  one per day
     * @return                          a list of stock quotes for the company with the given symbol, one for each
     *                                  period in the given interval in the given date range
     * @throws IOException              if an exception occurs when trying to get the quote list
     */
    public List<HistoricalQuote> getStockQuoteList(@NotNull String symbol, @NotNull Calendar from, @NotNull Calendar until, @NotNull Interval interval) throws IOException {

        List<HistoricalQuote> stockQuoteList = new ArrayList<>();

        if (!from.after(until)) {
            Stock stock = YahooFinance.get(symbol);
            stockQuoteList = stock.getHistory(from, until, interval);
        }

        return stockQuoteList;
    }
}