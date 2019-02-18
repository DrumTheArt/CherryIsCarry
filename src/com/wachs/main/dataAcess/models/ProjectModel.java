package com.wachs.main.dataAcess.models;

import com.wachs.main.businessObjects.Project;
import com.wachs.main.dataAcess.DAO.ProjectDAO;
import com.wachs.main.dataAcess.DAO.ProjectDAOImpl;

import java.io.IOException;
import java.sql.SQLException;

public class ProjectModel {

    private ProjectDAO newDAO;
    private Project searchedProject;

    ProjectModel(String nameHouse) throws SQLException, IOException, ClassNotFoundException {

        createModel(nameHouse);
    }

    private Project createModel(String projectName) throws SQLException, IOException, ClassNotFoundException {

        newDAO = new ProjectDAOImpl();
        searchedProject = newDAO.fineOneProject(projectName);

        return searchedProject;
    }

    public int getPK_id(){

        return searchedProject.getPK_id();

    }

    public String getprojectTitle(){

        return searchedProject.getProjectName();

    }

    public double getPrice(){

        return searchedProject.getProjectPrice();

    }

    public double getDeposite(){

        return searchedProject.getProjectDeposite();

    }
}
