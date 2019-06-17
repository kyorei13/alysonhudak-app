package edu.alysonhudak.advancedjava;

import edu.alysonhudak.advancedjava.model.StockQuote;
import edu.alysonhudak.advancedjava.stockservice.StockService;
import edu.alysonhudak.advancedjava.stockservice.StockServiceFactory;
import edu.alysonhudak.advanced.java.stockservice.IntervalEnum;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


/**
 * Client Code, uses the other classes we have written
 */
public class StockQuoteApp {
    public static void main( String[] args ) throws ParseException
    {
        int listNumber = getNumberInList(args[0], args[1]);
        System.out.println(listNumber);

    }

    public static int getNumberInList(String dateInString, String dateInString2) throws ParseException{


        IntervalEnum intveralTime = IntervalEnum.Years;
        StockService stockservice = StockServiceFactory.getStock();

        List<StockQuote> listOfStocks = stockservice.getQuote("APPL", DateParser.getDateParsed(dateInString), DateParser.getDateParsed(dateInString2), intveralTime);

        for (int i = 0; i < listOfStocks.size() /30; i++)
            System.out.println("Interval" + listOfStocks.get(i).getStockPrice());

        return listOfStocks.size();
    }
}