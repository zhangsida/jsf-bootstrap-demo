/**
 * 
 */
package de.bit.common;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import de.bit.timesheet.ITimesheetTestConstants;

/**
 * Tests the DateHelper
 * 
 * @author christian.laboranowitsch@bridging-it.de
 * 
 */
public class DateHelperTest implements ITimesheetTestConstants {

    /**
     * Tesing midnight calculation of current day
     */
    @Test
    public void testMidnightOfToday() {
        Assert.assertEquals(FMT.parseDateTime(_12_03_2014_00_00).toDate(),
                DateHelper.createMidnightOfToday(LD_FMT.parseLocalDate(_12_03_2014)));
    }

    /**
     * Tesing midnight calculation of next day
     */
    @Test
    public void testMidnightOfNextDay() {
        Assert.assertEquals(FMT.parseDateTime(_13_03_2014_00_00).toDate(),
                DateHelper.createMidnightOfNextDay(LD_FMT.parseLocalDate(_12_03_2014)));
    }

    /**
     * Tests the conversion to local date
     */
    @Test
    public void testConvertToLocalDate() {
        Assert.assertEquals(LocalDate.parse("16/09/2014", Constants.DATE_FORMATTER), DateHelper.convertLocalDateFromUiString("16/09/2014"));
    }
}