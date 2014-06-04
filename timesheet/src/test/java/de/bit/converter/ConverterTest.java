/**
 * 
 */
package de.bit.converter;

import org.junit.Assert;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import de.bit.timesheet.ITimesheetTestConstants;
import at.bit.converter.StringToDateTimeConverter2;
import at.bit.spring.scope.Constants;

/**
 * @author claboran
 *
 */
public class ConverterTest implements ITimesheetTestConstants {
	

	@Test
	public void testString2DateTimeNormalDay() {
		StringToDateTimeConverter2 converter = new StringToDateTimeConverter2();
		Assert.assertEquals(parseDateTime(_12_02_2014), converter.convert(_12_02_2014));
	}

	private Object parseDateTime(String dateString) {
		return Constants.DATE_FORMATTER.parseDateTime(dateString);
	}
	

}
