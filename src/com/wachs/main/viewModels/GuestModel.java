package com.wachs.main.viewModels;

import com.wachs.main.businessObjects.Guest;
import com.wachs.main.businessObjects.Project;
import com.wachs.main.dataAccess.DAO.GuestDAO;
import com.wachs.main.dataAccess.DAO.GuestDAOImpl;
import com.wachs.main.dataAccess.DAO.ProjectDAO;
import com.wachs.main.dataAccess.DAO.ProjectDAOImpl;

public class GuestModel {

    private GuestDAO guestDAO;
    private ProjectDAO projectDAO;
    private Guest searchedGuest;
    private Project searchedProject;
    private int idHouse;

    GuestModel(String projectName, String guestName) {

        createModel(projectName, guestName);
    }

    private Guest createModel(String projectName, String guestName) {

        projectDAO = new ProjectDAOImpl();
        searchedProject = projectDAO.fineOneProject(projectName);
        idHouse = searchedGuest.getPK_id();

        guestDAO = new GuestDAOImpl();
        searchedGuest = guestDAO.findOneGuestByOneProject(guestName, idHouse);

        return searchedGuest;
    }


}
