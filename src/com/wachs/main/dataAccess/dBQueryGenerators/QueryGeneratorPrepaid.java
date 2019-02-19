package com.wachs.main.dataAccess.dBQueryGenerators;

public class QueryGeneratorPrepaid {

    public static final String TABLENAME = "TBL_PREPAID";
    public static String COLUMN1 = "FK_id";
    public static String COLUMN2 = "REAL_prepaid";
    public static String COLUMN3 = "ID_guest";
    public static String COLUMN4 = "ID_house";

    public String queryFindAllPrepaidByOneProject(int idProject) {

        String query = "SELECT * FROM " + TABLENAME + " where " + COLUMN4 + " = " + idProject;

        return query;
    }

    public String queryFindPrepaidByOneGuest(int idGuest, int idProject) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + ", " + COLUMN4 + " from " + TABLENAME + " WHERE " + COLUMN3 + " = " + idGuest + " AND " + COLUMN4 + " = " +idProject;

        return query;
    }

    public String queryDeletePrepaidForOneGuest(int idGuest, int idProject) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN3 + "=" + idGuest + " AND " + COLUMN4 + " = " + idProject;

        return query;
    }

    public String queryInsertPrepaidForOneGuest(int idGuest, int idProject, double prepaid) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + "," + COLUMN4 + ") VALUES (? ,"  + prepaid  + "," + idGuest + "," + idProject + ")";

        return query;
    }

    public String queryUpdatePrepaidForOneGuest(int idGuest, int idProject, double prepaid) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + prepaid + " WHERE " + COLUMN3 + " = "  + idGuest + " AND " + COLUMN4 + " = " + idProject;

        return query;

    }
}
