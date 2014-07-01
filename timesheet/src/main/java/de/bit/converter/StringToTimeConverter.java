package de.bit.converter;

import org.joda.time.LocalTime;
import org.springframework.core.convert.converter.Converter;

import de.bit.common.Constants;

public class StringToTimeConverter implements Converter<String, LocalTime> {

    @Override
    public LocalTime convert(final String source) {
        return LocalTime.parse(source, Constants.TIME_FORMATTER);
    }

}
