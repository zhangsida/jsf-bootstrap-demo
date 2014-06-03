package at.bit.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import at.bit.common.DateHelper;
import at.bit.model.Event;
import at.bit.repository.EventRepository;

@Controller
@Scope(value = "session")
public class DayController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DayController.class);


	@Autowired
	private EventRepository eventRepo;

	private LocalDate selectedDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private String name;
	private List<Event> events = new ArrayList<Event>();

	@PostConstruct
	private void init() {
		LOGGER.debug("constructed");
		selectedDate = new LocalDate();
		updateEvents();
	}

	private void updateEvents() {
		events = eventRepo.findByStartTimeGreaterThanEqualAndStartTimeLessThan(
				DateHelper.createMidnightOfToday(selectedDate), DateHelper.createMidnightOfNextDay(selectedDate));
	}

	public String newEvent() {
//		event = new Event();
//		LOGGER.debug("New Event");
//		event.setEndTime(event.getEndTime().plusHours(1));
		return "createEditView?faces-redirect=true";
	}

	public String save() {
		Event event = new Event();
		event.setStartTime(selectedDate.toDateTime(startTime).toDate());
		event.setEndTime(selectedDate.toDateTime(endTime).toDate());
		event.setName(name);
		eventRepo.save(event);
		events.add(event);
		resetData();
		return "index?faces-redirect=true";
	}

	private void resetData() {
		this.endTime = null;
		this.startTime = null;
		this.name = null;
	}

	public String cancel() {
		return "index?faces-redirect=true";
	}
	
	public Integer[] getHours() {
		return DateHelper.getNumberOfHours();
	}

	public void next() {
		LOGGER.debug("next called");
		selectedDate = selectedDate.plusDays(1);
		updateEvents();
	}

	public void gotoDate(final AjaxBehaviorEvent event) {
		LOGGER.debug("gotoDate called");
		updateEvents();
	}

	public void previous() {
		LOGGER.debug("previous called");
		selectedDate = selectedDate.minusDays(1);
		updateEvents();
	}


	public LocalDate getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(LocalDate selectedDate) {
		this.selectedDate = selectedDate;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
