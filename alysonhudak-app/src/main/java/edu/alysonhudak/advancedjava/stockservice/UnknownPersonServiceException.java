package edu.alysonhudak.advancedjava.stockservice;

/**
 * Used to signal a user that was expected to exist in the system does not.
 *
 * @author Alyson Hudak
 */
public class UnknownPersonServiceException extends Exception {

  /**
   * Constructs a new exception with the specified detail message.  The
   * cause is not initialized, and may subsequently be initialized by
   * a call to {@link #initCause}.
   *
   * @param message the detail message.
   */
  public UnknownPersonServiceException(String message) {
    super(message);
  }

  /**
   * Constructs a new exception with the specified detail message and
   * cause.
   *
   * @param message the detail message
   * @param cause   the cause (
   * @since 1.4
   */
  public UnknownPersonServiceException(String message, Throwable cause) {
    super(message, cause);
  }
}