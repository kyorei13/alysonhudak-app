package edu.alysonhudak.advancedjava.stockservice;

import edu.alysonhudak.advancedjava.util.Interval;
import edu.alysonhudak.advancedjava.model.StockQuote;

import java.util.List;
import java.util.Calendar;
import javax.validation.constraints.NotNull;
import org.apache.http.annotation.Immutable;

    /**
     * This interface describes API for getting stock data.
     * It contains three methods that take in different parameters,
     * each returning a unique type of stock data.
     *
     * @author Alyson Hudak
     */
    @Immutable
    public interface StockService {

        /**
         * Return the current price for a share of stock for the given symbol
         *
         * @param symbol the stock symbol of the company you want a quote for, such as:  APPL for APPLE
         * @return a <CODE>BigDecimal</CODE> instance
         * @throws StockServiceException if using the service generates an exception. If this happens,
         * trying the service may work, depending on the actual cause of the error.
         *
         */
        List<StockQuote> getQuote(@NotNull String symbol) throws StockServiceException;

        /**
         * Get a historical list of stock quotes for the provided symbol
         *
         * @param symbol the stock symbol to search for
         * @param from   the date of the first stock quote
         * @param until  the date of the final stock quote
         * @return a list of StockQuote instances
         * @throws   StockServiceException if using the service generates an exception.
         * If this happens, trying the service may work, depending on the actual cause of the error.
         */
        List<StockQuote> getQuote(@NotNull String symbol, @NotNull Calendar from, @NotNull Calendar until) throws StockServiceException;

        /**
         * Get a historical list of stock quotes for the provided symbol
         *
         * @param symbol the stock symbol to search for
         * @param from   the date of the first stock quote
         * @param until  the date of the final stock quote
         * @param interval the time frame for which to get a single quote
         * @return a list of StockQuote instances
         * @throws  StockServiceException if using the service generates an exception.
         *
         */
        List<StockQuote> getQuote(@NotNull String symbol, @NotNull Calendar from, @NotNull Calendar until, @NotNull IntervalEnum interval) throws StockServiceException;
    }

