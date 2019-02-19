package com.wachs.main.dataAccess.dBQueryGenerators;

public class QueryGeneratorStay {

    public static final String TABLENAME = "TBL_STAY";
    public static String COLUMN1 = "FK_id";
    public static String COLUMN2 = "INT_nights";
    public static String COLUMN3 = "ID_guest";
    public static String COLUMN4 = "ID_house";

    public String queryFindStayByOneGuest(int idGuest, int idProject) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + ", " + COLUMN4 + " from " + TABLENAME + " WHERE " + COLUMN3 + " = " + idGuest + " AND " + COLUMN4 + " = " +idProject;

        return query;
    }

    public String queryInsertStayForOneGuest(int idGuest, int idProject, int nights) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + "," + COLUMN4 + ") VALUES (? ," + "'" + nights + "'" + "," + idGuest + "," + idProject + ")";

        return query;
    }

    public String queryDeleteStayForOneGuest(int idGuest, int idProject) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN3 + "=" + idGuest + " AND " + COLUMN4 + " = " + idProject;

        return query;
    }

    public String queryUpdateStayForOneGuest(int idGuest, int idProject, int newNights) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + newNights + " WHERE " + COLUMN3 + " = "  + idGuest + " AND " + COLUMN4 + " = " + idProject;

        return query;
    }

    public String queryFindAllStayByOneProject(int idProject) {

        String query = "SELECT * FROM " + TABLENAME + " where " + COLUMN4 + " = " + idProject ;

        return query;
    }

}
