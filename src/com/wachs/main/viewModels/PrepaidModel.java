package com.wachs.main.viewModels;

import com.wachs.main.businessObjects.Prepaid;
import com.wachs.main.dataAccess.DAO.PrepaidDAO;
import com.wachs.main.dataAccess.DAO.PrepaidDAOImpl;

public class PrepaidModel {

    private PrepaidDAO newDAO;
    private Prepaid prepaidSearchedGuest;
    private int idGuest;
    private int idProject;

    PrepaidModel(int idGuest, int idProject) {

        createModel(idGuest, idProject);
    }

    private void createModel(int idGuest, int idProject) {

        newDAO = new PrepaidDAOImpl();
        prepaidSearchedGuest = newDAO.findPrepaidByOneGuest(idGuest, idProject);

        this.idGuest = prepaidSearchedGuest.getIdGuest();
        this.idProject = prepaidSearchedGuest.getIdProject();
    }

    public double getPrepaid() {

        return prepaidSearchedGuest.getPrepaid();
    }

    public void setPrepaid(double prepaidValue) {

        prepaidSearchedGuest.setPrepaid(prepaidValue);
        if (prepaidSearchedGuest == null) {

            newDAO.insertPrepaidForOneGuest(idGuest, idProject, prepaidValue);
        } else {

            newDAO.updatePrepaidForOneGuest(idGuest, idProject, prepaidValue);
        }
    }
}