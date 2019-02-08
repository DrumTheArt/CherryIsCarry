package com.wachs.main.dataAcess.models;

import com.wachs.main.businessObjects.House;
import com.wachs.main.dataAcess.DAO.HouseDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class AllProjectsDropDownMenuModel {

    public AllProjectsDropDownMenuModel() {

    }

    private int[] allPKids;

    public ObservableList<String> getAllProjects() {

        ArrayList<House> content = null;

        content = new HouseDAOImpl().readAllData();

        allPKids = new int[content.size()];

        for (int i = 0; i < content.size(); i++) {

            allPKids[i] = content.get(i).getPK_id();

        }

        ObservableList<String> options = FXCollections.observableArrayList();

        for (House e : content) {

            options.add(e.getTXT_name());

        }

        return options;
    }


}
