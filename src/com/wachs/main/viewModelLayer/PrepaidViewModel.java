package com.wachs.main.viewModelLayer;

import com.wachs.main.businessLayer.Prepaid;
import com.wachs.main.dataBaseLayer.DAO.PrepaidDAO;
import com.wachs.main.dataBaseLayer.DAO.PrepaidDAOImpl;

import java.io.IOException;
import java.sql.SQLException;


public class PrepaidViewModel {

    private PrepaidDAO newDAO;
    private Prepaid staySearchedGuest;

    PrepaidViewModel(int idGuest, int idHouse) throws SQLException, IOException, ClassNotFoundException {

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
