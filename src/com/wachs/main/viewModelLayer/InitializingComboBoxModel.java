package com.wachs.main.viewModelLayer;

import com.wachs.main.businessLayer.House;
import com.wachs.main.dataBaseLayer.DAO.HouseDAO;
import com.wachs.main.dataBaseLayer.DAO.HouseDAOImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class InitializingComboBoxModel extends JComboBox implements ActionListener {

    private String[] allHousesComboBoxModel;
    private String[] allGuestsComboBoxModel;

    private JComboBox allHouses;
    private JComboBox allRelativeGuests;

    private String[] getAllHousesComboBoxModel() throws SQLException, ClassNotFoundException, IOException {

        HouseDAO aHouse = new HouseDAOImpl();
        ArrayList<House> listOfHouse;
        listOfHouse = aHouse.readAllData();

        allHousesComboBoxModel = new String[listOfHouse.size()];
        for (int i = 0; i<listOfHouse.size(); i++){

            allHousesComboBoxModel[i] = listOfHouse.get(i).getTXT_name();
        }

        return allHousesComboBoxModel;
    }

    private String[] getAllGuestsComboBoxModel() {


        HouseDAO aHouse = new HouseDAOImpl();
        String item = (String) allHouses.getSelectedItem();

        int id_house;

        try {
            House house = aHouse.findOneData(item);
            id_house = house.getPK_id();

        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
/**
        ArrayList<Guest> allRelativeGuests =



         * Object o = subItems.get(item);
         *
         *         if (o == null) {
         *             subComboBox.setModel(new DefaultComboBoxModel());
         *         } else {
         *             subComboBox.setModel(new DefaultComboBoxModel((String[]) o));
         *         }
         *     }
         */

        return null;
    }

    public JComboBox getAllHouses() throws SQLException, ClassNotFoundException, IOException {

        allHouses = new JComboBox(getAllHousesComboBoxModel());

        return allHouses;
    }

    public JComboBox getAllGuests() {

        allRelativeGuests = new JComboBox(getAllGuestsComboBoxModel());

        return allRelativeGuests;
    }


    public void actionPerformed(ActionEvent e) {

        allRelativeGuests.setSelectedItem(this.getAllGuestsComboBoxModel());
    }

}
