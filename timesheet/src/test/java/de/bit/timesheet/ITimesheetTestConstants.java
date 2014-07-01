/**
 * 
 */
package de.bit.timesheet;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Tests constants
 * 
 * @author christian.laboranowitsch@bridging-it.de
 * 
 */
public interface ITimesheetTestConstants {

    String            EVENT_NAME        = "safdasf";

    String            _12_02_2014       = "12/02/2014";
    String            _12_03_2014_14_00 = "12.03.2014 14:00";
    String            _12_03_2014_13_00 = "12.03.2014 13:00";
    String            _12_03_2014_00_00 = "12.03.2014 00:00";
    String            _13_03_2014_00_00 = "13.03.2014 00:00";
    String            _13_03_2014_14_00 = "13.03.2014 14:00";
    String            _13_03_2014_13_00 = "13.03.2014 13:00";
    String            _11_03_2014_14_00 = "11.03.2014 14:00";
    String            _11_03_2014_13_00 = "11.03.2014 13:00";
    String            _13_03_2014_01_00 = "13.03.2014 01:00";
    String            _12_03_2014_01_00 = "12.03.2014 01:00";
    String            _12_03_2014       = "12.03.2014";

    DateTimeFormatter FMT               = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm");
    DateTimeFormatter LD_FMT            = DateTimeFormat.forPattern("dd.MM.yyyy");

}
