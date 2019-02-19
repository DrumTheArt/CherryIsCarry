package com.wachs.main.viewModels;

import com.wachs.main.businessObjects.Project;
import com.wachs.main.dataAccess.DAO.ProjectDAOImpl;

public class AllGuestsModel {


    private Project selectedProject;
    private int selectedProjectID;
    private double drinksAll;
    private double foodAll;
    private double totalCosts;
    private double outstandinPayments;


    public AllGuestsModel(String nameProject) {

        selectedProject = new ProjectDAOImpl().fineOneProject(nameProject);
        selectedProjectID = selectedProject.getPK_id();
    }

    public double getRentHouse() {

        return selectedProject.getProjectPrice();
    }


    //Idee: Diese Werte durch einen Calculator berechnen zu lassen
    //Calculator().getDrinksAll(id_house)
    //Calculator().getFoodAll(id_house)
    //Calculator().getFoodAll(id_house)

    //QueryGenerator

}
