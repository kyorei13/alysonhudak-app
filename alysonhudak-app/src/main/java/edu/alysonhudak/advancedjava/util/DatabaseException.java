package edu.alysonhudak.advancedjava.util;

/**
 * A higher level exception that tells the client accessing the database failed. .
 *
 * @author Alyson Hudak
 */

public class DatabaseException extends Exception {

    /**
     * Constructs a new exception with the specified detail message and
     * cause.
     *
     * @param  message the detail message*
     * @param  cause the cause (
     * @since  1.4
     */
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}