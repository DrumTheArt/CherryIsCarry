package com.wachs.main.dataAccess.repository;

import com.wachs.main.POJO.*;
import com.wachs.main.dataAccess.services.*;

import java.util.List;

public class RepositoryGuest {

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
    private String guestName;
    private int idProject;
    private int idGuest;

    private Project project;
    private Guest guest;
    private Drinks drinks;
    private Food food;
    private Stay stay;
    private Prepaid prepaid;
    private List<OtherExpense> otherExpense;
    private List<FoodExpense> foodExpense;
    private List<DrinksExpense> drinksExpense;


    RepositoryGuest(ParameterServiceObject paramServicesObject, String projectName, String guestName){

        drinkService = paramServicesObject.getDrinkService();
        foodService = paramServicesObject.getFoodService();
        projectService = paramServicesObject.getProjectService();
        stayService = paramServicesObject.getStayService();
        otherExpensesService = paramServicesObject.getOtherExpensesService();
        foodExpensesService = paramServicesObject.getFoodExpensesService();
        drinksExpensesService = paramServicesObject.getDrinksExpensesService();
        guestService = paramServicesObject.getGuestService();
        prpaidService = paramServicesObject.getPrepaidService();

    }

    private void setData(){

        this.projectName = projectName;
        this.guestName = guestName;

        this.project = projectService.fetchOneProject(projectName);
        this.idProject = project.getPrimaryKey();
        this.guest = guestService.fetchOneGuestOneProject(guestName, idProject);
        this.idGuest = guest.getPrimaryKey();

        this.food = foodService.fetchFoodByOneGuest(idGuest, idProject);
        this.stay = stayService.fetchStayOneGuest(idGuest, idProject);
        this.drinks = drinkService.fetchDrinksOneGuest(idGuest, idProject);
        this.otherExpense = otherExpensesService.fetchOtherExpensesOneGuest(idGuest, idProject);
        drinksExpense = drinksExpensesService.fetchDrinksExpensesOneGuest(idGuest, idProject);
        foodExpense = foodExpensesService.fetchFoodExpensesOneGuest(idGuest, idProject);


    }

    public Project getProject(){

        return this.project;
    }

    public Guest getGuest(){

        return this.guest;
    }

    public int getDrinksDays(){

        return drinks.getNights();
    }

    public int getFoodDays(){

       return food.getNights();
    }

    public int getStayDays(){

        return stay.getNights();
    }

    public double getPrepaidAmount(){

        return prepaid.getPrepaid();
    }

    public double getDrinksAmount(){

        return 0.0; //Calculator
    }

    public double getFoodAmount(){

        return 0.0; //Calculator
    }

    public double getStayAmount(){

        return 0.0; //Calculator
    }

    public List<OtherExpense> getOtherExpenseList(){

        return this.otherExpense;
    }

    public List<DrinksExpense> getDrinksExpensesList(){

        return this.drinksExpense;
    }

    public List<FoodExpense> getFoodExpensesList(){

        return this.foodExpense;
    }

    //TODO --> Als Lambda?
    public double sumOtherExpenses(){

        double sum = 0.0;

        //otherExpense.stream().reduce(0, x -> return x.getSpend());

        for (OtherExpense amount:otherExpense) {

            sum += amount.getSpend();
        }

        return sum;
    }

    public double sumDrinksExpenses(){

        double sum = 0.0;

        for (DrinksExpense amount:drinksExpense) {

            sum += amount.getSpend();
        }

        return sum;
    }

    public double sumFoodExpenses(){

        double sum = 0.0;

        for (FoodExpense amount:foodExpense) {

            sum += amount.getSpend();
        }

        return sum;
    }

    public double getAllreadyPaid(){

        double sum = 0.0;

        sum = this.sumDrinksExpenses() + this.sumFoodExpenses() + this.sumOtherExpenses() + this.getPrepaidAmount();

        return sum;
    }

    public double getTotalCosts(){

        return 0.0; //Calculator

    }

    public double getStillToPay(){

        return 0.0; //Calculator
    }
}
