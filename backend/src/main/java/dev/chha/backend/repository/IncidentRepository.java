package dev.chha.backend.repository;

import dev.chha.incidenttracker.dtos.IncidentResponseDTO;
import dev.chha.incidenttracker.entities.Incident;
import org.springframework.data.repository.CrudRepository;

public interface IncidentRepository extends CrudRepository<Incident, Long> {


}
