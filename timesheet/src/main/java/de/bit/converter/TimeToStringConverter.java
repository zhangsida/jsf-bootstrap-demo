package de.bit.converter;

import org.joda.time.LocalTime;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;

import de.bit.common.Constants;

/**
 * Converted to be used by the spring conversion service. Needs to be configured
 * in the applicationContext.xml. Used to convert values from the object to
 * readable strings which can be shown on the pages and vice versa.
 * 
 * @author pbayer
 * 
 */
@Controller
public class TimeToStringConverter implements Converter<LocalTime, String> {

    @Override
    public String convert(final LocalTime source) {
        return source.toString(Constants.TIME_FORMATTER);
    }

}
