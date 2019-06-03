package assignment2;

/**
 * Returns a concrete implementations of the interface
 * 
 * @author Alyson Hudak
 */

public class StockServiceFactory 
{
    
    /*Based on the string entered by user, returns the appropriate StockQuote */
    public static StockService getStock(String company)
    {
        if ( company.equals("Tech") )
        {
            return new Tech();
        }
        else if ( company.equals("Retail") )
        {
            return new Retail();
        }
        else
            return null;
    }
}
