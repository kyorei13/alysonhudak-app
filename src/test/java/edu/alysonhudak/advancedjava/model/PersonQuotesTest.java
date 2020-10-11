package edu.alysonhudak.advancedjava;;

import edu.alysonhudak.advancedjava.model.Person;
import edu.alysonhudak.advancedjava.model.PersonQuotes;
import edu.alysonhudak.advancedjava.model.Quotes;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A unit test for the PersonQuotes class
 *
 * @author Alyson Hudak
 */
public class PersonQuotesTest {

    /**
     * Testing helper method for generating PersonQuotes test data
     *
     * @return a PersonQuotes object that uses both Person and Quotes
     * returns from their respective create method.
     */
    public static PersonQuotes createPersonQuote() {
        Person person = PersonTest.createPerson();
        Quotes quote = QuotesTest.createQuote();
        return new PersonQuotes(person, quote);
    }

    /**
     * A test that tests setters and getters in the PersonQuotes class to ensure working correctly.
     */
    @Test
    public void testPersonQuoteGetterAndSetters() {
        Quotes quote = QuotesTest.createQuote();
        Person person = PersonTest.createPerson();
        PersonQuotes personQuote = new PersonQuotes();
        int id = 10;
        personQuote.setId(id);
        personQuote.setPerson(person);
        personQuote.setQuote(quote);
        assertEquals("Person matches", person, personQuote.getPerson());
        assertEquals("Quote matches", quote, personQuote.getQuote());
        assertEquals("Id matches", id, personQuote.getId());
    }

    /**
     * Test that two separate instances of PersonQuotes class can be created and
     * verified that they are different.
     */
    @Test
    public void testEqualsNegativeDifferentPerson() {
        PersonQuotes personQuote = createPersonQuote();
        personQuote.setId(10);
        Quotes quote = QuotesTest.createQuote();
        Person person = new Person();
        Timestamp birthDate = new Timestamp(PersonTest.birthDayCalendar.getTimeInMillis() + 10000);
        person.setBirthDate(birthDate);
        person.setFirstName(PersonTest.firstName);
        person.setLastName(PersonTest.lastName);
        PersonQuotes personQuote2 = new PersonQuotes(person, quote);
        assertFalse("Different person", personQuote.equals(personQuote2));
    }

    /**
     * A test that two separate instances of PersonQuotes class can be created and
     verified that they are the same.
     */
    @Test
    public void testEquals() {
        PersonQuotes personQuote = createPersonQuote();
        assertTrue("Same objects are both equal", personQuote.equals(createPersonQuote()));
    }


    /**
     * Test that the toString method in PersonQuotes returns the expected value
     */

    @Test
    public void testToString() {
        PersonQuotes personQuote = createPersonQuote();
        assertTrue("toString has lastName", personQuote.toString().contains(PersonTest.lastName));
        assertTrue("toString has person", personQuote.toString().contains(PersonTest.firstName));
        assertTrue("toString has symbol", personQuote.toString().contains(QuotesTest.symbol));
        assertTrue("toString has time", personQuote.toString().contains(QuotesTest.time.toString()));
        assertTrue("toString has price", personQuote.toString().contains(QuotesTest.price.toString()));
    }
}