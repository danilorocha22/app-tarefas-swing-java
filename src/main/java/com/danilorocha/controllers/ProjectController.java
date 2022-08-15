package com.danilorocha.controllers;

import com.danilorocha.entities.Project;
import com.danilorocha.repositories.ProjectRepository;

import java.util.List;

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

    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    public Project getById(Long projectId) {
        return projectRepository.getById(projectId);
    }

}
