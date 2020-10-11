package edu.alysonhudak.advancedjava;


import edu.alysonhudak.advancedjava.model.Person;
import edu.alysonhudak.advancedjava.model.Quotes;
import edu.alysonhudak.advancedjava.stockservice.PersonService;
import edu.alysonhudak.advancedjava.stockservice.PersonServiceException;
import edu.alysonhudak.advancedjava.stockservice.ServiceFactory;
import edu.alysonhudak.advancedjava.util.DatabaseUtils;
import edu.alysonhudak.advancedjava.model.PersonTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * The unit tests for the DatabasePersonService
 *
 * @author Alyson Hudak
 */
public class DatabasePersonServiceTest {

    /**
     * Declare an instance of PersonService
     * that can be used throughout this test class
     */
    private PersonService personService;

    /**
     * Initialize the database through DatabaseUtils class and then
     * initialize databaseStockService variable to a new instance of PersonService class
     * @throws Exception
     */
    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    /**
     * Initialize the database through DatabaseUtils class and then
     * initialize databaseStockService variable to a new instance of PersonService class
     * @throws Exception
     */

    @Before
    public void setUp() throws Exception {
        initDb();
        personService = ServiceFactory.getPersonServiceInstance();
    }

    /**
     * Clean up/restore to initial state
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        initDb();
    }

    /**
     * A test to check that the personService instance is not null
     */
    @Test
    public void testGetInstance() {
        assertNotNull("Make sure that personService is available", personService);
    }

    /**
     * A test that the person objects can be retrieved from the database with the
     * getPerson method
     * @throws PersonServiceException
     */
    @Test
    public void testGetPerson() throws PersonServiceException {
        List<Person> personList = personService.getPerson();
        assertFalse("Make sure to get some Person objects from service", personList.isEmpty());
    }

    /**
     * A test that a person objects can be added or updated
     * @throws PersonServiceException
     */
    @Test
    public void testAddOrUpdatePerson()throws PersonServiceException {
        Person newPerson = PersonTest.createPerson();
        personService.addOrUpdatePerson(newPerson);
        List<Person> personList = personService.getPerson();
        boolean found = false;
        for (Person person : personList) {
            Timestamp returnedBirthDate = person.getBirthDate();
            Calendar returnCalendar = Calendar.getInstance();
            returnCalendar.setTimeInMillis(returnedBirthDate.getTime());
            if (returnCalendar.get(Calendar.MONTH) == PersonTest.birthDayCalendar.get(Calendar.MONTH)
                    &&
                    returnCalendar.get(Calendar.YEAR) == PersonTest.birthDayCalendar.get(Calendar.YEAR)
                    &&
                    returnCalendar.get(Calendar.DAY_OF_MONTH) == PersonTest.birthDayCalendar.get(Calendar.DAY_OF_MONTH)
                    &&
                    person.getLastName().equals(PersonTest.lastName)
                    &&
                    person.getFirstName().equals(PersonTest.firstName)) {
                found = true;
                break;
            }
        }
        assertTrue("Found the person added", found);
    }

    /**
     * A test that quotes can be correctly returned for a given person
     * and verifies both addQuotesToPerson and getQuotes methods
     * @throws PersonServiceException
     */
    @Test
    public void testGetQuotesByPerson() throws PersonServiceException {
        Person person = PersonTest.createPerson();
        List<Quotes> quotes = personService.getQuotes(person);

        for (Quotes quote : quotes) {
            personService.addQuotesToPerson(quote, person);
        }
        List<Quotes> quoteList = personService.getQuotes(person);
        for (Quotes quote : quotes) {
            boolean removed = quoteList.remove(quote);
            assertTrue("Verify that the quote was found on the list", removed);
        }

        assertTrue("Verify the list of returned quotes match what was expected ", quoteList.isEmpty());
    }
}