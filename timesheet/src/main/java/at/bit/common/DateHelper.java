/**
 * 
 */
package at.bit.common;

import java.util.Date;

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
public class DateHelper implements ITimesheetConstants {
	
	static final Integer[] DAY_HOURS =  {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 ,13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
	/**
	 * Creates midnight of the current day
	 * @param date
	 * @return
	 */
	public static Date createMidnightOfToday(LocalDate date) {
		return date.toDateTimeAtStartOfDay().toDate();
	}

	/**
	 * Creates midnight of the next day
	 * @param date
	 * @return
	 */
	public static Date createMidnightOfNextDay(LocalDate date) {
		return date.toDateTimeAtStartOfDay().plusDays(1).toDate();
	}
	
	/**
	 * Converts a date string from ui to datetime
	 * @param dateStr
	 * @return
	 */
	public static DateTime convertFromUiString(String dateStr) {
		return DateTimeFormat.forPattern(UI_DATE_TIME_FORMAT_STR).parseDateTime(dateStr);
	}

	/**
	 * Calculates the hours of the day
	 * @param today
	 * @return array of the hours
	 */
	public static Integer[] getNumberOfHours(DateTime today) {
		DateTime start = today.withTimeAtStartOfDay();
		int hoursOfDay = Hours.hoursBetween(start, start.plusDays(1)).getHours();
		Integer[] hoursArray = new Integer[hoursOfDay];
		for(int indx=0; indx < hoursOfDay; indx++) {
			hoursArray[indx] = start.hourOfDay().get();
			start = start.plusHours(1);
		}
		return hoursArray;
	}

	public static Integer[] getNumberOfHours() {
		return DAY_HOURS;
	}

	public static LocalDate convertLocalDateFromUiString(String string) {
		return LocalDate.parse(string , UI_DATE_FORMAT_STR);
	}
}
