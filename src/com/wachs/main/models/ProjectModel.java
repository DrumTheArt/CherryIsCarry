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
        searchedProject = newDAO.fineOneProject(projectName);

        return searchedProject;
    }

}