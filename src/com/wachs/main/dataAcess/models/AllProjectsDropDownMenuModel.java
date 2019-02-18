package com.wachs.main.dataAcess.models;

import com.wachs.main.businessObjects.Project;
import com.wachs.main.dataAcess.DAO.ProjectDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class AllProjectsDropDownMenuModel {

    private int[] getAllPrimaryKeyToAllProjects;
    private ObservableList<String> getAllProjects;
    private ArrayList<Project> allProjectsAsList;


    public AllProjectsDropDownMenuModel() {

        setProjects();
        setAllIds();
    }

    private void setProjects() {

        allProjectsAsList = new ProjectDAOImpl().findOneProject();

        getAllProjects = FXCollections.observableArrayList();

        for (Project e : allProjectsAsList) {

            getAllProjects.add(e.getProjectName());
        }

    }

    private void setAllIds() {

        getAllPrimaryKeyToAllProjects = new int[getAllProjects.size()];

        for (int i = 0; i < getAllProjects.size(); i++) {

            getAllPrimaryKeyToAllProjects[i] = allProjectsAsList.get(i).getPK_id();

        }

    }

    public int[] getGetAllPrimaryKeyToAllProjects() {
        return getAllPrimaryKeyToAllProjects;
    }

    public ObservableList<String> getGetAllProjects() {
        return getAllProjects;
    }

}
