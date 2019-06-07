package assignment2;

/**
 * A BasicStockService Class that has a method that returns an instance of StockQuote
 *
 * @author Alyson Hudak
 */

public class BasicStockService 
{
    /**
     * Code to run method that returns an instance of Stock Quote
     */
    public static void main(String[] args)
    {   
        StockQuote ms;
        ms = getStockQuote("Tech", "MICR");
        System.out.println(ms.getStockPrice());
    }
    
    /**
     * Returns instance of StockQuote
     */
    public static StockQuote getStockQuote(String industry, String name)
    {
        StockService ss = StockServiceFactory.getStock(industry);
        return ss.getQuote(name);   
    }
}