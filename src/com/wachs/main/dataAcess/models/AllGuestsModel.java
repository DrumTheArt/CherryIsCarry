package com.wachs.main.dataAcess.models;

import com.wachs.main.businessObjects.Project;
import com.wachs.main.dataAcess.DAO.ProjectDAOImpl;

import java.util.ArrayList;

public class AllGuestsModel {


    private double rentHouse;
    private double drinksAll;
    private double foodAll;
    private double totalCosts;
    private double outstandinPayments;



    public AllGuestsModel(){

    }

    public double getRentHouse(String nameProject){

        ArrayList<Project> listOfProjects = new ProjectDAOImpl().findOneProject();

        for (Project projectSelected : listOfProjects) {

            if(projectSelected.getProjectName().equals(nameProject)){
                rentHouse = projectSelected.getProjectPrice();
            }
        }

        return rentHouse;
    }

    public double getdrinksAll(){


        return 0;

    }


    //Idee: Diese Werte durch einen Calculator berechnen zu lassen
    //Calculator().getDrinksAll(id_house)
    //Calculator().getFoodAll(id_house)
    //Calculator().getFoodAll(id_house)

    //QueryGenerator

}
