package com.danilorocha.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Project {

    private final Long id;
    private final String name;
    private final String description;
    private final LocalDateTime createDate;
    private final LocalDateTime updateDate;

    private Project(Long id, String name, String description, LocalDateTime 
            createDate, LocalDateTime updateDate) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public static Project newProject(Long id, String name, String description,
            LocalDateTime createDate, LocalDateTime updateDate) {

        return new Project(id, name, description, createDate, updateDate);
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
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Project project))
            return false;
        return getId() == project.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
