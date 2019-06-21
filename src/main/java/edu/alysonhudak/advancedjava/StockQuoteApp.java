package edu.alysonhudak.advancedjava;

import edu.alysonhudak.advancedjava.model.StockQuote;
import edu.alysonhudak.advancedjava.stockservice.IntervalEnum;
import edu.alysonhudak.advancedjava.stockservice.StockService;
import edu.alysonhudak.advancedjava.stockservice.StockServiceFactory;

import java.text.ParseException;
import java.util.List;


/**
 * Client Code, uses the other classes we have written
 */
class StockQuoteApp {

    public static void main( String[] args ) throws ParseException
    {
        int listNumber = getNumberInList(args[0], args[1]);
        System.out.println(listNumber);

    }

    static int getNumberInList(String dateInString, String dateInString2) {


        IntervalEnum intveralTime = IntervalEnum.Years;
        StockService stockservice = StockServiceFactory.getInstance();

        List<StockQuote> listOfStocks = stockservice.getQuote("APPL", DateParser.getDateParsed(dateInString), DateParser.getDateParsed(dateInString2), intveralTime);

        for (int i = 0; i < listOfStocks.size() /30; i++)
            System.out.println("Interval" + listOfStocks.get(i).getStockPrice());

        return listOfStocks.size();
    }
}