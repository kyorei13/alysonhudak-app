package edu.alysonhudak.advancedjava;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alyson Hudak
 */
public class StockServiceTest {
    
    /**
     * Positive Test of the getQuote method, of class StockService.
     */
    @Test
    public void testGetQuoteFirstPositive() {
        String symbol = "Name";
        Date date = new Date();
        StockService instance = new StockServiceImpl();
        StockQuote result = instance.getQuote(symbol, date);
        assertNotNull("First Get Quote works properly.", result);
    }

    /**
     * Positive Test of the second getQuote method, of class StockService.
     */
    @Test
    public void testGetQuoteSecondPositive() {
        String symbol = "Name";
        Calendar from = Calendar.getInstance();
        Calendar until = Calendar.getInstance();
        until.add(Calendar.DAY_OF_YEAR, 1);

        StockService instance = new StockServiceImpl();
        List<StockQuote> result = instance.getQuote(symbol, from, until);
        assertNotNull("Second Get Quote works properly.", result);
    }

    /**
     * Positive Test of the third getQuote method, of class StockService.
     */
    @Test
    public void testGetQuoteThirdPositive() {
        String symbol = "Name";
        Calendar from = Calendar.getInstance();
        Calendar until = Calendar.getInstance();
        until.add(Calendar.DAY_OF_YEAR, 365);
        IntervalEnum intveralTime = IntervalEnum.Years;

        StockService instance = new StockServiceImpl();
        List<StockQuote> result = instance.getQuote(symbol, from, until, intveralTime);
        assertNotNull("Third Get Quote works properly", result);
    }

     /**
     * Negative Test of the getQuote method, of class StockService.
     */
    @Test
    public void testGetQuoteFirstNegative() {
        String symbol = "Name";
        Date date = new Date();
        StockService instance = new StockServiceImpl();
        StockQuote result = instance.getQuote(symbol, null);
        assertNull("First Get Quote with invalid data.", result.getDateRecorded());
    }
    
     /**
     * Negative Test of the second getQuote method, of class StockService.
     */
    @Test
    public void testGetQuoteSecondNegative() {
        String symbol = "Name";
        Calendar from = Calendar.getInstance();
        Calendar until = Calendar.getInstance();
        until.add(Calendar.DAY_OF_YEAR, 1);
        
        StockService instance = new StockServiceImpl();
        List<StockQuote> result = instance.getQuote(symbol, until, from);
        assertFalse("Second Get Quote bad dates works.", result.size() > 1);
    }
    
     /**
     * Negative Test of the third getQuote method, of class StockService.
     */
    @Test
    public void testGetQuoteThirdNegative() {
        String symbol = "Name";
        Calendar from = Calendar.getInstance();
        Calendar until = Calendar.getInstance();
        until.add(Calendar.DAY_OF_YEAR, 365);
        IntervalEnum intveralTime = IntervalEnum.Years;
        
        StockService instance = new StockServiceImpl();
        List<StockQuote> result = instance.getQuote(symbol, from, until, intveralTime);
        assertFalse("Third Get Quote works after bad data.", result.size() > 2);
    }

    /* The following implementation is just for testing purposes*/
    public class StockServiceImpl implements StockService {
        public StockQuote getQuote(String symbol, Date date) {
            return new StockQuote(symbol, 7.99, date);
        }

    /* The following method returns a list of stocks by hard coding date in while loop based on the dates*/
         public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) {
        
            /* get Date objects from the Calender objects passed in*/
            Date startDate = from.getTime();
            Date endDate = until.getTime();

            Calendar calendar = Calendar.getInstance(); //gets instance of calender
            calendar.setTime(startDate); //sets calender time to start date from params

            List<StockQuote> listOfStocks = new ArrayList();

            /* adds some "dummy" data for the dates, hard codes the price*/
            while(startDate.before(endDate)){
                listOfStocks.add(new StockQuote(symbol, 7.99, startDate));
                calendar.setTime(startDate); 
                calendar.add(Calendar.DAY_OF_YEAR, 1); //add a day to calender
                startDate = calendar.getTime(); //change date 
            }
       
            return listOfStocks;
         }   

        public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, IntervalEnum interval) {
            int intervalTime = 1; //Variable determines incrementation for the calender in while loop (changes based on enum passed in)
        
            /* get Date objects from the Calender objects passed in*/
            Date startDate = from.getTime();
            Date endDate = until.getTime();

            Calendar calendar = Calendar.getInstance(); //get instance of calender
            calendar.setTime(startDate); //set calender time to start date from params

            List<StockQuote> listOfStocks = new ArrayList();

            /* The following switch statement determines the frequency of the stock data retrieval based on the interval enum*/
            switch(interval){
                case Days : intervalTime = 1;
                    break;
                case Weeks : intervalTime = 7;
                    break;
                case Months : intervalTime = 30;
                    break;
                case Years : intervalTime = 365;
                    break;
                default : break;
            }
            /* adds dummy data for the dates, hard codes price*/
            while(startDate.before(endDate)){
                listOfStocks.add(new StockQuote(symbol, 7.99, startDate));
                calendar.setTime(startDate); 
                //System.out.println("\nInStockService(intervalTime)\n" + intervalTime);
                calendar.add(Calendar.DAY_OF_YEAR, intervalTime); //adds days to calender

                startDate = calendar.getTime(); //changes date
            }
       
       return listOfStocks;
        }
    }
}
