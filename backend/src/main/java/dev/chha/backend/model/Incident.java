package dev.chha.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;


@Entity
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incidentId;

    @Column
    private String Titel;

    @Column(length = 500)
    private String Description;

    @Column(name = "reportDate")
    private String reportdate;

    @Column(nullable = false)
    private boolean isSolved;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "incident")
    private List<IncidentUpdate> updates;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private IncidentCategory category;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "severityId")
    private IncidentSeverity severity;

    public Incident() {
    }

    public Incident(Long incidentId, String titel, String description, String reportdate, boolean isSolved, User user) {
        this.incidentId = incidentId;
        Titel = titel;
        Description = description;
        this.reportdate = reportdate;
        this.isSolved = isSolved;
        this.user = user;
    }

    public Long getId() {
        return incidentId;
    }

    public void setId(Long id) {
        this.incidentId = id;
    }

    public String getTitel() {
        return Titel;
    }

    public void setTitel(String titel) {
        Titel = titel;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Long getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(Long incidentId) {
        this.incidentId = incidentId;
    }

    public String getReportdate() {
        return reportdate;
    }

    public void setReportdate(String reportdate) {
        this.reportdate = reportdate;
    }

    public List<IncidentUpdate> getUpdates() {
        return updates;
    }

    public void setUpdates(List<IncidentUpdate> updates) {
        this.updates = updates;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public IncidentCategory getCategory() {
        return category;
    }

    public void setCategory(IncidentCategory category) {
        this.category = category;
    }

    public IncidentSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(IncidentSeverity severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "incidentId=" + incidentId +
                ", Titel='" + Titel + '\'' +
                ", Description='" + Description + '\'' +
                ", reportdate='" + reportdate + '\'' +
                ", isSolved=" + isSolved +
                ", user=" + user +
                ", updates=" + updates +
                ", category=" + category +
                ", severity=" + severity +
                '}';
    }
}
