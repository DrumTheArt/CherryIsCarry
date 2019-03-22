package com.wachs.main.models;

import com.wachs.main.businessObjects.Project;
import com.wachs.main.dataAccess.DAO.ProjectDAO;
import com.wachs.main.dataAccess.DAO.ProjectDAOImpl;

public class ProjectModel {

    private ProjectDAO newDAO;
    private Project searchedProject;

    ProjectModel(String nameProject) {

        createModel(nameProject);
    }

    private Project createModel(String projectName) {

        newDAO = new ProjectDAOImpl();
        searchedProject = newDAO.findOneProject(projectName);

        return searchedProject;
    }

    public double getPrice() {

        return searchedProject.getProjectPrice();
    }

    public double getDeposite() {

        return searchedProject.getProjectDeposite();
    }

    public String getProjectName() {

        return searchedProject.getProjectName();
    }

    public int getProjectPrimaryKey() {

        return searchedProject.getPK_id();
    }

    public void setNewProject(String newNameProject, double price, double deposite) {

        newDAO.insertProject(newNameProject, price, deposite);
    }
}