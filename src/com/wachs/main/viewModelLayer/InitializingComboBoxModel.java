package com.wachs.main.viewModelLayer;

import com.wachs.main.businessLayer.House;
import com.wachs.main.dataBaseLayer.DAO.HouseDAO;
import com.wachs.main.dataBaseLayer.DAO.HouseDAOImpl;
import com.wachs.main.dataBaseLayer.DAO.IDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class InitializingComboBoxModel extends JComboBox implements ActionListener {

    private String[] allHousesComboBoxModel;
    private String[] allGuestsComboBoxModel;

    private JComboBox allHouses;
    private JComboBox allRelativeGuests;

    private String[] getAllHousesComboBoxModel() throws SQLException, ClassNotFoundException {

        HouseDAO aHouse = new HouseDAOImpl();
        ArrayList<House> listOfHouse;
        listOfHouse = aHouse.readAllData();

        allHousesComboBoxModel = new String[listOfHouse.size()];
        for (int i = 0; i<listOfHouse.size(); i++){

            allHousesComboBoxModel[i] = listOfHouse.get(i).getTXT_name();
        }

        return allHousesComboBoxModel;
    }

    private String[] getAllGuestsComboBoxModel() throws SQLException, ClassNotFoundException {


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


    public JComboBox getAllHouses() throws SQLException, ClassNotFoundException {

        allHouses = new JComboBox(getAllHousesComboBoxModel());

        return allHouses;
    }

    public JComboBox getAllGuests() throws SQLException, ClassNotFoundException {

        allRelativeGuests = new JComboBox(getAllGuestsComboBoxModel());

        return allRelativeGuests;
    }


    public void actionPerformed(ActionEvent e) {

        try {
            allRelativeGuests.setSelectedItem(this.getAllGuestsComboBoxModel());
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

}
