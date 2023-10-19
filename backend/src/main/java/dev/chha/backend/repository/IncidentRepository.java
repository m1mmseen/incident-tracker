package dev.chha.backend.repository;

import dev.chha.backend.dto.IncidentResponseDto;
import dev.chha.backend.model.Incident;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends CrudRepository<Incident, Long> {


}
