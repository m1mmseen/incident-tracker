package dev.chha.backend.repository;

import dev.chha.backend.model.IncidentCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentCategoryRepository extends CrudRepository<IncidentCategory, Integer> {
}
