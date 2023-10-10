package dev.chha.backend.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class IncidentCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(name = "category")
    private String categoryName;

    @Column(name = "assignedIncidents")
    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private Set<Incident> incidents;

    public IncidentCategory() {
    }

    public IncidentCategory(int categoryId, String categoryName, Set<Incident> incidents) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.incidents = incidents;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
