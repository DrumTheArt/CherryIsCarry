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

        allQueriesDrinks[0] = queryDrinks.insertQueryOneGuest(idGuest, idProject, nights);
        allQueriesDrinks[1] = queryDrinks.fetchAllOneProject(idProject);
        allQueriesDrinks[2] = queryDrinks.fetchQueryOneGuest(idGuest, idProject);
        allQueriesDrinks[3] = queryDrinks.updateQueryForOneGuest(idGuest, idProject, newNights);
        allQueriesDrinks[4] = queryDrinks.deleteQueryOneGuest(idGuest, idProject);

        return allQueriesDrinks;
    }

    private String[] queryDrinksExpenses() {

        String[] allQueriesDrinksExpenses = new String[5];

        allQueriesDrinksExpenses[0] = queryDrinksExpenses.insertQueryDrinksExpensesOneGuest(idGuest, idProject, price, reason, when);
        allQueriesDrinksExpenses[1] = queryDrinksExpenses.fetchAllQueryDrinksExpensesOneProject(idProject);
        allQueriesDrinksExpenses[2] = queryDrinksExpenses.fetchDrinksExpensesOneGuest(idGuest, idProject);
        allQueriesDrinksExpenses[3] = queryDrinksExpenses.updateQueryDrinksExpensesOneGuest(idGuest, idProject, price, reason, when, newPrice, newReason, newWhen);
        allQueriesDrinksExpenses[4] = queryDrinksExpenses.deleteQueryDrinksExpensesOneGuest(idGuest, idProject, newPrice, newReason, newWhen);

        return allQueriesDrinksExpenses;
    }

    private String[] queryFood() {

        String[] allQueriesFood = new String[5];

        allQueriesFood[0] = queryFood.insertQueryFoodOneGuest(idGuest, idProject, nights);
        allQueriesFood[1] = queryFood.fetchAllQueryFoodOneProject(idProject);
        allQueriesFood[2] = queryFood.fetchQueryFoodOneGuest(idGuest, idProject);
        allQueriesFood[3] = queryFood.updateQueryFoodOneGuest(idGuest, idProject, newNights);
        allQueriesFood[4] = queryFood.deleteQueryFoodOneGuest(idGuest, idProject);

        return allQueriesFood;
    }

    private String[] queryFoodExpenses() {

        String[] allQueriesFoodExpenses = new String[5];

        allQueriesFoodExpenses[0] = queryFoodExpenses.insertQueryFoodExpensesOneGuest(idGuest, idProject, price, reason, when);
        allQueriesFoodExpenses[1] = queryFoodExpenses.fetchAllFoodExpensesOneProject(idProject);
        allQueriesFoodExpenses[2] = queryFoodExpenses.fetchFoodExpensesOneGuest(idGuest, idProject);
        allQueriesFoodExpenses[3] = queryFoodExpenses.updateQueryFoodExpensesOneGuest(idGuest, idProject, price, reason, when, newPrice, newReason, newWhen);
        allQueriesFoodExpenses[4] = queryFoodExpenses.deleteFoodExpensesOneGuest(idGuest, idProject, newPrice, newReason, newWhen);

        return allQueriesFoodExpenses;
    }

    private String[] queryGuest() {

        String[] allQueriesGuest = new String[5];

        allQueriesGuest[0] = queryGuest.insertQueryGuestOneProject(nameGuest, idProject);
        allQueriesGuest[1] = queryGuest.fetchQueryAllGuestsOneProject(idProject);
        allQueriesGuest[2] = queryGuest.fetchQueryOneGuestOneProject(nameGuest, idProject);
        allQueriesGuest[3] = queryGuest.updateQueryGuestOneProject(idGuest, newName, idProject);
        allQueriesGuest[4] = queryGuest.deleteQueryGuestOneProject(newName, idProject);

        return allQueriesGuest;
    }

    private String[] queryOtherExpenses() {

        String[] allQueriesOtherExpenses = new String[5];

        allQueriesOtherExpenses[0] = queryOtherExpenses.insertQueryOtherExpensesOneGuest(idGuest, idProject, price, reason, when);
        allQueriesOtherExpenses[1] = queryOtherExpenses.fetchQueryAllOtherExpensesOneProject(idProject);
        allQueriesOtherExpenses[2] = queryOtherExpenses.fetchQueryOtherExpensesOneGuest(idGuest, idProject);
        allQueriesOtherExpenses[3] = queryOtherExpenses.updateQueryOtherExpensesOneGuest(idGuest, idProject, price, reason, when, newPrice, newReason, newWhen);
        allQueriesOtherExpenses[4] = queryOtherExpenses.deleteQueryOtherExpensesOneGuest(idGuest, idProject, newPrice, newReason, newWhen);

        return allQueriesOtherExpenses;
    }

    private String[] queryPrepaid() {

        String[] allQueriesPrepaid = new String[5];

        allQueriesPrepaid[0] = queryPrepaid.insertQueryPrepaidOneGuest(idGuest, idProject, price);
        allQueriesPrepaid[1] = queryPrepaid.FetchQueryAllPrepaidOneProject(idProject);
        allQueriesPrepaid[2] = queryPrepaid.fetchQueryPrepaidOneGuest(idGuest, idProject);
        allQueriesPrepaid[3] = queryPrepaid.updateQueryPrepaidOneGuest(idGuest, idProject, newPrice);
        allQueriesPrepaid[4] = queryPrepaid.deleteQueryPrepaidOneGuest(idGuest, idProject);

        return allQueriesPrepaid;
    }

    private String[] queryProject() {

        String[] allQueriesProject = new String[5];

        allQueriesProject[0] = queryProject.insertQueryOneProject(projectName, projectPrice, projectDeposite);
        allQueriesProject[1] = queryProject.fetchQueryOneProject(projectName);
        allQueriesProject[2] = queryProject.FetchQueryAllProjects();
        allQueriesProject[3] = queryProject.updateQueryOneProject(idProject, projectNewName, projectnewPrice, projectnewDeposite);
        allQueriesProject[4] = queryProject.deleteQueryOneProject(projectNewName);

        return allQueriesProject;
    }

    private String[] queryStay() {

        String[] allQueriesStay = new String[5];

        allQueriesStay[0] = queryStay.insertQueryStayOneGuest(idGuest, idProject, nights);
        allQueriesStay[1] = queryStay.fetchAllStayOneProject(idProject);
        allQueriesStay[2] = queryStay.fetchQueryStayOneGuest(idGuest, idProject);
        allQueriesStay[3] = queryStay.updateQueryStayOneGuest(idGuest, idProject, newNights);
        allQueriesStay[4] = queryStay.deleteQueryStayOneGuest(idGuest, idProject);

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