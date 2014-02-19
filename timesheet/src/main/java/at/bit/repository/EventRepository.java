package at.bit.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import at.bit.model.Event;

public interface EventRepository extends GraphRepository<Event> {

	@Query(value = "START event=node:__types__(className='at.bit.model.Event') MATCH  event<-[:eventsToDay]-day RETURN event ORDER BY day.date DESC", countQuery = "START event=node:__types__(className='at.bit.model.Event') RETURN count(event)")
	public Page<Event> fetchOrderedPage(Pageable page);

}
