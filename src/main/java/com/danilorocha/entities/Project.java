package com.danilorocha.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Project {
    private final Long id;
    private final String name;
    private final String description;
    private final LocalDateTime createDate;
    private final LocalDateTime updateDate;

    private Project(Long id, String name, String description, LocalDateTime createDate,
                    LocalDateTime updateDate) {
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
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    public static Project newProject(Long id, String name, String description,
                                     LocalDateTime createDate, LocalDateTime updateDate) {
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


    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return name;
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



