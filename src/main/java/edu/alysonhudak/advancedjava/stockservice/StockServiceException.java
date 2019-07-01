package edu.alysonhudak.advancedjava.stockservice;

/**
 * Used to signal if there is a problem with the StockService.
 *
 * @author Alyson Hudak
 */
public class StockServiceException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message.
     */
    StockServiceException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and
     * cause.
     *
     * @param message the detailed message
     * @since 1.4
     */
    public StockServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}