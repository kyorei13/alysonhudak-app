package edu.alysonhudak.advancedjava.stockservice;

import edu.alysonhudak.advancedjava.model.StockQuote;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 * An edu.alysonhudak.advancedjava.stockservice.BasicStockService Class that has a method that returns an instance of edu.alysonhudak.advancedjava.model.StockQuote
 * based on date range passed in
 *
 * @author Alyson Hudak
 */

public class BasicStockService implements StockService {

    /*This method simply returns a new stock quote with data hard coded/passed in*/
    public StockQuote getQuote(String symbol, Date date) {
        return new StockQuote(symbol, 7.99, date);
    }

    /* The Following method return a list of stocks by hard coding most of the data in a while loop based on the dates*/
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) {

        /* get Date objects from the Calender objects passed in*/
        Date startDate = from.getTime();
        Date endDate = until.getTime();

        Calendar calendar = Calendar.getInstance(); //get instance of calender
        calendar.setTime(startDate); //sets calender time to start date from params

        List<StockQuote> listOfStocks = new ArrayList();

        /* adds dummy data for the dates, hard codes the price*/
        while(startDate.before(endDate)){
            listOfStocks.add(new StockQuote(symbol, 7.99, startDate));
            calendar.setTime(startDate);
            calendar.add(Calendar.DAY_OF_YEAR, 1); //adds a day to calender
            startDate = calendar.getTime(); //changes date
        }

        return listOfStocks;
    }

    /* The Following method also return a list of stocks by hard coding most of the data in a while loop based on the dates.
       Also include is an interval to determine the frequency of stock data retreival and storage*/
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, IntervalEnum interval) {

        int intervalTime = 1; //This variable determines the incrementation for the calender in the while loop (changes based on enum passed in)

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
        /* adds dummy data for the dates, hard codes the price*/
        while(startDate.before(endDate)){
            listOfStocks.add(new StockQuote(symbol, 7.99, startDate));
            calendar.setTime(startDate);
            //System.out.println("\nInStockService(intervalTime)\n" + intervalTime);
            calendar.add(Calendar.DAY_OF_YEAR, intervalTime); //add days to calender

            startDate = calendar.getTime(); //change date
        }

        return listOfStocks;
    }
}