package com.wachs.main.dataAcess.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AllProjectsDropDownMenuModel {

    public AllProjectsDropDownMenuModel() {

    }

    public ObservableList<String> getAllProjects() {

        ObservableList<String> options = FXCollections.observableArrayList(
                "Option 1",
                "Option 2",
                "Option 3"
        );

        return options;
    }


}
