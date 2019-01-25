package com.wachs.main.viewModelLayer;

import com.wachs.main.businessLayer.Stay;
import com.wachs.main.dataBaseLayer.DAO.StayDAO;
import com.wachs.main.dataBaseLayer.DAO.StayDAOImpl;

import java.io.IOException;
import java.sql.SQLException;


public class StayModel {

    private StayDAO newDAO;
    private Stay staySearchedGuest;

    StayModel(int idGuest, int idHouse) throws SQLException, IOException, ClassNotFoundException {

        createModel(idGuest, idHouse);
    }

    private Stay createModel(int idGuest, int idHouse) throws SQLException, IOException, ClassNotFoundException {

        newDAO = new StayDAOImpl();
        staySearchedGuest = newDAO.findOneData(idGuest, idHouse);

        return staySearchedGuest;
    }

    public int getIdHouse(){

        return staySearchedGuest.getId_house();

    }

    public int getIdGuest(){

        return staySearchedGuest.getId_guest();

    }

    public int getNightCount(){

        return staySearchedGuest.getNights();

    }

}
