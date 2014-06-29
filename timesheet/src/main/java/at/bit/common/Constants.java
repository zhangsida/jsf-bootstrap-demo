package at.bit.common;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Constants {

	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("dd/MM/yyyy");
	public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormat.forPattern("HH:mm");
	public static final String UI_DATE_TIME_FORMAT_STR = "dd/MM/yyyy";
	public static final String UI_DATE_FORMAT_STR = "dd/MM/yyyy";
}
