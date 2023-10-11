package dev.chha.backend.repository;

import dev.chha.backend.model.IncidentSeverity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IncidentSeverityRepository extends CrudRepository<IncidentSeverity, Integer> {

}
