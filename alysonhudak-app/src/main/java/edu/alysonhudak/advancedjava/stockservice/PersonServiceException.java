package edu.alysonhudak.advancedjava.stockservice;

/**
 * Used to signal if there is an issue with PersonService
 *
 * @author Alyson Hudak
 */
public class PersonServiceException extends Exception {

  /**
   * Constructs a new exception with the specified detail message and
   * cause.
   *
   * @param message the detail message
   *
   * @param cause   the cause
   *
   * @since 1.4
   */
  public PersonServiceException(String message, Throwable cause) {
    super(message, cause);
  }
}