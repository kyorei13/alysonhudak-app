package edu.alysonhudak.advancedjava.stockservice;

import edu.alysonhudak.advancedjava.model.database.Person;
import edu.alysonhudak.advancedjava.model.database.PersonQuotes;
import edu.alysonhudak.advancedjava.model.database.Quotes;
import edu.alysonhudak.advancedjava.util.DatabaseUtils;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Alyson Hudak
 */

public class DatabasePersonService implements PersonService {

  /**
   * Get a list of all people
   *
   * @return a list of Person instances
   */
  @Override
  @SuppressWarnings("unchecked")
  public List<Person> getPerson() throws PersonServiceException{
    Session session = DatabaseUtils.getSessionFactory().openSession();
    List<Person> returnValue = null;
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      Criteria criteria = session.createCriteria(Person.class);

      /**
       * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
       * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
       * to suppress them - in almost all other cases they should be fixed not suppressed
       */
      returnValue = criteria.list();

    } catch (HibernateException e) {
      if (transaction != null && transaction.isActive()) {
        transaction.rollback();  // close transaction
      }
      throw new PersonServiceException("Could not get Person data. " + e.getMessage(), e);
    } finally {
      if (transaction != null && transaction.isActive()) {
        transaction.commit();
      }
    }

    return returnValue;

  }

  /**
   * Add a new person or update an existing Person's data
   *
   * @param person a person object to either update or create
   */
  @Override
  public void addOrUpdatePerson(Person person) {
    Session session = DatabaseUtils.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      session.saveOrUpdate(person);
      transaction.commit();
    } catch (HibernateException e) {
      if (transaction != null && transaction.isActive()) {
        transaction.rollback();  // close transaction
      }
    } finally {
      if (transaction != null && transaction.isActive()) {
        transaction.commit();
      }
    }
  }

  /**
   * Get a list of all a person's quotes.
   *
   * @param person the person
   * @return a list of quote instances
   */
  @Override
  @SuppressWarnings("unchecked")
  public List<Quotes> getQuotes(Person person) {
    Session session =  DatabaseUtils.getSessionFactory().openSession();
    Transaction transaction = null;
    List<Quotes> quotes = new ArrayList<>();
    try {
      transaction = session.beginTransaction();
      Criteria criteria = session.createCriteria(PersonQuotes.class);
      criteria.add(Restrictions.eq("person", person));
      /**
       * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
       * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
       * to suppress them - in almost all other cases they should be fixed not suppressed
       */
      List<PersonQuotes> list = criteria.list();
      for (PersonQuotes personQuotes : list) {
        quotes.add(personQuotes.getQuote());
      }
      transaction.commit();
    } catch (HibernateException e) {
      if (transaction != null && transaction.isActive()) {
        transaction.rollback();  // close transaction
      }
    } finally {
      if (transaction != null && transaction.isActive()) {
        transaction.commit();
      }
    }
    return quotes;

  }

  /**
   * Assign a quote to a person.
   *
   * @param quote  The quote to assign
   * @param person The person to assign the quote too.
   */
  @Override
  public void addQuotesToPerson(Quotes quote, Person person) throws PersonServiceException {
    Session session =  DatabaseUtils.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      PersonQuotes personQuote = new PersonQuotes();
      personQuote.setQuote(quote);
      personQuote.setPerson(person);
      session.saveOrUpdate(personQuote);
      transaction.commit();
    } catch (HibernateException e) {
      if (transaction != null && transaction.isActive()) {
        transaction.rollback();  // close transaction
      }
    } finally {
      if (transaction != null && transaction.isActive()) {
        transaction.commit();
      }
    }
  }
}