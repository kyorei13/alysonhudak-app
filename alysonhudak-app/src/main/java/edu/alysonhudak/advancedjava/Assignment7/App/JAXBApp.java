package edu.alysonhudak.advancedjava.Assignment7.App;


import edu.alysonhudak.advancedjava.model.database.Quotes;
import edu.alysonhudak.advancedjava.util.DatabaseInitializationException;
import edu.alysonhudak.advancedjava.util.DatabaseUtils;
import edu.alysonhudak.advancedjava.Assignment7.Xml.Stocks;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * A basic app that shows how to marshall and unmarshall XML instances.
 *
 * @author Alyson Hudak
 */
public class JAXBApp {

    private static final String XML_FILE_PATH = "./src/main/resources/xml/stock_info.xml";

    /**
     * Run the JAXB application.
     * <p/>
     *
     * @param args potentially contains a list of arguments to be used in the application
     * -- empty for this particular application
     * @throws javax.xml.bind.JAXBException
     * @throws edu.alysonhudak.advancedjava.util.DatabaseInitializationException
     */
    public static void main(String[] args) throws JAXBException, DatabaseInitializationException {
        //initialize database
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
        System.out.println(DatabaseUtils.initializationFile);

        // here is how to go from XML to Java
        JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Stocks stocks = (Stocks) unmarshaller.unmarshal(new File(XML_FILE_PATH));

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

        // here is how to go from Java to XML
        JAXBContext context = JAXBContext.newInstance(Stocks.class);
        Marshaller marshaller = context.createMarshaller();
        //for pretty-print XML in JAXB
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(stocks, System.out);
    }
}