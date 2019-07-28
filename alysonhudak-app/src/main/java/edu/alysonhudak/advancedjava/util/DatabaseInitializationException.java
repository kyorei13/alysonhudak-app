package edu.alysonhudak.advancedjava.util;

/**
 * This class is used to signal if there is a problem initializing to a database.
 *
 * @author Alyson Hudak
 */
public class DatabaseInitializationException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message.
     */
    public DatabaseInitializationException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and
     * cause.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).
     * @since  1.4
     */
    public DatabaseInitializationException(String message, Throwable cause) {
        super(message, cause);
    }
}