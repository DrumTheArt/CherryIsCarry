package com.wachs.main.Models;

import com.wachs.main.BusinessEntities.Prepaid;
import com.wachs.main.DataAccess.services.IPrepaidService;
import com.wachs.main.DataAccess.services.PrepaidService;

public class PrepaidModel {

    private IPrepaidService newDAO;
    private Prepaid prepaidSearchedGuest;
    private int idGuest;
    private int idProject;

    PrepaidModel(int idGuest, int idProject) {

        createModel(idGuest, idProject);
    }

    private void createModel(int idGuest, int idProject) {

        newDAO = new PrepaidService();
        prepaidSearchedGuest = newDAO.fetchPrepaidOneGuest(idGuest, idProject);

        this.idGuest = prepaidSearchedGuest.getGuestId();
        this.idProject = prepaidSearchedGuest.getProjectId();
    }

    public double getPrepaid() {

        return prepaidSearchedGuest.getPrepaid();
    }

    public void setPrepaid(double prepaidValue) {

        prepaidSearchedGuest.setPrepaid(prepaidValue);
        if (prepaidSearchedGuest == null) {

            newDAO.insertPrepaidOneGuest(idGuest, idProject, prepaidValue);
        } else {

            newDAO.updatePrepaidOneGuest(idGuest, idProject, prepaidValue);
        }
    }
}