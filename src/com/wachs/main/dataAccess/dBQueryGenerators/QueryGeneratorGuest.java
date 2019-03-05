package com.wachs.main.dataAccess.dBQueryGenerators;

public class QueryGeneratorGuest {

    public static final String TABLENAME = "TBL_GUEST";
    public static String COLUMN1 = "PK_id";
    public static String COLUMN2 = "ID_project";
    public static String COLUMN3 = "TXT_guestName";


    public String queryFindOneGuestByOneProject(String guestName, int idProject) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + " from " + TABLENAME + " WHERE " + COLUMN3 + " = " + "'" + guestName + "'" + " AND " + COLUMN2 + " = " + idProject;

        return query;
    }

    public String queryFindAllGuestsByOneProject(int idProject) {

        String query = "SELECT * FROM " + TABLENAME + " WHERE " + COLUMN2 + " = " + idProject;

        return query;
    }

    public String queryInsertGuestForOneProject(String guestName, int idProject) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + ") VALUES (? ," + idProject + "," + "'" + guestName + "'" + ")";

        return query;
    }

    public String queryUpdateGuestForOneProject(int oldId, String guestNewName, int idProject) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN3 + " = " + "'" + guestNewName + "'" + " WHERE " + COLUMN1 + "=" + oldId + " AND " + COLUMN2 + " =" + idProject;

        return query;
    }

    public String queryDeleteGuestForOneProject(String guestName, int idProject) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN3 + "=" + "'" + guestName + "'" + " AND " + COLUMN2 + "=" + idProject;

        return query;
    }
}
