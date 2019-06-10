package assignment2;

import java.util.Date;
import java.util.Random;

/** This interface describes an API for getting stock data.
 * @author : Alyson Hudak
 * /

public interface StockService {


    /**
     * Return the price of a share of stock  for the given symbol
     * 
     * @param symbol represents the stock symbol name
     * @return a <CODE>StockQuote</CODE> instance
     */
    StockQuote getQuote(String symbol);

}
    
class Tech implements StockService
{
    /**
     * Returns StockQuote instance based on the tech industry stock (hard coded random implementation)
     */
    public StockQuote getQuote(String symbol) 
    {
        StockQuote sq = new StockQuote(symbol);
        
        Random rand = new Random();
        double randomPrice = rand.nextInt(700) + 53; //random price that is higher than retial
        sq.setStockPrice(randomPrice);
        return sq;
    }
}


class Retail implements StockService
{
    /**
     * Returns StockQuote instance based on the retail industry stock (hard coded random implementation)
     */
    public StockQuote getQuote(String symbol) 
    {
        StockQuote sq = new StockQuote(symbol);
        
        Random rand = new Random();

        double randomPrice = rand.nextInt(17) + 1; //random price that is lower than tech
        sq.setStockPrice(randomPrice);
        
        sq.setStockPrice(5.00);
        return sq;
    }
}