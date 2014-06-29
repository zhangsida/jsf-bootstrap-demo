package de.bit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import de.bit.common.DateHelper;
import de.bit.model.Event;
import de.bit.repository.EventRepository;

/**
 * JSF Controller handling the presentation and maintenance of Events.
 * 
 * @author philipp.bayer@bridging-it.de
 * @author christian.laboranowitsch@bridging-it.de
 * 
 */
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

	private Event event;

	@PostConstruct
	private void init() {
		LOGGER.debug("constructed");
		selectedDate = new LocalDate();
		updateEvents();
	}

	private void updateEvents() {
		events = eventRepo.findByStartTimeGreaterThanEqualAndStartTimeLessThan(DateHelper.createMidnightOfToday(selectedDate),
				DateHelper.createMidnightOfNextDay(selectedDate));
	}

	public String newEvent() {
		event = new Event();
		event.setEndTime(selectedDate.toDateTimeAtCurrentTime().plusMinutes(30).toDate());
		event.setStartTime(selectedDate.toDateTimeAtCurrentTime().toDate());
		return "createEditView?faces-redirect=true";
	}

	@Transactional
	public String save() {
		// event.setName(name);
		// event.setStartTime(selectedDate.toDateTime(startTime).toDate());
		// event.setEndTime(selectedDate.toDateTime(endTime).toDate());
		eventRepo.save(event);
		events.add(event);
		resetData();

		return "index?faces-redirect=true";
	}

	private void resetData() {
		event = null;
		this.endTime = null;
		this.startTime = null;
		this.name = null;
	}

	public String cancel() {
		event = null;
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

	public void setSelectedDate(final LocalDate selectedDate) {
		this.selectedDate = selectedDate;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(final List<Event> events) {
		this.events = events;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(final LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(final LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void validateTimeInput(final ComponentSystemEvent event) {

		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage msg;
		UIComponent components = event.getComponent();

		// get start
		UIInput start = (UIInput) components.findComponent("start");
		LocalTime startValue = (LocalTime) start.getValue();
		if (startValue == null) {
			fc.renderResponse();
			return;
		}
		LOGGER.debug(startValue.toString());

		// get end
		UIInput end = (UIInput) components.findComponent("end");
		LocalTime endValue = (LocalTime) end.getValue();
		if (endValue == null) {
			fc.renderResponse();
			return;
		}
		LOGGER.debug(endValue.toString());

		if (endValue.isBefore(startValue)) {
			msg = new FacesMessage("Die Endzeit darf nicht vor der Startzeit liegen.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(end.getClientId(), msg);
			fc.renderResponse();
		}
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(final Event event) {
		this.event = event;
	}
}
