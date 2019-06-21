package edu.alysonhudak.advancedjava.model;

import javax.annotation.concurrent.Immutable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * This class contains information about a stock.
 * This class is immutable. It holds stock information for a given point in time.
 *
 * @author Alyson Hudak
 */

@Immutable

public class StockQuote {
    //Stock properties
    private final String stockSymbol;
    private final BigDecimal stockPrice;
    private final Date transactionDate;

    /**
     * Create a new  StockData instance
     * @param stockSymbol the stock symbol e.g. APPL (for APPLE)
     * @param stockPrice the price for stock created
     * @param transactionDate that the stock is recorded
     */
    public StockQuote(String stockSymbol, BigDecimal stockPrice, Date transactionDate) {
        this.stockSymbol = stockSymbol;
        this.stockPrice = stockPrice;
        this.transactionDate = transactionDate;
    }

    /**
     *
     * @return the stock price.
     * e.g. APPL for APPLE
     */

    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    /**
     *
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
