package at.bit.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import at.bit.model.Event;

public interface EventRepository extends GraphRepository<Event> {

}
