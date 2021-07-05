package edu.alysonhudak.advancedjava.stockservice;


/**
 * Enums specify the intervals that may be wanted in the stock application
 *
 * @author Alyson Hudak
 */

public enum Interval {

    HOUR(1),
    DAY(24 * 1),
    WEEK(24 * 7),
    MONTH(24 * 30);

    private final int interval;

    /**
     * Create a new Interval instance
     * @param requestedInterval the time frame to obtain the quotes for
     * @param intervalMinutes the total minutes for each defined interval
     */
    private Interval(int requestedInterval){
        this.interval = requestedInterval;
    }

    /**
     *
     * @return The time frame/interval selected
     */
    public int getInterval(){
        return interval;
    }
}