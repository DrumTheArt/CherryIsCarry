package com.wachs.main.models;

import com.wachs.main.POJO.Project;
import com.wachs.main.dataAccess.services.ProjectService;
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

        allProjectsAsList = new ProjectService().fetchAllProjects();

        getAllProjects = FXCollections.observableArrayList();

        for (Project e : allProjectsAsList) {

            getAllProjects.add(e.getName());
        }

    }

    private void setAllIds() {

        getAllPrimaryKeyToAllProjects = new int[getAllProjects.size()];

        for (int i = 0; i < getAllProjects.size(); i++) {

            getAllPrimaryKeyToAllProjects[i] = allProjectsAsList.get(i).getPrimaryKey();

        }

    }

    public int[] getGetAllPrimaryKeyToAllProjects() {
        return getAllPrimaryKeyToAllProjects;
    }

    public ObservableList<String> getGetAllProjects() {
        return getAllProjects;
    }

}
