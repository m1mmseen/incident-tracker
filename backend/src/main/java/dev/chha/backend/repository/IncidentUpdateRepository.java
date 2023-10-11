package dev.chha.backend.repository;

import dev.chha.backend.model.IncidentUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentUpdateRepository extends JpaRepository<IncidentUpdate, Long> {

    List<IncidentUpdate> findAllByIncident_IdOrderByCreatedAtDesc(Long incidentId);

}
