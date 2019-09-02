package com.wachs.main.dataAccess.repository;

import com.wachs.main.POJO.*;
import com.wachs.main.dataAccess.services.*;

import java.util.List;

public class RepositoryProject {

    private IDrinksService drinkService;
    private IFoodService foodService;
    private IProjectService projectService;
    private IStayService stayService;
    private IOtherExpensesService otherExpensesService;
    private IFoodExpensesService foodExpensesService;
    private IDrinksExpensesService drinksExpensesService;
    private IGuestService guestService;
    private IPrepaidService prpaidService;

    private String projectName;
    private int idProject;

    private Project project;
    private Guest guest;
    private Drinks drinks;
    private Food food;
    private Stay stay;
    private Prepaid prepaid;
    private OtherExpense otherExpense;
    private FoodExpense foodExpense;
    private DrinksExpense drinksExpense;


    RepositoryProject(ParameterServiceObject paramServicesObject, String projectName, String guestName){

        drinkService = paramServicesObject.getDrinkService();
        foodService = paramServicesObject.getFoodService();
        projectService = paramServicesObject.getProjectService();
        stayService = paramServicesObject.getStayService();
        otherExpensesService = paramServicesObject.getOtherExpensesService();
        foodExpensesService = paramServicesObject.getFoodExpensesService();
        drinksExpensesService = paramServicesObject.getDrinksExpensesService();
        guestService = paramServicesObject.getGuestService();
        prpaidService = paramServicesObject.getPrepaidService();
        this.projectName = projectName;

        this.project = projectService.fetchOneProject(projectName);
        this.idProject = project.getPrimaryKey();

    }

    public Project getProject(){

        return projectService.fetchOneProject(projectName);
    }

    public List<Guest> getAllGuest(){

        return guestService.fetchAllGuestsOneProject(idProject);
    }

    public double getPriceProject(){

        return project.getPrice();
    }

    public double getDeposite(){

        return project.getDeposite();
    }

    public List<Drinks> getAllDrinksAmount(){

        return null; //Hier Calculator für Drinks
    }

    public List<Food> getAllFoodAmount(){

        return null; //Hier Calculator für Food
    }

    public List<Stay> getAllStayAmount(){

        return null; //Hier Calculator für Stay
    }

    public List<Double> getOtherExpenseAllGuestAmount(){

        return null; //Hier Calculator für OtherExpenses
    }

    public List<DrinksExpense> getDrinksExpenses(){

        return null; //Hier Calculator für DrinksExpenses
    }

    public List<FoodExpense> getFoodExpenses(){

        return null; //Hier Calculator für FoodExpenses
    }

    public double getTotalCost(){

        return 0.0;//Hier Calculator
    }

    public double getAllreadyPaid(){

        return 0.0;//Hier Calculator
    }

    public double getOutstandingPayments(){

        return 0.0; //Calculator
    }

}
