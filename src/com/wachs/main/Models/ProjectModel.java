package com.wachs.main.Models;

import com.wachs.main.BusinessEntities.Project;
import com.wachs.main.DataAccess.services.IProjectService;
import com.wachs.main.DataAccess.services.ProjectService;

public class ProjectModel {

    private IProjectService newDAO;
    private Project searchedProject;

    public ProjectModel(String nameProject) {

        createModel(nameProject);
    }

    public ProjectModel() {

    }

    private Project createModel(String projectName) {

        newDAO = new ProjectService();
        searchedProject = newDAO.fetchOneProject(projectName);

        return searchedProject;
    }

    public double getPrice() {

        return searchedProject.getPrice();
    }

    public double getDeposite() {

        return searchedProject.getDeposite();
    }

    public String getProjectName() {

        return searchedProject.getName();
    }

    public int getProjectPrimaryKey() {

        return searchedProject.getPrimaryKey();
    }

    public void setNewProject(String newNameProject, double price, double deposite) {

        newDAO.insertProject(newNameProject, price, deposite);
    }
}