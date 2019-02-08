package com.wachs.main.dataAcess.models;

import com.wachs.main.businessObjects.House;
import com.wachs.main.dataAcess.DAO.HouseDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class AllProjectsDropDownMenuModel {

    private int[] getAllPrimaryKeyToAllProjects;
    private ObservableList<String> getAllProjects;
    private ArrayList<House> allProjectsAsList;


    public AllProjectsDropDownMenuModel() {

        setProjects();
        setAllIds();
    }

    private void setProjects() {

        allProjectsAsList = new HouseDAOImpl().readAllData();

        getAllProjects = FXCollections.observableArrayList();

        for (House e : allProjectsAsList) {

            getAllProjects.add(e.getTXT_name());
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
