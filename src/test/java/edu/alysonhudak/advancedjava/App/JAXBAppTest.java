package edu.alysonhudak.advancedjava.App;

import edu.alysonhudak.advancedjava.model.database.Quotes;
import edu.alysonhudak.advancedjava.util.DatabaseConnectionException;
import edu.alysonhudak.advancedjava.util.DatabaseInitializationException;
import edu.alysonhudak.advancedjava.util.DatabaseUtils;
import edu.alysonhudak.advancedjava.Assignment7.Xml.Stocks;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Tests for JAXBApp
 *
 * @author Alyson Hudak
 */

public class JAXBAppTest {

    private static final String XML_STOCKS_TEST =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<stocks>\n" +
                    "    <stock symbol=\"TST1\" price=\"101.10\" time=\"2001-01-01 01:01:01\"></stock>\n" +
                    "    <stock symbol=\"TST2\" price=\"202.20\" time=\"2002-02-02 02:02:02\"></stock>\n" +
                    "    <stock symbol=\"TST3\" price=\"303.30\" time=\"2003-03-03 03:03:03\"></stock>\n" +
                    "    <stock symbol=\"TST4\" price=\"404.40\" time=\"2004-04-04 04:04:04\"></stock>\n" +
                    "    <stock symbol=\"TST5\" price=\"505.50\" time=\"2005-05-05 05:05:05\"></stock>\n" +
                    "</stocks>";


    @Before
    public void setUp() throws DatabaseInitializationException{
        //initialize database
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    /**
     * This method tests that stocks can successfully be added to the mocked database
     * @throws JAXBException
     *
     */
    @Test
    public void testAddStocksToDatabase() throws JAXBException, DatabaseConnectionException, SQLException{
        JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Stocks stocks = (Stocks) unmarshaller.unmarshal(new StringReader(XML_STOCKS_TEST));

        //loop through each stock in the list of stocks returned from the unmarshaller
        for (int i = 0; i < stocks.getStock().size(); i++){
            //create new quote from each stock in stocks
            Quotes quote = new Quotes(stocks.getStock().get(i));

            //open hibernate session and persist each quote, then close session
            Session session = DatabaseUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(quote);
            transaction.commit();
            session.flush();
            session.close();
        }

        Connection connection = DatabaseUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from quotes;");

        int size = 0;
        if (resultSet != null){
            resultSet.last();
            size = resultSet.getRow();
        }

        assertEquals(size, 13);

    }

    @Test
    public void testDatabaseCleanUp() throws DatabaseInitializationException, JAXBException, SQLException, DatabaseConnectionException{
        Connection connection = DatabaseUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from quotes;");

        int size = 0;
        if (resultSet != null){
            resultSet.last();
            size = resultSet.getRow();
        }

        assertEquals(size, 8);
    }

    @After
    public void tearDown() throws DatabaseInitializationException{
        //initialize database
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }
}