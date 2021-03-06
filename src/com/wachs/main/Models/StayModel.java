package com.wachs.main.Models;

import com.wachs.main.BusinessEntities.Stay;
import com.wachs.main.DataAccess.services.IStayService;
import com.wachs.main.DataAccess.services.StayService;

public class StayModel {

    private IStayService newDAO;
    private Stay staySearchedGuest;
    private int idGuest;
    private int idProject;

    StayModel(int idGuest, int idProject) {

        createModel(idGuest, idProject);
    }

    private void createModel(int idGuest, int idProject) {

        newDAO = new StayService();
        staySearchedGuest = newDAO.fetchStayOneGuest(idGuest, idProject);

        this.idGuest = staySearchedGuest.getGuestId();
        this.idProject = staySearchedGuest.getProjectId();
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