package edu.alysonhudak.advancedjava.stockservice;

import edu.alysonhudak.advancedjava.model.database.Person;
import edu.alysonhudak.advancedjava.model.database.Quotes;
import java.util.List;

/**
 * This API is used to read records in the Person table of the stocks database.
 *
 * @author Alyson Hudak
 */
public interface PersonService {

  /**
   * Get a list of all the people
   *
   * @return a list of Person instances
   * @throws PersonServiceException if a service can not read or write the requested data
   *                                    or otherwise perform the requested operation.
   */
  List<Person> getPerson() throws PersonServiceException;

  /**
   * Add a new person or update an existing Person's data
   *
   * @param person a person object to either update or create
   * @throws PersonServiceException if a service can not read or write the requested data
   *                                    or otherwise perform the requested operation.
   */
  void addOrUpdatePerson(Person person) throws PersonServiceException;

  /**
   * Get a list of all a person's quotes.
   *
   * @param person the person to get quotes for
   * @return a list of quote instances
   * @throws PersonServiceException if a service can not read or write the requested data
   *                                    or otherwise perform the requested operation.
   */
  List<Quotes> getQuotes(Person person) throws PersonServiceException;

  /**
   * Assign a quote to a person.
   *
   * @param quote  The hobby to assign
   * @param person The person to assign the quote too.
   * @throws PersonServiceException if a service can not read or write the requested data
   *                                    or otherwise perform the requested operation.
   */
  public void addQuotesToPerson(Quotes quote, Person person) throws PersonServiceException;

}