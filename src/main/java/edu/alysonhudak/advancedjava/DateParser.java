package edu.alysonhudak.advancedjava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This function parses a date string into the appropriate format.
 * @author Alyson Hudak
 */
class DateParser {

    public static Calendar getDateParsed(String dateInString) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();

        try {
            Date date = formatter.parse(dateInString);
            //Date date2 = formatter.parse(dateInString2);

            //get instance of calender
            calendar.setTime(date); //set calender time to start date from params

            Calendar calendar2 = Calendar.getInstance(); //get instance of calender
            //calendar2.setTime(date2); //set calender time to end date from params}
            return calendar;
        } catch (ParseException e) {
            System.out.println("Error in dates.");
        }
        return calendar;

    }
}