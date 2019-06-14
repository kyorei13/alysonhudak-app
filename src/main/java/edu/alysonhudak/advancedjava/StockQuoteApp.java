package edu.alysonhudak.advancedjava;

import edu.alysonhudak.advancedjava.model.StockQuote;
import edu.alysonhudak.advancedjava.stockservice.StockService;
import edu.alysonhudak.advancedjava.stockservice.StockServiceFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Client Code, uses the other classes we have written
 */
public class StockQuoteApp {

    /**
     * One argument stock symbol
     *
     * @param args
     */
    public static void main(String[] args) throws ParseException {
        System.out.println(args[0]);

        int listNumber = getNumberInList();
        System.out.println(listNumber);

    }

    public static int getNumberInList() {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the First Date dd/MM/yyyy\n");
        String dateInString = keyboard.nextLine();

        System.out.println("Enter the End Date dd/MM/yyyy\n");
        String dateInString2 = keyboard.nextLine();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


        /* The following try catch block runs the first method in StockService*/
        try {

            Date date = formatter.parse(dateInString);
            StockService stockservice = StockServiceFactory.getInstance();
            System.out.println(stockservice.getQuote("APPL", Calendar.getInstance(), Calendar.getInstance()));


        } catch (ParseException e) {
            System.out.println("Error in dates");
        }


        /* The following try-catch block runs the second method in StockService*/
        try {

            Date date = formatter.parse(dateInString);
            Date date2 = formatter.parse(dateInString2);

            Calendar calendar = Calendar.getInstance(); //get instance of calender
            calendar.setTime(date); //set calendar time to start date from params

            Calendar calendar2 = Calendar.getInstance(); //get instance of calender
            calendar2.setTime(date2); //set calendar time to end date from params

            StockService stockservice = StockServiceFactory.getInstance();

            List<StockQuote> listOfStocks = new ArrayList();

            listOfStocks = stockservice.getQuote("APPL", calendar, calendar2);

            for (int i = 0; i < listOfStocks.size() / 40; i++) {
                System.out.println(listOfStocks.get(i).getStockPrice());

            }

            return listOfStocks.size() / 40;


        } catch (ParseException e) {
            System.out.println("Error in dates");
        }

        return 0;
    }
}
