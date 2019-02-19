package com.wachs.main.viewModels;

import com.wachs.main.businessObjects.Prepaid;
import com.wachs.main.dataAccess.DAO.PrepaidDAO;
import com.wachs.main.dataAccess.DAO.PrepaidDAOImpl;

import java.io.IOException;
import java.sql.SQLException;


public class PrepaidModel {

    private PrepaidDAO newDAO;
    private Prepaid staySearchedGuest;

    PrepaidModel(int idGuest, int idHouse) {

        createModel(idGuest, idHouse);
    }

    private Prepaid createModel(int idGuest, int idHouse) {

        newDAO = new PrepaidDAOImpl();
        staySearchedGuest = newDAO.findPrepaidByOneGuest(idGuest, idHouse);

        return staySearchedGuest;
    }

}
