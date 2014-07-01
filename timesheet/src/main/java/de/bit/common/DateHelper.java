/**
 * 
 */
package de.bit.common;

import java.util.Date;

import org.apache.myfaces.shared.util.ArrayUtils;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

/**
 * Helper class to calculate midnight dates from Joda Datetime
 * 
 * @author christian.laboranowitsch@bridging-it.de
 * 
 */
public class DateHelper {

    private static final Integer[] DAY_HOURS = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23 };

    /**
     * Creates midnight of the current day
     * 
     * @param date
     * @return midnight od current day
     */
    public static Date createMidnightOfToday(final LocalDate date) {
        return date.toDateTimeAtStartOfDay().toDate();
    }

    /**
     * Creates midnight of the next day
     * 
     * @param date
     * @return midnight of next day
     */
    public static Date createMidnightOfNextDay(final LocalDate date) {
        return date.toDateTimeAtStartOfDay().plusDays(1).toDate();
    }

    /**
     * Converts a date string from ui to datetime
     * 
     * @param dateStr
     * @return DateTime from string
     */
    public static DateTime convertFromUiString(final String dateStr) {
        return DateTimeFormat.forPattern(Constants.UI_DATE_TIME_FORMAT_STR).parseDateTime(dateStr);
    }

    /**
     * Calculates the hours of the day
     * 
     * @param today
     * @return array of the hours
     */
    public static Integer[] getNumberOfHours(final DateTime today) {
        DateTime start = today.withTimeAtStartOfDay();
        int hoursOfDay = Hours.hoursBetween(start, start.plusDays(1)).getHours();
        Integer[] hoursArray = new Integer[hoursOfDay];
        for (int indx = 0; indx < hoursOfDay; indx++) {
            hoursArray[indx] = start.hourOfDay().get();
            start = start.plusHours(1);
        }
        return hoursArray;
    }

    /**
     * returns number of day hours
     * 
     * @return day hours
     */
    public static Integer[] getNumberOfHours() {
        return DAY_HOURS.clone();
    }

    /**
     * converts string representation to LocalDate
     * 
     * @param string
     * @return LocalDate from string
     */
    public static LocalDate convertLocalDateFromUiString(final String string) {
        return LocalDate.parse(string, Constants.DATE_FORMATTER);
    }
}
