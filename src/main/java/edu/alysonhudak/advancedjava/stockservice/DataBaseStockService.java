package edu.alysonhudak.advancedjava.stockservice;

import edu.alysonhudak.advancedjava.model.StockQuote;
import edu.alysonhudak.advancedjava.util.DatabaseUtils;
import edu.alysonhudak.advancedjava.model.StockData;
import edu.alysonhudak.advancedjava.util.DatabaseConnectionException;
import edu.alysonhudak.advancedjava.util.Interval;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * An implementation of the StockService interface that gets
 * stock data from a database.
 *
 * @author Alyson Hudak
 */
public class DatabaseStockService implements StockService {

    /**
     * Returns the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for, such as: APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     */
    @Override
    public List<StockQuote> getQuote(String symbol) throws StockServiceException {

        List<StockQuote> stockQuotes = null;
        try {
            Connection connection = DatabaseUtils.getConnection();
            Statement statement = connection.createStatement();
            String queryString = "select * from quotes where symbol = '" + symbol + "'";

            ResultSet resultSet = statement.executeQuery(queryString);
            stockQuotes = new ArrayList<>(resultSet.getFetchSize());
            while (resultSet.next()) {
                String symbolValue = resultSet.getString("symbol");
                Date time = resultSet.getDate("time");
                BigDecimal price = resultSet.getBigDecimal("price");
                stockQuotes.add(new StockQuote(price, time, symbolValue));
            }

        } catch (DatabaseConnectionException | SQLException exception) {
            throw new StockServiceException(exception.getMessage(), exception);
        }
        if (stockQuotes.isEmpty()) {
            throw new StockServiceException("There is no stock data for:" + symbol);
        }
        return stockQuotes;
    }

    /**
     * Get a historical list of stock quotes for the provided symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the final stock quote
     * @return a list of StockQuote instances
     * @throws StockServiceException if using the service generates an exception.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, IntervalEnum interval) throws StockServiceException {

        List<StockQuote> stockQuotes = null;
        Connection connection = null;
        try {
            connection = DatabaseUtils.getConnection();
            Statement statement = connection.createStatement();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(StockData.dateFormat);

            String fromDateString = simpleDateFormat.format(from.getTime());
            String untilDateString = simpleDateFormat.format(until.getTime());

            String queryString = "SELECT * FROM quotes where symbol = '" + symbol + "' AND (time BETWEEN '" + fromDateString + "' AND '" + untilDateString + "') ORDER BY time";

            ResultSet resultSet = statement.executeQuery(queryString);
            stockQuotes = new ArrayList<>(resultSet.getFetchSize());
            StockQuote previousStockQuote = null;
            Calendar calendar = Calendar.getInstance();

            while (resultSet.next()) {
                String symbolValue = resultSet.getString("symbol");
                Timestamp timestamp = resultSet.getTimestamp("time");
                calendar.setTimeInMillis(timestamp.getTime());
                BigDecimal price = resultSet.getBigDecimal("price");
                java.util.Date time = calendar.getTime();
                StockQuote currentStockQuote = new StockQuote(price, time, symbolValue);

                if (previousStockQuote == null){
                    stockQuotes.add(currentStockQuote);
                } else if (isInterval(currentStockQuote.getDate(), interval, previousStockQuote.getDate())){
                    previousStockQuote = currentStockQuote;
                }
            }

        } catch (DatabaseConnectionException | SQLException exception) {
            throw new StockServiceException(exception.getMessage(), exception);

        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new StockServiceException("Unable to close the database connection.");
                }
            }
        }

        if (stockQuotes.isEmpty()) {
            throw new StockServiceException("There is no stock data for:" + symbol + " between " + from + " and " + until
                    + ".");
        }

        return stockQuotes;
    }

    /**
     * This method checks if the date/time of the currentStockQuote is later than
     * the date/time of the previousStockQuote. If so, returns true.
     *
     * @param endDate   the end date/time
     * @param interval  the amount of time that has to be between the currentStockQuote
     * and previousStockQuote for this method to return true
     * @param startDate the start date/time
     * @return true(1) or false(0)
     */
    private Boolean isInterval(java.util.Date endDate, IntervalEnum interval, java.util.Date startDate){
        Calendar startDatePlusInterval = Calendar.getInstance();
        startDatePlusInterval.setTime(startDate);
        startDatePlusInterval.add(Calendar.MINUTE, interval.getInterval());
        return endDate.after(startDatePlusInterval.getTime());
    }
}