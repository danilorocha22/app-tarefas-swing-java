package com.danilorocha.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task {

    private final Long id;
    private final Long idProject;
    private final String name;
    private final String description;
    private final String note;
    private final boolean isCompleted;
    private final LocalDate deadline;
    private final LocalDateTime createDate;
    private final LocalDateTime updateDate;

    private Task(Long id, Long idProject, String name, String description,
            String note, boolean isCompleted, LocalDate deadline,
            LocalDateTime createDate, LocalDateTime updateDate) {

        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.note = note;
        this.isCompleted = isCompleted;
        this.deadline = deadline;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public static Task newTask(Long id, Long idProject, String name,
            String description, String note, boolean isCompleted,
            LocalDate deadline, LocalDateTime createDate, LocalDateTime updateDate) {

        return new Task(id, idProject, name, description, note, isCompleted,
                deadline, createDate, updateDate);
    }

    public Long getId() {
        return id;
    }

    public Long getIdProject() {
        return idProject;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getNote() {
        return note;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    @Override
    public String toString() {
        return name + description + deadline + isCompleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Task task)) {
            return false;
        }
        return getId() == task.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
