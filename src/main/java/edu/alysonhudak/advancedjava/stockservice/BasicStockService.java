package edu.alysonhudak.advancedjava.stockservice;

import edu.alysonhudak.advancedjava.model.StockQuote;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A edu.alysonhudak.advancedjava.stockservice.BasicStockService Class that has a method that returns an instance of edu.alysonhudak.advancedjava.model.StockQuote
 * based on date range passed in
 *
 * @author Alyson Hudak
 */

class BasicStockService implements StockService {

    @Override
    public StockQuote getQuote(String symbol) {
        return new StockQuote(symbol, new BigDecimal(10), Calendar.getInstance().getTime());
    }

    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) {
        return new ArrayList<>();
    }
}