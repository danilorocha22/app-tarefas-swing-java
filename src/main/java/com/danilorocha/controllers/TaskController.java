package com.danilorocha.controllers;

import com.danilorocha.entities.Task;
import com.danilorocha.repositories.TaskRepository;

import java.util.List;

public class TaskController {

    TaskRepository taskRepository;

    public TaskController() {
        taskRepository = new TaskRepository();
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void update(Task task) {
        taskRepository.update(task);
    }

    public void removeById(Long taskId) {
        taskRepository.removeById(taskId);
    }

    public List<Task> getAll(Long projectId) {
        return taskRepository.getAll(projectId);
    }

}