package com.danilorocha.entities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Project {
    private final Long id;
    private final String name;
    private final String description;
    private final Instant createDate;
    private final Instant updateDate;
    
    private Project(Long id, String name, String description, Instant createDate,
            Instant updateDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    
    private Project(String name, String description) {
        this.id = null;
        this.name = name;
        this.description = description;
        this.createDate = Instant.now();
        this.updateDate = Instant.now();
    }
    
    public static Project newProject(Long id, String name, String description,
            Instant createDate, Instant updateDate) {
        return new Project(id, name, description, createDate, updateDate);
    }
    
    public static Project newProject(String name, String description) {
        return new Project(name, description);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public Instant getCreateDate() {
        return createDate;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        return "Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + dtf.format(createDate) +
                ", updateDate=" + dtf.format(updateDate) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project project)) return false;
        return getId() == project.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}



