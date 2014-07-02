package de.bit.converter;

import org.joda.time.LocalTime;
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
public class StringToTimeConverter implements Converter<String, LocalTime> {

    @Override
    public LocalTime convert(final String source) {
        return LocalTime.parse(source, Constants.TIME_FORMATTER);
    }

}
