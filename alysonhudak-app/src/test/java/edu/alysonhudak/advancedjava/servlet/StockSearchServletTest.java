package edu.alysonhudak.advancedjava.servlet;

import edu.alysonhudak.advancedjava.model.StockQuote;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This class is used to test the {@code StockSearch} servlet class.
 *
 * @author Alyson Hudak
 */
public class StockSearchTest {

    private static HttpServletRequest request;
    private static HttpServletResponse response;
    private static HttpSession session;
    private static ServletContext context;
    private static RequestDispatcher dispatcher;

    @Before
    public void setUp() throws Exception {

        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        context = mock(ServletContext.class);
        dispatcher = mock(RequestDispatcher.class);

        /*
        using a "faux" session to test if the {@code stockQuoteList} attribute gets set
        (as a result of a call to the Yahoo Stock Service)
        */
        session = new FakeHttpSession();

        when(request.getParameter("symbol")).thenReturn("AAPL");
        when(request.getParameter("from")).thenReturn("2018-10-01");
        when(request.getParameter("until")).thenReturn("2018-11-05");
        when(request.getParameter("interval")).thenReturn("daily");

        when(request.getSession()).thenReturn(session);

        when(context.getRequestDispatcher("/stockQuoteResults.jsp")).thenReturn(dispatcher);
    }

    @Test
    public void testDoPostPositive() throws Exception {

        StockSearch stockSearch = new StockSearch() {
            public ServletContext getServletContext() {
                return context;
            }
        };

        stockSearch.doPost(request, response);

        List<StockQuote> stockQuoteList = (ArrayList<StockQuote>) session.getAttribute("stockQuoteList");

        assertTrue("stockQuoteList has 30 items", stockQuoteList.size() == 30);
    }

    @Test
    public void testDoPostNegative() throws Exception {

        StockSearch stockSearch = new StockSearch() {
            public ServletContext getServletContext() {
                return context;
            }
        };

        stockSearch.doPost(request, response);

        List<StockQuote> stockQuoteList = (ArrayList<StockQuote>) session.getAttribute("stockQuoteList");

        assertFalse("stockQuoteList has no items", stockQuoteList.size() == 0);
    }
}