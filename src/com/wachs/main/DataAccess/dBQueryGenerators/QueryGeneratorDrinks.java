package com.wachs.main.DataAccess.dBQueryGenerators;

public class QueryGeneratorDrinks {

    public static String TABLENAME = "TBL_DRINKS";
    public static String COLUMN1 = "FK_id";
    public static String COLUMN2 = "INT_nights";
    public static String COLUMN3 = "ID_guest";
    public static String COLUMN4 = "ID_project";

    public String fetchQueryOneGuest(int idGuest, int idProject) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + ", " + COLUMN4 + " from " + TABLENAME + " WHERE " + COLUMN3 + " = " + idGuest + " AND " + COLUMN4 + " = " +idProject;

        return query;
    }

    public String insertQueryOneGuest(int idGuest, int idProject, int drinksNights) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + "," + COLUMN4 + ") VALUES (? ," + drinksNights + "," + idGuest + "," + idProject + ")";

        return query;
    }

    public String deleteQueryOneGuest(int idGuest, int idProject) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN3 + "=" + idGuest + " AND " + COLUMN4 + " = " + idProject;

        return query;
    }

    public String updateQueryForOneGuest(int idGuest, int idProject, int drinksNewNights) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + drinksNewNights + " WHERE " + COLUMN3 + " = " + idGuest + " AND " + COLUMN4 + " = " + idProject;

        return query;
    }

    public String fetchAllOneProject(int idProject) {

        String query = "SELECT * FROM " + TABLENAME + " where " + COLUMN4 + " = " + idProject;

        return query;
    }

    @Override
    public String toString() {

        return this.getClass().getName();
    }
}
