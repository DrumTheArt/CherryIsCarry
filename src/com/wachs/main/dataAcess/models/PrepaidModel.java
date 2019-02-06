package com.wachs.main.dataAcess.models;

import com.wachs.main.businessObjects.Prepaid;
import com.wachs.main.dataAcess.DAO.PrepaidDAO;
import com.wachs.main.dataAcess.DAO.PrepaidDAOImpl;

import java.io.IOException;
import java.sql.SQLException;


public class PrepaidModel {

    private PrepaidDAO newDAO;
    private Prepaid staySearchedGuest;

    PrepaidModel(int idGuest, int idHouse) throws SQLException, IOException, ClassNotFoundException {

        createModel(idGuest, idHouse);
    }

    private Prepaid createModel(int idGuest, int idHouse) throws SQLException, IOException, ClassNotFoundException {

        newDAO = new PrepaidDAOImpl();
        staySearchedGuest = newDAO.findOneData(idGuest, idHouse);

        return staySearchedGuest;
    }

    public int getIdHouse(){

        return staySearchedGuest.getId_house();

    }

    public int getIdGuest(){

        return staySearchedGuest.getId_guest();

    }

    public double getPrepaidAmount() {

        return staySearchedGuest.getPrepaid();

    }

}
