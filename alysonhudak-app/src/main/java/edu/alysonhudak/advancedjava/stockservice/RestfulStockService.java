package edu.alysonhudak.advancedjava.stockservice;


import edu.alysonhudak.advancedjava.model.StockQuote;
import edu.alysonhudak.advancedjava.util.Interval;
import java.util.Calendar;
import java.math.BigDecimal;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 *
 *
 * @author Alyson Hudak
 */

public class RestfulStockService implements StockService {

    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException {
        StringBuffer stringBuffer = new StringBuffer();

        try {

            URL url = new URL("http://localhost:8080");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            while ((output = br.readLine()) != null) {
                stringBuffer.append(output);
            }

            conn.disconnect();
        } catch (IOException ex) {
            throw new StockServiceException(ex.getMessage());
        }

        System.out.println(stringBuffer.toString());

        return new StockQuote(new BigDecimal(100), Calendar.getInstance().getTime(), symbol);
    }

    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, Interval interval) throws StockServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}