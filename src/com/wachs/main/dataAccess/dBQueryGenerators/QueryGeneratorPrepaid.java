package com.wachs.main.dataAccess.dBQueryGenerators;

public class QueryGeneratorPrepaid {

    public static final String TABLENAME = "TBL_PREPAID";
    public static String COLUMN1 = "FK_id";
    public static String COLUMN2 = "REAL_prepaid";
    public static String COLUMN3 = "ID_guest";
    public static String COLUMN4 = "ID_project";

    public String fetchQueryAllPrepaidOneProject(int idProject) {

        String query = "SELECT * FROM " + TABLENAME + " WHERE " + COLUMN4 + " = " + idProject;

        return query;
    }

    public String fetchQueryPrepaidOneGuest(int idGuest, int idProject) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + ", " + COLUMN4 + " from " + TABLENAME + " WHERE " + COLUMN3 + " = " + idGuest + " AND " + COLUMN4 + " = " +idProject;

        return query;
    }

    public String deleteQueryPrepaidOneGuest(int idGuest, int idProject) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN3 + "=" + idGuest + " AND " + COLUMN4 + " = " + idProject;

        return query;
    }

    public String insertQueryPrepaidOneGuest(int idGuest, int idProject, double prepaidPrice) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + "," + COLUMN4 + ") VALUES (? ," + prepaidPrice + "," + idGuest + "," + idProject + ")";

        return query;
    }

    public String updateQueryPrepaidOneGuest(int idGuest, int idProject, double prepaidPrice) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + prepaidPrice + " WHERE " + COLUMN3 + " = " + idGuest + " AND " + COLUMN4 + " = " + idProject;

        return query;
    }

    @Override
    public String toString() {

        return this.getClass().getName();
    }
}