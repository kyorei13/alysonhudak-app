package edu.alysonhudak.advancedjava;

import edu.alyonhudak.advancedjava.stockservice.PersonService;
import edu.alyonhudak.advancedjava.stockservice.StockService;
import edu.alyonhudak.advancedjava.stockservice.ServiceFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * A JUnit test for <CODE>ServiceFactory</CODE>
 *
 * @author Alyson Hudak
 */
public class ServiceFactoryTest {
    /**
     * This method verifies that a valid StockService Object
     * is returned by the getStockServiceInstance method.
     */
    @Test
    public void testGetStockServiceInstance() {
        StockService stockService = ServiceFactory.getStockServiceInstance();
        assertNotNull("Make sure that factory works.", stockService);
    }

    /**
     * This method verifies that a valid PersonService Object
     * is returned by the getPersonServiceInstance method.
     */
    @Test
    public void testGetPersonServiceInstance() {
        PersonService personService = ServiceFactory.getPersonServiceInstance();
        assertNotNull("Make sure that factory works.", personService);
    }
}