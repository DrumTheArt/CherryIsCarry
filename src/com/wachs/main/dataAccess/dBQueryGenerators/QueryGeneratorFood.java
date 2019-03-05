package com.wachs.main.dataAccess.dBQueryGenerators;

public class QueryGeneratorFood {

    public static final String TABLENAME = "TBL_FOOD";
    public static String COLUMN1 = "FK_id";
    public static String COLUMN2 = "INT_nights";
    public static String COLUMN3 = "ID_guest";
    public static String COLUMN4 = "ID_project";


    public String queryFindFoodByOneGuest(int idGuest, int idProject) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + ", " + COLUMN4 + " from " + TABLENAME + " WHERE " + COLUMN3 + " = " + idGuest + " AND " + COLUMN4 + " = " +idProject;

        return query;
    }

    public String queryInsertFoodForOneGuest(int idGuest, int idProject, int foodNights) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + "," + COLUMN4 + ") VALUES (? ," + "'" + foodNights + "'" + "," + idGuest + "," + idProject + ")";

        return query;
    }

    public String queryDeleteFoodForOneGuest(int idGuest, int idProject) {
        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN3 + "=" + idGuest + " AND " + COLUMN4 + " = " + idProject;

        return query;
    }

    public String queryUpdateFoodForOneGuest(int idGuest, int idProject, int foodNewNights) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + foodNewNights + " WHERE " + COLUMN3 + " = " + idGuest + " AND " + COLUMN4 + " = " + idProject;

        return query;
    }

    public String queryFindAllFoodByOneProject(int idProject) {

        String query = "SELECT * FROM " + TABLENAME + " where " +  COLUMN4 + " = " + idProject;

        return query;
    }
}
