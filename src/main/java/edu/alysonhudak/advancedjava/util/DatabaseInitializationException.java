package edu.alysonhudak.advancedjava;

/**
 * This class is used to signal if there is a problem initializing to a database.
 *
 * @author Alyson Hudak
 */
class DatabaseInitializationException extends Exception {

    /**
     * Constructs a new exception with the specified detailed message and
     * cause.
     *
     * @param  message the detailed message
     * @param  cause the cause
     * @since  1.4
     */
    DatabaseInitializationException(String message, Throwable cause) {
        super(message, cause);
    }
}