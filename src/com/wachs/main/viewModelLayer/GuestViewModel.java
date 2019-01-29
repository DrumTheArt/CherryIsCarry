package com.wachs.main.viewModelLayer;

import com.wachs.main.businessLayer.Guest;
import com.wachs.main.dataBaseLayer.DAO.GuestDAO;
import com.wachs.main.dataBaseLayer.DAO.GuestDAOImpl;

import java.io.IOException;
import java.sql.SQLException;

public class GuestViewModel {

    /**
    private GuestDAO newDAO;
    private Guest searchedGuest;

    //findOneData(String name, int id_house)

    GuestModel(String guestName, int id_house) throws SQLException, IOException, ClassNotFoundException {

        createModel(guestName, id_house);
    }

    private Guest createModel(String guestName, int id_house) throws SQLException, IOException, ClassNotFoundException {

        newDAO = new GuestDAOImpl();
        searchedGuest = newDAO.findOneData(guestName, id_house);

        return searchedGuest;
    }

    public int getPK_id(){

        return searchedGuest.getPK_id();

    }

    public String getprojectTitle(){

        return searchedGuest.getTXT_name();

    }

    public double getPrice(){

        return searchedGuest.getREAL_price();

    }

    public double getDeposite(){

        return searchedGuest.getREAL_deposite();

    }
     **/
}
