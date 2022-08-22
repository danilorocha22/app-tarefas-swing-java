package com.danilorocha.controllers;

import com.danilorocha.entities.Project;
import com.danilorocha.repositories.ProjectRepository;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public class ProjectController {

    ProjectRepository projectRepository;

    public ProjectController() {
        projectRepository = new ProjectRepository();
    }

    public void save(Project project) {
        projectRepository.save(project);
    }

    public void update(Project project) {
        projectRepository.update(project);
    }

    public void removeById(Long projectId) {
        projectRepository.remove(projectId);
    }

    public Optional<List<Project>> getAll() {
        return projectRepository.getAll();
    }

    public Project getById(Long projectId) {
        return projectRepository.getById(projectId);
    }

}
