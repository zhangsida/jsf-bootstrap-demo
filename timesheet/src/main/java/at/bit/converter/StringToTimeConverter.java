package at.bit.converter;

import org.joda.time.LocalTime;
import org.springframework.core.convert.converter.Converter;

import at.bit.spring.scope.Constants;

public class StringToTimeConverter implements Converter<String, LocalTime> {

	@Override
	public LocalTime convert(final String source) {
		return LocalTime.parse(source, Constants.TIME_FORMATTER);
	}

}
