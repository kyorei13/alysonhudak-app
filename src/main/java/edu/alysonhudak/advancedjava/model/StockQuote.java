package edu.alysonhudak.advancedjava.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * This class contains information about a stock.
 * This class is immutable. It holds stock information for a given point in time.
 *
 * @author Alyson Hudak
 */

public class StockQuote {
    //Stock properties
    private String stockSymbol;
    private BigDecimal stockPrice;
    private Date transactionDate;

    /**
     * Create a new  StockData instance
     *
     * @param stockSymbol the stock symbol e.g. APPL (for APPLE)
     * @param stockPrice  the price for stock created
     */
    public StockQuote(String stockSymbol, BigDecimal stockPrice, Date transactionDate) {
        this.stockSymbol = stockSymbol;
        this.stockPrice = stockPrice;
        this.transactionDate = transactionDate;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    /**
     * @return the stock price.
     * e.g. APPL for APPLE
     */
    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    /**
     * @return the date of the stock price.
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {
        return "StockQuote{" +
                "stockSymbol='" + stockSymbol + '\'' +
                ", stockPrice=" + stockPrice +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
