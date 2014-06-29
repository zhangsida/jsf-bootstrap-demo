package de.bit.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.bit.model.Event;
/**
 * EventRepository
 * 
 * @author christian.laboranowitsch@bridging-it.de
 *
 */
public interface EventRepository extends JpaRepository<Event, Long> {

	/**
	 * Finds Dates between a given date
	 * must be midnight of the day you are looking for and midnight the next day
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	List<Event> findByStartTimeGreaterThanEqualAndStartTimeLessThan(Date start, Date end);

}
