package com.wachs.main.dataAccess.repository;

import com.wachs.main.dataAccess.services.*;

public class ParameterServiceObject {

    private IDrinksService drinksService;
    private IFoodService foodService;
    private IStayService stayService;
    private IPrepaidService prepaidService;
    private IGuestService guestService;
    private IProjectService projectService;
    private IOtherExpensesService otherExpensesService;
    private IFoodExpensesService foodExpensesService;
    private IDrinksExpensesService drinksExpensesService;


    ParameterServiceObject(){

        drinksService = new DrinksService();
        foodService = new FoodService();
        stayService = new StayService();
        prepaidService = new PrepaidService();
        guestService = new GuestService();
        prepaidService = new PrepaidService();
        projectService = new ProjectService();
        otherExpensesService = new OtherExpensesService();
        foodExpensesService = new FoodExpensesService();
        drinksExpensesService = new DrinksExpensesService();

    }

    public IDrinksService getDrinkService(){

        return this.drinksService;

    }

    public IFoodService getFoodService(){

        return this.foodService;

    }

    public IGuestService getGuestService(){

        return this.guestService;

    }

    public IProjectService getProjectService(){

        return this.projectService;

    }

    public IStayService getStayService(){

        return this.stayService;
    }

    public IPrepaidService getPrepaidService(){

        return this.prepaidService;

    }

    public IOtherExpensesService getOtherExpensesService(){

        return this.otherExpensesService;

    }

    public IDrinksExpensesService getDrinksExpensesService(){

        return this.drinksExpensesService;

    }

    public IFoodExpensesService getFoodExpensesService(){

        return this.foodExpensesService;

    }

}