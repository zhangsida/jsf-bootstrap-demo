package at.bit.spring.scope;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import at.bit.model.Event;

@Component
public class Constants {

	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("dd/MM/yyyy");
	public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormat.forPattern("HH:mm");

	private List<Event> testData;

	{
		testData = new ArrayList<>();
		Event e = new Event();
		e.setStartTimeStr("11:30");
		e.setEndTimeStr("15:20");
		testData.add(e);

		e = new Event();
		e.setStartTimeStr("9:00");
		e.setEndTimeStr("10:00");
		testData.add(e);
	}

	private Integer[] hours = { 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 0, 1, 2, 3, 4 };

	public Integer[] getHours() {
		return hours;
	}

	public void setHours(final Integer[] hours) {
		this.hours = hours;
	}

	public List<Event> getTestData() {
		return testData;
	}

	public void setTestData(final List<Event> testData) {
		this.testData = testData;
	}

}
