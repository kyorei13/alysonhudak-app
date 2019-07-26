package edu.alysonhudak.advancedjava.servlet;

import edu.alysonhudak.advancedjava.model.StockQuote;
import edu.alysonhudak.advancedjava.stockservice.StockServiceFactory;
import edu.alysonhudak.advancedjava.stockservice.StockService;
import edu.alysonhudak.advancedjava.advancedjava.util.Interval;
import edu.alysonhudak.advancedjava.stockservice.StockServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple example of how a servlet can access form submission data
 * and then act on it accordingly.
 *
 * @author Alyson Hudak
 */

public class StockSearchServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(StockSearch.class.getName());

    private static final String SYMBOL_PARAMETER_KEY = "symbol";
    private static final String FROM_PARAMETER_KEY = "from";
    private static final String UNTIL_PARAMETER_KEY = "until";
    private static final String INTERVAL_PARAMETER_KEY = "interval";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        List<StockQuote> stockQuoteList = new ArrayList<>();

        try {

            /* get the parameters */

            String symbol = request.getParameter(SYMBOL_PARAMETER_KEY);
            String fromDatePassed = request.getParameter(FROM_PARAMETER_KEY);
            String untilDatePassed = request.getParameter(UNTIL_PARAMETER_KEY);
            String intervalPassed = request.getParameter(INTERVAL_PARAMETER_KEY);

            Calendar fromDate = Calendar.getInstance();
            fromDate.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(fromDatePassed));

            Calendar untilDate = Calendar.getInstance();
            untilDate.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(untilDatePassed));

            StockQuoteInterval interval = StockQuoteInterval.fromString(intervalPassed);

            /* get the stock quotes */

            StockService stockService = ServiceFactory.getStockService();
            stockQuoteList = new ArrayList<>();
            stockQuoteList = stockService.getStockQuoteList(symbol, fromDate, untilDate, interval);

        } catch (ParseException exception) {
            LOGGER.error("Error: invalid arguments. " + exception.getMessage());
        } catch (StockServiceException exception) {
            LOGGER.error("Unable to retrieve the quotes. " + exception.getMessage());
        }

        /* put stockQuoteList in the session */

        HttpSession session = request.getSession();
        session.setAttribute("stockQuoteList", stockQuoteList);

        /* forwards the user to stockQuoteResults.jsp */

        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher =
                servletContext.getRequestDispatcher("/stockQuoteResults.jsp");
        dispatcher.forward(request, response);
    }
}