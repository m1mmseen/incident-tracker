package dev.chha.backend.dto;

public class IncidentUpdatesRequestDto {
    private Long incident_id;

    public Long getIncidentRequestId() {
        return incident_id;
    }

    public void setIncidentRequestId(Long incidentRequestId) {
        this.incident_id = incidentRequestId;
    }
}
