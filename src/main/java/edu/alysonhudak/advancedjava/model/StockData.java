package edu.alysonhudak.advancedjava.model;

import java.text.SimpleDateFormat;

/**
 * Abstract base class for the classes that hold Stock data.
 * Provides a common code for such classes including date formatting.
 *
 * @author Alyson Hudak
 */

abstract class StockData {

    /**
     * Provide a single SimpleDateFormat for consistency
     * and to avoid duplicated code.
     */
    SimpleDateFormat simpleDateFormat;

    /**
     * Base constructor for StockData classes.
     * Initialize member data that is shared with sub classes.
     */
    StockData() {
        simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    }

}