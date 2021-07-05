package edu.alysonhudak.advancedjava.model;

import java.text.SimpleDateFormat;

/**
 * Abstract base class for the classes that hold Stock data.
 * Provides a common code for such classes including date formatting.
 *
 * @author Alyson Hudak
 */

public abstract class StockData {

    /**
     * Provide a single SimpleDateFormat for consistency
     * and to avoid duplicated code.
     */
    protected SimpleDateFormat simpleDateFormat;

    public static final String dateFormat = "yyyy-MM-dd HH:mm:ss";

    /**
     * Base constructor for StockData classes.
     * Initialize member data that is shared with sub classes.
     */
    public StockData() {
        simpleDateFormat = new SimpleDateFormat(dateFormat);
    }
}