package dev.chha.backend.dto;

public class IncidentResponseDto {
    private Long incidentId;

    private String title;

    private String description;

    private String reportdate;

    private boolean solved;

    private String assignedUser;

    private String categoryName;

    private String severityName;

    private int severity;

    public IncidentResponseDto() {
    }

    public IncidentResponseDto(String title, String description, String reportdate, boolean solved, String assignedUser, String categoryName, String severityName, int severity) {
        this.title = title;
        this.description = description;
        this.reportdate = reportdate;
        this.solved = solved;
        this.assignedUser = assignedUser;
        this.categoryName = categoryName;
        this.severityName = severityName;
        this.severity = severity;
    }

    public Long getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(Long incidentId) {
        this.incidentId = incidentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReportdate() {
        return reportdate;
    }

    public void setReportdate(String reportdate) {
        this.reportdate = reportdate;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSeverityName() {
        return severityName;
    }

    public void setSeverityName(String severityName) {
        this.severityName = severityName;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "IncidentResponseDto{" +
                "incidentId=" + incidentId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", reportdate='" + reportdate + '\'' +
                ", solved=" + solved +
                ", assignedUser='" + assignedUser + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", severityName='" + severityName + '\'' +
                ", severity=" + severity +
                '}';
    }
}
