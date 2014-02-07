package at.bit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EventTest {

	private final String testdata[][] = { { "15:00", "16:00", "1" }, { "15:00", "16:01", "2" }, { "15:20", "16:20", "2" }, { "15:20", "18:20", "4" },
			{ "15:20", "16:21", "2" }, { "15:20", "17:21", "3" }, { "15:40", "16:20", "2" }, { "15:40", "17:20", "3" }, { "15:20", "17:40", "3" }, };

	@Test
	public void testDurationHours() throws Exception {
		Event ev = new Event();
		for (String[] test : testdata) {
			ev.setStartTimeStr(test[0]);
			ev.setEndTimeStr(test[1]);
			assertEquals(String.format("Start:%s End:%s", test[0], test[1]), Long.parseLong(test[2]), ev.durationHours());
		}
	}

}