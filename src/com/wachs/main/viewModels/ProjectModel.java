package com.wachs.main.viewModels;

import com.wachs.main.businessObjects.Project;
import com.wachs.main.dataAccess.DAO.ProjectDAO;
import com.wachs.main.dataAccess.DAO.ProjectDAOImpl;

public class ProjectModel {

    private ProjectDAO newDAO;
    private Project searchedProject;

    ProjectModel(String nameHouse) {

        createModel(nameHouse);
    }

    private Project createModel(String projectName) {

        newDAO = new ProjectDAOImpl();
        searchedProject = newDAO.fineOneProject(projectName);

        return searchedProject;
    }

}