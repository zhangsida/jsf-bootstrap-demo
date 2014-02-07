package at.bit.converter;

import org.joda.time.LocalTime;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import at.bit.spring.scope.Constants;

@Service
public class TimeToStringConverter implements Converter<LocalTime, String> {

	@Override
	public String convert(final LocalTime source) {
		return source.toString(Constants.TIME_FORMATTER);
	}

}
