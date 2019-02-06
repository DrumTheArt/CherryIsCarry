package com.wachs.main.dataAcess.models;

import com.wachs.main.businessObjects.Stay;
import com.wachs.main.dataAcess.DAO.StayDAO;
import com.wachs.main.dataAcess.DAO.StayDAOImpl;

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
