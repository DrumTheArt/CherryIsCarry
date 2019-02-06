package com.wachs.main.dataAcess.models;

import com.wachs.main.businessObjects.House;
import com.wachs.main.dataAcess.DAO.HouseDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AllProjectsDropDownMenuModel {

    public AllProjectsDropDownMenuModel() {

    }

    public ObservableList<String> getAllProjects() {

        ArrayList<House> content = null;
        try {
            content = new HouseDAOImpl().readAllData();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObservableList<String> options = FXCollections.observableArrayList();

        for (House e : content) {

            options.add(e.getTXT_name());

        }

        return options;
    }


}
