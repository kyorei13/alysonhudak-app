package edu.alysonhudak.advancedjava.stockservice;

/**
 * Returns a concrete implementation of the interface
 *
 * @author Alyson Hudak
 */

public class StockServiceFactory {

    /**
     * Prevent instantiations
     */
    private StockServiceFactory() {}

    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockService getStockServiceInstance() {
        return new DatabaseStockService();
    }

    /**
     *
     * @return get a <CODE>PersonService</CODE> instance
     */
    public static PersonService getPersonServiceInstance() {
        return new DatabasePersonService();
    }
}
© 2019 GitHub, Inc.