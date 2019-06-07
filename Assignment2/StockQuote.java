package assignment2;

import java.util.Date;

/**
 * This class contains information about a stock.
 * This class is immutable. It holds stock information for a given point in time.
 * 
 * @author Alyson Hudak
 */

public class StockQuote 
{
    //Stock properties
    private String stockSymbol;
    private Double stockPrice;

    /**
     *  Create a new  StockData instance
     * @param stockSymbol the stock symbol e.g. MICR (for MICROSOFT)
     */
    
public StockQuote(String stockSymbol) 
	{
	this.stockSymbol = stockSymbol;
	}

    /**
     *
     * set the price of a stock in the concrete implementation 
     */

public void setStockPrice(Double price) 
	{
	this.stockPrice = price;
    }
    
    /**
     *
     * @return the stock price.
     * e.g. MICR for MICROSOFT
     */
    public Double getStockPrice() 
    {
    	return stockPrice;
    }
}
