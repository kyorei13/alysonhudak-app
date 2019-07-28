package edu.alysonhudak.advancedjava;


import edu.alysonhudak.advancedjava.DatabaseInitializationException;
import edu.alysonhudak.advanjacedjava.DatabaseUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 *  Tests for the DatabaseUtils class
 *
 * @author Alyson Hudak
 */
public class DatabaseUtilsTest {

    /**
     * Test that a connection to the database can be successfully created.
     * @throws Exception
     */
    @Test
    public void testGetConnection() throws Exception{
        Connection connection = DatabaseUtils.getConnection();
        assertNotNull("Verify that a connection can be established.", connection);
    }

    /**
     * Test that a connection to the database can be successfully created and retrieve
     * stock quotes through execution of a statement.
     * @throws Exception
     */
    @Test
    public void testGetConnectionWorks() throws Exception{
        Connection connection = DatabaseUtils.getConnection();
        Statement statement = connection.createStatement();
        boolean execute = statement.execute("Select * from quotes");
        assertTrue("Verify that a statement can be executed.",execute);
    }

    /**
     * Test that can successfully initialize the database with given data file
     * @throws Exception
     */
    @Test
    public void testDatabaseInitializationSuccess() throws Exception{
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    /**
     * Test that will receive a DatabaseInitializationException when a known invalid
     * file name is passed to the initializeDatabase method
     * @throws Exception
     */
    @Test (expected = DatabaseInitializationException.class)
    public void testDatabaseInitializationFailure() throws Exception{
        DatabaseUtils.initializeDatabase("Some string.");
    }
}