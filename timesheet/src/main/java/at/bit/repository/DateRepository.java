package at.bit.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import at.bit.model.Date;

public interface DateRepository extends GraphRepository<Date> {

}
