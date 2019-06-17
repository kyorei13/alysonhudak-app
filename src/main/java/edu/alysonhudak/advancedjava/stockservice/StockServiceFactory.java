package edu.alysonhudak.advancedjava.stockservice;

import edu.alysonhudak.advancedjava.BasicStockService;
import edu.alysonhudak.advancedjava.StockService;

/**
 * Returns a concrete implementation of the interface
 *
 * @author Alyson Hudak
 */


public class StockServiceFactory {

    private StockServiceFactory() {
    }

    private static StockService service;

    /**
     * @return a basic stock service
     */
    public static StockService getInstance() {

        synchronized (StockServiceFactory.class) {
            if (service == null) {
                service = new BasicStockService();
            }
            return service;
        }
    }
}
