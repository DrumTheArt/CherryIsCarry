package com.wachs.main.DataAccess.dBQueryGenerators;

public class QueryGeneratorStay {

    public static final String TABLENAME = "TBL_STAY";
    public static String COLUMN1 = "FK_id";
    public static String COLUMN2 = "INT_nights";
    public static String COLUMN3 = "ID_guest";
    public static String COLUMN4 = "ID_project";

    public String fetchQueryStayOneGuest(int idGuest, int idProject) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + ", " + COLUMN4 + " from " + TABLENAME + " WHERE " + COLUMN3 + " = " + idGuest + " AND " + COLUMN4 + " = " +idProject;

        return query;
    }

    public String insertQueryStayOneGuest(int idGuest, int idProject, int stayNights) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + "," + COLUMN4 + ") VALUES (? ," + "'" + stayNights + "'" + "," + idGuest + "," + idProject + ")";

        return query;
    }

    public String deleteQueryStayOneGuest(int idGuest, int idProject) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN3 + "=" + idGuest + " AND " + COLUMN4 + " = " + idProject;

        return query;
    }

    public String updateQueryStayOneGuest(int idGuest, int idProject, int stayNewNights) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + stayNewNights + " WHERE " + COLUMN3 + " = " + idGuest + " AND " + COLUMN4 + " = " + idProject;

        return query;
    }

    public String fetchAllStayOneProject(int idProject) {

        String query = "SELECT * FROM " + TABLENAME + " WHERE " + COLUMN4 + " = " + idProject;

        return query;
    }

    @Override
    public String toString() {

        return this.getClass().getName();
    }
}