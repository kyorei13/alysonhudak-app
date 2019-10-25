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
    private StockServiceFactory() {
    }

    /**
     * @return get a <CODE>StockService</CODE>
     * @throws StockServiceException if unable to do this
     */
    public static StockService getStockService() throws StockServiceException {
        try {
            return new YahooStockServiceAdapter();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new StockServiceException("Unable to produce an instance of a class that implements the StockService interface.");
        }
    }

    /**
     * @return get a <CODE>PersonService</CODE>instance
     * @throws PersonServiceException if unable to do this
     */
    public static PersonService getPersonService() throws PersonServiceException {

        try {
            return new DatabasePersonService();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new PersonServiceException("Unable to produce an instance of a class that implements the PersonService interface.");
        }
    }
}
