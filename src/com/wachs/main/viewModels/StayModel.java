package com.wachs.main.viewModels;

import com.wachs.main.businessObjects.Stay;
import com.wachs.main.dataAccess.DAO.StayDAO;
import com.wachs.main.dataAccess.DAO.StayDAOImpl;

import java.io.IOException;
import java.sql.SQLException;


public class StayModel {

    private StayDAO newDAO;
    private Stay staySearchedGuest;

    StayModel(int idGuest, int idHouse)  {

        createModel(idGuest, idHouse);
    }

    private Stay createModel(int idGuest, int idHouse) {

        newDAO = new StayDAOImpl();
        staySearchedGuest = newDAO.findStayByOneGuest(idGuest, idHouse);

        return staySearchedGuest;
    }

}
