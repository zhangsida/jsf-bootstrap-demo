package de.bit.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.validation.ValidationException;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import de.bit.common.DateHelper;
import de.bit.model.Event;
import de.bit.repository.EventRepository;
import de.bit.timesheet.ITimesheetTestConstants;

/**
 * Tests event repository
 * 
 * @author philipp.bayer@bridging-it.de
 * @author christian.laboranowitsch@bridging-it.de
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class EventTest implements ITimesheetTestConstants {

	@Autowired
	private EventRepository eventRepository;

	/**
	 * Testing of bean validation
	 */
	@Test(expected = ValidationException.class)
	@Transactional
	public void testBeanValidationEmptyEvent() {
		Event e = new Event();
		eventRepository.save(e);
	}

	/**
	 * Test saving and reading back of one Event
	 */
	@Test
	@Transactional
	public void testEventSave() {

		Event ev = eventRepository.save(createEvent(FMT.parseDateTime(_12_03_2014_13_00), FMT.parseDateTime(_12_03_2014_14_00)));
		ev = eventRepository.findOne(ev.getId());

		assertEquals(EVENT_NAME, ev.getName());
		assertEquals(FMT.parseDateTime(_12_03_2014_13_00), ev.startDateTime());
		assertEquals(FMT.parseDateTime(_12_03_2014_14_00), ev.endDateTime());

	}

	/**
	 * Test saving and reading back with finder
	 */
	@Test
	@Transactional
	public void testEventSaveAndReadBack() {

		eventRepository.save(createEvent(FMT.parseDateTime(_11_03_2014_13_00), FMT.parseDateTime(_11_03_2014_14_00)));
		eventRepository.save(createEvent(FMT.parseDateTime(_12_03_2014_13_00), FMT.parseDateTime(_12_03_2014_14_00)));
		eventRepository.save(createEvent(FMT.parseDateTime(_13_03_2014_13_00), FMT.parseDateTime(_13_03_2014_14_00)));

		List<Event> eventList = eventRepository.findByStartTimeGreaterThanEqualAndStartTimeLessThan(
				DateHelper.createMidnightOfToday(LD_FMT.parseLocalDate(_12_03_2014)),
				DateHelper.createMidnightOfNextDay(LD_FMT.parseLocalDate(_12_03_2014)));

		assertEquals(1, eventList.size());
		assertEquals(EVENT_NAME, eventList.get(0).getName());
		assertEquals(FMT.parseDateTime(_12_03_2014_13_00), eventList.get(0).startDateTime());
		assertEquals(FMT.parseDateTime(_12_03_2014_14_00), eventList.get(0).endDateTime());

	}

	/**
	 * Test saving and reading back with finder border
	 */
	@Test
	@Transactional
	public void testEventSaveAndReadBackBorder() {

		eventRepository.save(createEvent(FMT.parseDateTime(_11_03_2014_13_00), FMT.parseDateTime(_11_03_2014_14_00)));
		eventRepository.save(createEvent(FMT.parseDateTime(_12_03_2014_00_00), FMT.parseDateTime(_12_03_2014_01_00)));
		eventRepository.save(createEvent(FMT.parseDateTime(_13_03_2014_00_00), FMT.parseDateTime(_13_03_2014_01_00)));

		List<Event> eventList = eventRepository.findByStartTimeGreaterThanEqualAndStartTimeLessThan(
				DateHelper.createMidnightOfToday(LD_FMT.parseLocalDate(_12_03_2014)),
				DateHelper.createMidnightOfNextDay(LD_FMT.parseLocalDate(_12_03_2014)));

		assertEquals(1, eventList.size());
		assertEquals(EVENT_NAME, eventList.get(0).getName());
		assertEquals(FMT.parseDateTime(_12_03_2014_00_00), eventList.get(0).startDateTime());
		assertEquals(FMT.parseDateTime(_12_03_2014_01_00), eventList.get(0).endDateTime());

	}

	private Event createEvent(final DateTime start, final DateTime end) {
		Event e = new Event();
		e.setName(EVENT_NAME);
		e.setEndTime(end.toDate());
		e.setStartTime(start.toDate());
		return e;
	}

	public EventRepository getEventRepository() {
		return eventRepository;
	}

	public void setEventRepository(final EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

}