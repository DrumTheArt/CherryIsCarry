package com.wachs.unittests;

import com.wachs.main.dataAccess.dBQueryGenerators.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class QueryGeneratorOutput {

    private QueryGeneratorDrinks queryDrinks;
    private QueryGeneratorDrinksExpenses queryDrinksExpenses;
    private QueryGeneratorFood queryFood;
    private QueryGeneratorFoodExpenses queryFoodExpenses;
    private QueryGeneratorGuest queryGuest;
    private QueryGeneratorOtherExpenses queryOtherExpenses;
    private QueryGeneratorPrepaid queryPrepaid;
    private QueryGeneratorProject queryProject;
    private QueryGeneratorStay queryStay;

    private final String nameGuest = "Robert";
    private final String projectName = "The Project 2019";
    private final double projectPrice = 5000.00;
    private final double projectDeposite = 2000.00;
    private final String projectNewName = "The new Project 2019";
    private final double projectnewPrice = 5000.00;
    private final double projectnewDeposite = 2000.00;
    private final int idGuest = 1;
    private final int idProject = 1;
    private final int nights = 3;
    private final int newNights = 3;
    private final double price = 200.00;
    private final String reason = "The reason";
    private final String when = "01.01.2019";
    private final String newName = "Robert der Zweite";
    private final double newPrice = 800.00;
    private final String newReason = "The second new reason";
    private final String newWhen = "01.12.2019";

    private FileWriter writer;
    private File file;

    public QueryGeneratorOutput() {

        queryDrinks = new QueryGeneratorDrinks();
        queryDrinksExpenses = new QueryGeneratorDrinksExpenses();
        queryFood = new QueryGeneratorFood();
        queryFoodExpenses = new QueryGeneratorFoodExpenses();
        queryGuest = new QueryGeneratorGuest();
        queryOtherExpenses = new QueryGeneratorOtherExpenses();
        queryPrepaid = new QueryGeneratorPrepaid();
        queryProject = new QueryGeneratorProject();
        queryStay = new QueryGeneratorStay();

    }

    private String[] queryDrinks() {

        String[] allQueriesDrinks = new String[5];

        allQueriesDrinks[0] = queryDrinks.queryInsertDrinksForOneGuest(idGuest, idProject, nights);
        allQueriesDrinks[1] = queryDrinks.queryFindAllDrinksByOneProject(idProject);
        allQueriesDrinks[2] = queryDrinks.queryFindDrinksByOneGuest(idGuest, idProject);
        allQueriesDrinks[3] = queryDrinks.queryUpdateDrinksForOneGuest(idGuest, idProject, newNights);
        allQueriesDrinks[4] = queryDrinks.queryDeleteDrinksForOneGuest(idGuest, idProject);

        return allQueriesDrinks;
    }

    private String[] queryDrinksExpenses() {

        String[] allQueriesDrinksExpenses = new String[5];

        allQueriesDrinksExpenses[0] = queryDrinksExpenses.queryInsertDrinksExpensesForOneGuest(idGuest, idProject, price, reason, when);
        allQueriesDrinksExpenses[1] = queryDrinksExpenses.queryFindAllDrinksExpensesByOneProject(idProject);
        allQueriesDrinksExpenses[2] = queryDrinksExpenses.queryFindDrinksExpensesByOneGuest(idGuest, idProject);
        allQueriesDrinksExpenses[3] = queryDrinksExpenses.queryUpdateDrinksExpensesForOneGuest(idGuest, idProject, price, reason, when, newPrice, newReason, newWhen);
        allQueriesDrinksExpenses[4] = queryDrinksExpenses.queryDeleteDrinksExpensesForOneGuest(idGuest, idProject, newPrice, newReason, newWhen);

        return allQueriesDrinksExpenses;
    }

    private String[] queryFood() {

        String[] allQueriesFood = new String[5];

        allQueriesFood[0] = queryFood.queryInsertFoodForOneGuest(idGuest, idProject, nights);
        allQueriesFood[1] = queryFood.queryFindAllFoodByOneProject(idProject);
        allQueriesFood[2] = queryFood.queryFindFoodByOneGuest(idGuest, idProject);
        allQueriesFood[3] = queryFood.queryUpdateFoodForOneGuest(idGuest, idProject, newNights);
        allQueriesFood[4] = queryFood.queryDeleteFoodForOneGuest(idGuest, idProject);

        return allQueriesFood;
    }

    private String[] queryFoodExpenses() {

        String[] allQueriesFoodExpenses = new String[5];

        allQueriesFoodExpenses[0] = queryFoodExpenses.queryInsertFoodExpensesForOneGuest(idGuest, idProject, price, reason, when);
        allQueriesFoodExpenses[1] = queryFoodExpenses.queryFindAllFoodExpensesByOneProject(idProject);
        allQueriesFoodExpenses[2] = queryFoodExpenses.queryFindFoodExpensesByOneGuest(idGuest, idProject);
        allQueriesFoodExpenses[3] = queryFoodExpenses.queryUpdateFoodExpensesForOneGuest(idGuest, idProject, price, reason, when, newPrice, newReason, newWhen);
        allQueriesFoodExpenses[4] = queryFoodExpenses.queryDeleteFoodExpensesForOneGuest(idGuest, idProject, newPrice, newReason, newWhen);

        return allQueriesFoodExpenses;
    }

    private String[] queryGuest() {

        String[] allQueriesGuest = new String[5];

        allQueriesGuest[0] = queryGuest.queryInsertGuestForOneProject(nameGuest, idProject);
        allQueriesGuest[1] = queryGuest.queryFindAllGuestsByOneProject(idProject);
        allQueriesGuest[2] = queryGuest.queryFindOneGuestByOneProject(nameGuest, idProject);
        allQueriesGuest[3] = queryGuest.queryUpdateGuestForOneProject(idGuest, newName, idProject);
        allQueriesGuest[4] = queryGuest.queryDeleteGuestForOneProject(newName, idProject);

        return allQueriesGuest;
    }

    private String[] queryOtherExpenses() {

        String[] allQueriesOtherExpenses = new String[5];

        allQueriesOtherExpenses[0] = queryOtherExpenses.queryInsertOtherExpensesForOneGuest(idGuest, idProject, price, reason, when);
        allQueriesOtherExpenses[1] = queryOtherExpenses.queryFindAllOtherExpensesByOneProject(idProject);
        allQueriesOtherExpenses[2] = queryOtherExpenses.queryFindOtherExpensesByOneGuest(idGuest, idProject);
        allQueriesOtherExpenses[3] = queryOtherExpenses.queryUpdateOtherExpensesForOneGuest(idGuest, idProject, price, reason, when, newPrice, newReason, newWhen);
        allQueriesOtherExpenses[4] = queryOtherExpenses.queryDeleteOtherExpensesForOneGuest(idGuest, idProject, newPrice, newReason, newWhen);

        return allQueriesOtherExpenses;
    }

    private String[] queryPrepaid() {

        String[] allQueriesPrepaid = new String[5];

        allQueriesPrepaid[0] = queryPrepaid.queryInsertPrepaidForOneGuest(idGuest, idProject, price);
        allQueriesPrepaid[1] = queryPrepaid.queryFindAllPrepaidByOneProject(idProject);
        allQueriesPrepaid[2] = queryPrepaid.queryFindPrepaidByOneGuest(idGuest, idProject);
        allQueriesPrepaid[3] = queryPrepaid.queryUpdatePrepaidForOneGuest(idGuest, idProject, newPrice);
        allQueriesPrepaid[4] = queryPrepaid.queryDeletePrepaidForOneGuest(idGuest, idProject);

        return allQueriesPrepaid;
    }

    private String[] queryProject() {

        String[] allQueriesProject = new String[5];

        allQueriesProject[0] = queryProject.queryInsertOneProject(projectName, projectPrice, projectDeposite);
        allQueriesProject[1] = queryProject.queryFindOneProject(projectName);
        allQueriesProject[2] = queryProject.queryFindAllProjects();
        allQueriesProject[3] = queryProject.queryUpdateOneProject(idProject, projectNewName, projectnewPrice, projectnewDeposite);
        allQueriesProject[4] = queryProject.queryDeleteOneProject(projectNewName);

        return allQueriesProject;
    }

    private String[] queryStay() {

        String[] allQueriesStay = new String[5];

        allQueriesStay[0] = queryStay.queryInsertStayForOneGuest(idGuest, idProject, nights);
        allQueriesStay[1] = queryStay.queryFindAllStayByOneProject(idProject);
        allQueriesStay[2] = queryStay.queryFindStayByOneGuest(idGuest, idProject);
        allQueriesStay[3] = queryStay.queryUpdateStayForOneGuest(idGuest, idProject, newNights);
        allQueriesStay[4] = queryStay.queryDeleteStayForOneGuest(idGuest, idProject);

        return allQueriesStay;
    }

    public void writeAllQueriesToOneFile() {

        file = new File("AllQueries.txt");

        try {

            writer = new FileWriter(file, false);

            for (int i = 0; i < queryDrinks().length; i++) {
                writer.write(queryDrinks()[i]);
                writer.write(System.getProperty("line.separator"));
            }

            for (int i = 0; i < queryDrinksExpenses().length; i++) {
                writer.write(queryDrinksExpenses()[i]);
                writer.write(System.getProperty("line.separator"));
            }

            for (int i = 0; i < queryFood().length; i++) {
                writer.write(queryFood()[i]);
                writer.write(System.getProperty("line.separator"));
            }

            for (int i = 0; i < queryFoodExpenses().length; i++) {
                writer.write(queryFoodExpenses()[i]);
                writer.write(System.getProperty("line.separator"));
            }

            for (int i = 0; i < queryGuest().length; i++) {
                writer.write(queryGuest()[i]);
                writer.write(System.getProperty("line.separator"));
            }

            for (int i = 0; i < queryOtherExpenses().length; i++) {
                writer.write(queryOtherExpenses()[i]);
                writer.write(System.getProperty("line.separator"));
            }

            for (int i = 0; i < queryPrepaid().length; i++) {
                writer.write(queryPrepaid()[i]);
                writer.write(System.getProperty("line.separator"));
            }

            for (int i = 0; i < queryProject().length; i++) {
                writer.write(queryProject()[i]);
                writer.write(System.getProperty("line.separator"));
            }

            for (int i = 0; i < queryStay().length; i++) {
                writer.write(queryStay()[i]);
                writer.write(System.getProperty("line.separator"));
            }

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        QueryGeneratorOutput createOutput = new QueryGeneratorOutput();
        createOutput.writeAllQueriesToOneFile();
    }
}