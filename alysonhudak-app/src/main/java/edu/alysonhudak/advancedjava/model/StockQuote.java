package edu.alysonhudak.advancedjava.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * This class contains information about a stock.
 *
 * @author Alyson Hudak
 */

@Immutable

public class StockQuote extends StockData {

    private BigDecimal price;
    private Date date;
    private String symbol;

    /**
     * Create a new instance of a StockQuote.
     *
     * @param price  the stock price for the given date
     * @param date   the date of the stock price
     * @param symbol the stock symbol.
     */
    public StockQuote(@NotNull BigDecimal price, Date date, String symbol) {
        super();
        this.price = price;
        this.date = date;
        this.symbol = symbol;
    }

    /**
     * @return Get the stock price for the given date.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @return The date of the stock price
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return The stock symbol.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * This method overrides the toString method to display the attributes of the
     * StockQuote object as a String
     * @return String containing attributes of StockQuote object
     */
    @Override
    public String toString() {
        String dateString = simpleDateFormat.format(date);
        return "StockQuote{" +
                "price=" + price +
                ", date=" + dateString +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}