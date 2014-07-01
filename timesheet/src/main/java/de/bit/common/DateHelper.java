/**
 * 
 */
package de.bit.common;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

/**
 * Helper class to calculate midnight dates from Joda Datetime
 * 
 * @author christian.laboranowitsch@bridging-it.de
 * 
 */
public final class DateHelper {

    /**
     * Default constructor not needed for Utility class
     */
    private DateHelper() { } //NOPMD
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
