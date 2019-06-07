package edu.alysonhudak.advancedjava.stockservice;

import edu.alysonhudak.advancedjava.model.StockQuote;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * A edu.alysonhudak.advancedjava.stockservice.BasicStockService Class that has a method that returns an instance of edu.alysonhudak.advancedjava.model.StockQuote
 *
 * @author Alyson Hudak
 */

class BasicStockService implements StockService {

    @Override
    public StockQuote getQuote(String symbol) {
        return new StockQuote(symbol, new BigDecimal(10), Calendar.getInstance().getTime());
    }
}