package edu.alysonhudak.advancedjava.stockservice;

import edu.alysonhudak.advancedjava.model.StockQuery;
import edu.alysonhudak.advancedjava.model.StockQuote;
import edu.alysonhudak.advancedjava.stockservice.StockService;
import edu.alysonhudak.advancedjava.stockservice.StockServiceException;
import edu.alysonhudak.advancedjava.stockservice.StockServiceFactory;
import edu.alysonhudak.advancedjava.util.Interval;

import java.text.ParseException;
import java.util.List;

/**
 * A simple application that shows StockService in action.
 *
 * @author Alyson Hudak
 */
public class BasicStockQuoteApplication {

    private final StockService stockService;

    /**
     * An enumeration that indicates how the program terminates (ends)
     */
    private enum ProgramTerminationStatusEnum {

        NORMAL(0),
        ABNORMAL(-1);

        // when the program exits, this value will be reported to underlying OS
        private final int statusCode;

        /**
         * Create a new ProgramTerminationStatusEnum
         *
         * @param statusCodeValue the value to return the OS. Success or normal termination is
         * indicated by a value of 0. Any non 0 numbers indicate an abnormal termination.
         */
        private ProgramTerminationStatusEnum(int statusCodeValue) {
            this.statusCode = statusCodeValue;
        }

        /**
         * @return The value sent to the OS when the program ends.
         */
        private int getStatusCode() {
            return statusCode;
        }
    }

    /**
     * Create a new application.
     *
     * @param stockService the StockService this application should use for stock queries.
     *
     */
    public BasicStockQuoteApplication(StockService stockService) {
        this.stockService = stockService;
    }

    /**
     * Given a <CODE>stockQuery</CODE> get back a the info about the stock to display to th user.
     *
     * @param stockQuery the stock to get data for.
     * @return a string with the stock data in it.
     * @throws StockServiceException If data about the stock can not be retrieved, a fatal error.
     */
    public String displayStockQuotes(StockQuery stockQuery) throws StockServiceException {
        StringBuilder stringBuilder = new StringBuilder();

        List<StockQuote> stockQuotes =
                stockService.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil(), IntervalEnum.HOUR);

        stringBuilder.append("Stock quotes for: " + stockQuery.getSymbol() + "\n");
        for (StockQuote stockQuote : stockQuotes) {
            stringBuilder.append(stockQuote.toString());
        }

        return stringBuilder.toString();
    }

    /**
     * Terminate the application.
     *
     * @param statusCode        an enum value that indicates if the program terminated alright or not.
     * @param diagnosticMessage A message to display to the user when the program finishes.
     *                          Should be an error message in the case of abnormal termination.
     */
    private static void exit(ProgramTerminationStatusEnum statusCode, String diagnosticMessage) {
        if (statusCode == ProgramTerminationStatusEnum.NORMAL) {
            System.out.println(diagnosticMessage);
        } else if (statusCode == ProgramTerminationStatusEnum.ABNORMAL) {
            System.err.println(diagnosticMessage);
        } else {
            throw new IllegalStateException("Unknown ProgramTerminationStatusEnum.");
        }
        System.exit(statusCode.getStatusCode());
    }

    /**
     * Run the StockTicker application.
     *
     * When invoking the program supply one or more stock symbols.
     *
     * @param args one or more stock symbols
     */
    public static void main(String[] args) {

        // be optimistic init to positive values
        ProgramTerminationStatusEnum exitStatus = ProgramTerminationStatusEnum.NORMAL;
        String programTerminationMessage = "Normal program termination.";

        if (args.length != 3) {
            exit(ProgramTerminationStatusEnum.ABNORMAL,
                    "Please supply 4 arguments: a stock symbol, a start date (MM/DD/YYYY), an end date (MM/DD/YYYY), and an interval of time");
        }
        try {
            IntervalEnum interval = IntervalEnum.valueOf(args[3]);
            StockQuery stockQuery = new StockQuery(args[0], args[1], args[2], interval);
            StockService stockService = ServiceFactory.getStockServiceInstance();
            BasicStockQuoteApplication basicStockQuoteApplication =
                    new BasicStockQuoteApplication(stockService);
            basicStockQuoteApplication.displayStockQuotes(stockQuery);

        } catch (ParseException e) {
            exitStatus = ProgramTerminationStatusEnum.ABNORMAL;
            programTerminationMessage = "Invalid date data: " + e.getMessage();
        } catch (StockServiceException e) {
            exitStatus = ProgramTerminationStatusEnum.ABNORMAL;
            programTerminationMessage = "StockService failed: " + e.getMessage();
        } catch (Exception e){
            exitStatus = ProgramTerminationStatusEnum.ABNORMAL;
            programTerminationMessage = "Exception encountered: " + e.getMessage();
        }

        exit(exitStatus, programTerminationMessage);
        System.out.println("Error, could not parse a date");
    }
}