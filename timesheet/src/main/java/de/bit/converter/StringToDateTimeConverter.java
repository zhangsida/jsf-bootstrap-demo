package de.bit.converter;

import org.joda.time.LocalDate;
import org.springframework.core.convert.converter.Converter;

import de.bit.common.Constants;

public class StringToDateTimeConverter implements Converter<String, LocalDate> {

	@Override
	public LocalDate convert(final String source) {
		return LocalDate.parse(source, Constants.DATE_FORMATTER);
	}

}
