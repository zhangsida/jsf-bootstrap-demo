package at.bit.spring.scope;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class Constants {

	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("dd/MM/yyyy");
	public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormat.forPattern("HH:mm");

	private static final String NAV_EVENTS_OVERVIEW = "eventsOverviewView.xhtml";
	private static final String NAV_DAYVIEW = "dayView.xhtml";

	private static final Integer[] HOURS = { 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 0, 1, 2, 3, 4 };

	public Integer[] getHours() {
		return HOURS;
	}

	public String getNavEventsOverview() {
		return NAV_EVENTS_OVERVIEW;
	}

	public String getNavDayview() {
		return NAV_DAYVIEW;
	}

}
