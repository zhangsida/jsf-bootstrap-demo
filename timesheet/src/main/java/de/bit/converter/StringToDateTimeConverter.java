package de.bit.converter;

import org.joda.time.LocalDate;
import org.springframework.core.convert.converter.Converter;

import de.bit.common.Constants;

/**
 * Converted to be used by the spring conversion service. Needs to be configured
 * in the applicationContext.xml. Used to convert values from the object to
 * readable strings which can be shown on the pages and vice versa.
 * 
 * @author pbayer
 * 
 */
public class StringToDateTimeConverter implements Converter<String, LocalDate> {

	@Override
	public LocalDate convert(final String source) {
		return LocalDate.parse(source, Constants.DATE_FORMATTER);
	}

}
