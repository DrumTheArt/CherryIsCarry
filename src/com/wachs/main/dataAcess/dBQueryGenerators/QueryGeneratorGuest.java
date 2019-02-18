package com.wachs.main.dataAcess.dBQueryGenerators;

public class QueryGeneratorGuest {

    public static final String TABLENAME = "TBL_GUEST";
    public static String COLUMN1 = "PK_id";
    public static String COLUMN2 = "ID_house";
    public static String COLUMN3 = "TXT_name";


    public String queryFindOneGuestByOneProject(String name, int idProject) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + " from " + TABLENAME + " WHERE " + COLUMN3 + " = " + "'" + name + "'" + " AND " + COLUMN2 + " = " + idProject;

        return query;
    }

    public String queryFindAllGuestsByOneProject(int idProject) {

        String query = "SELECT * FROM " + TABLENAME + " WHERE " + COLUMN2 + " = " + idProject;

        return query;
    }

    public String queryInsertGuestForOneProject(int idProject, String name) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + ") VALUES (? ," + idProject + "," + "'" + name + "'" + ")";

        return query;
    }

    public String queryUpdateGuestForOneProject(int oldId, String newName, int idProject) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN3 + " = " + "'" + newName + "'" + " WHERE " + COLUMN1 + "=" + oldId + " AND " + COLUMN2 + " =" + idProject;

        return query;
    }

    public String queryDeleteGuestForOneProject(String name, int idProject) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN3 + "=" + "'" + name + "'" + " AND " + COLUMN2 + "=" + idProject;

        return query;
    }

}
