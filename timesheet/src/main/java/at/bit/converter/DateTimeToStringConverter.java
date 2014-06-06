package at.bit.converter;

import org.joda.time.LocalDate;
import org.springframework.core.convert.converter.Converter;

import at.bit.common.Constants;

public class DateTimeToStringConverter implements Converter<LocalDate, String> {

	@Override
	public String convert(final LocalDate source) {
		return source.toString(Constants.DATE_FORMATTER);
	}

}
