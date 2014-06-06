package at.bit.converter;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.core.convert.converter.Converter;

import at.bit.common.Constants;

public class StringToDateTimeConverter2 implements Converter<String, DateTime> {

	@Override
	public DateTime convert(final String source) {
		return DateTime.parse(source, Constants.DATE_FORMATTER);
	}

}
