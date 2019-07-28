package edu.alysonhudak.advancedjava.util;

/**
 * This class is used to signal if there is a problem connecting to a database.
 *
 * @author Alyson Hudak
 */
public class DatabaseConnectionException extends Exception {

    /**
     * Constructs a new exception with the specified detail message and
     * cause.
     *
     * @param  message the detailed message
     * @param  cause the cause
     * @since  1.4
     */
    DatabaseConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}