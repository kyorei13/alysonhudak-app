package edu.alysonhudak.advancedjava;

import edu.alysonhudak.advancedjava.model.StockQuote;
import edu.alysonhudak.advancedjava.stockservice.StockService;
import edu.alysonhudak.advancedjava.stockservice.StockServiceFactory;

/**
 * Client Code, uses the other classes we've written
 */
public class StockQuoteApp {

    /**
     * One argument stock symbol
     *
     * @param args
     */
    public static void main(String[] args) {

        if (args.length != 1) {
            throw new IllegalArgumentException("Please call program with one argument- the stock symbol");
        }

        String stockSymbol = args[0];

        StockService stockService = StockServiceFactory.getInstance();
        StockQuote quote = stockService.getQuote(stockSymbol);
        System.out.println(quote);

     }
}
