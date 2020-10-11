package edu.alysonhudak.advancedjava.model;

/**
 * This class contains information about a stock.
 * This class is immutable. It holds stock information for a given point in time.
 *
 * @author Alyson Hudak
 */

import edu.alysonhudak.advancedjava.Interval;
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

    private final String symbol;
    private final Calendar from;
    private final Calendar until;
    private final Interval interval;

    /**
     * Creates a new instance from the string data. This constructor will convert the
     * dates described as a string to date objects.
     *
     * @param symbol the stock symbol
     * @param from   the start date in the form of yyyy/MM/dd
     * @param until  the end date in the form of yyyy/MM/dd
     * @throws ParseException if the format of the date String is incorrect. Forces you to try again until it is correct
     */
    public StockQuery(@NotNull String symbol, @NotNull String from, @NotNull String until, @NotNull IntervalEnum interval) throws ParseException {
        super();
        this.symbol = symbol;
        this.from = Calendar.getInstance();
        this.until = Calendar.getInstance();
        this.from.setTime(simpleDateFormat.parse(from));
        this.until.setTime(simpleDateFormat.parse(until));
        this.interval = IntervalEnum.HOUR;
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

    /**
     * @return get the interval to display quotes for
     */
    public Interval getInterval() {
        return interval;
    }
}