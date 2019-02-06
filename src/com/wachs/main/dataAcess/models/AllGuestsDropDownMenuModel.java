package com.wachs.main.dataAcess.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AllGuestsDropDownMenuModel {

    public AllGuestsDropDownMenuModel() {

    }

    public ObservableList<String> getAllProjects() {

        /**
         ObservableList<String> content = FXCollections.observableArrayList();

         ArrayList<String> listOfProjects = new HouseDAOImpl().readAllData();

         for(String e:listOfProjects){

         content.add(e);
         }

         return content;
         **/
        ObservableList<String> options = FXCollections.observableArrayList(
                "Option 1a",
                "Option 2a",
                "Option a3"
        );

        return options;
    }

}
