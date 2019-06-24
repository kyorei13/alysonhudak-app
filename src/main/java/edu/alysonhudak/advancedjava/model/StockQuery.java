package edu.alysonhudak.advancedjava.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * This class contains information about a stock.
 * This class is immutable. It holds stock information for a given point in time.
 *
 * @author Alyson Hudak
 */

import org.apache.http.annotation.Immutable;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.Calendar;

/**
 * This class is used as a single query to stock service.
 *
 * @author Alyson Hudak
 *
 */
@Immutable
public class StockQuery extends StockData{

    private String symbol;
    private Calendar from;
    private Calendar until;

    /**
     * Creates a new instance from the tring data. This constructor will convert the
     * dates described as a string to date objects.
     *
     * @param symbol the stock symbol
     * @param from   the start date in the form of yyyy/MM/dd
     * @param until  the end date in the form of yyyy/MM/dd
     * @throws ParseException if the format of the date String is incorrect. Forces you to try again until it is correct
     */
    public StockQuery(@NotNull String symbol, @NotNull String from, @NotNull String until) throws ParseException {
        super();
        this.symbol = symbol;
        this.from = Calendar.getInstance();
        this.until = Calendar.getInstance();
        System.out.println(simpleDateFormat);
        this.from.setTime(simpleDateFormat.parse(from));
        this.until.setTime(simpleDateFormat.parse(until));
    }

    /**
     * @return get the stock symbol associated with this query
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @return get the start calendar date associated with this query
     */
    public Calendar getFrom() {
        return from;
    }

    /**
     * @return get the end calendar date associated with this query
     */
    public Calendar getUntil() {
        return until;
    }
}