package com.wachs.main.models;

import com.wachs.main.POJO.Stay;
import com.wachs.main.dataAccess.DAO.StayDAO;
import com.wachs.main.dataAccess.DAO.StayDAOImpl;

public class StayModel {

    private StayDAO newDAO;
    private Stay staySearchedGuest;
    private int idGuest;
    private int idProject;

    StayModel(int idGuest, int idProject) {

        createModel(idGuest, idProject);
    }

    private void createModel(int idGuest, int idProject) {

        newDAO = new StayDAOImpl();
        staySearchedGuest = newDAO.fetchStayOneGuest(idGuest, idProject);

        this.idGuest = staySearchedGuest.getIdGuest();
        this.idProject = staySearchedGuest.getIdProject();
    }

    public int getNights() {

        return staySearchedGuest.getNights();
    }

    public void setNights(int nights) {

        staySearchedGuest.setNights(nights);

        if (staySearchedGuest == null) {

            newDAO.insertStayOneGuest(idGuest, idProject, nights);
        } else {

            newDAO.updateStayOneGuest(idGuest, idProject, nights);
        }
    }
}