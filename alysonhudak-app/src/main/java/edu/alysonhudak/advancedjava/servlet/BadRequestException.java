package edu.alysonhudak.advancedjava.servlet;

/**
 * This class is used to signal a problem handling an http request.
 *
 * @author Alyson Hudak
 */
public class BadRequestException extends Exception {

    /**
     * This method constructs a new exception with the specified detail message.
     *
     * @param message   a detail message
     */
    public BadRequestException(String message) { super(message); }

    /**
     * This method constructs a new exception with the specified detail message and cause.
     *
     * @param message   a detailed message (which may be retrieved by the {@link #getMessage()} method)
     * @param cause     a cause (which may be retrieved by the {@link #getCause()} method)
     */
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}