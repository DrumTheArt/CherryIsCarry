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
        staySearchedGuest = newDAO.findStayByOneGuest(idGuest, idHouse);

        return staySearchedGuest;
    }

    public int getIdHouse(){

        return staySearchedGuest.getIdProject();

    }

    public int getIdGuest(){

        return staySearchedGuest.getIdGuest();

    }

    public int getNightCount(){

        return staySearchedGuest.getNights();

    }

}
