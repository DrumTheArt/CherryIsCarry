package com.wachs.main.viewModels;

import com.wachs.main.businessObjects.Guest;
import com.wachs.main.dataAccess.DAO.GuestDAO;
import com.wachs.main.dataAccess.DAO.GuestDAOImpl;

public class GuestModel {

    private GuestDAO newDAO;
    private Guest searchedGuest;

    GuestModel(String guestName, int id_house) {

        createModel(guestName, id_house);
    }

    private Guest createModel(String guestName, int id_house) {

        newDAO = new GuestDAOImpl();
        searchedGuest = newDAO.findOneGuestByOneProject(guestName, id_house);

        return searchedGuest;
    }

}
