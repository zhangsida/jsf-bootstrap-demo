/**
 * 
 */
package at.bit.common;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * General Constants
 *  
 * @author christian.laboranowitsch@bridging-it.de
 *
 */
public interface ITimesheetConstants {

	String UI_DATE_TIME_FORMAT_STR = "dd/MM/yyyy";
	DateTimeFormatter UI_DATE_FORMAT_STR = DateTimeFormat.forPattern("dd/MM/yyyy");

}
