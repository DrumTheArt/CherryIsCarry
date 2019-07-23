package com.wachs.main.dataAccess.dBQueryGenerators;

public class QueryGeneratorProject {

    public static final String TABLENAME = "TBL_PROJECT";
    public static String COLUMN1 = "PK_id";
    public static String COLUMN2 = "TXT_title";
    public static String COLUMN3 = "REAL_projectPrice";
    public static String COLUMN4 = "REAL_projectDeposite";

    public String fetchQueryOneProject(String projectName) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + ", " + COLUMN4 + " from " + TABLENAME + " WHERE " + COLUMN2 + " = " + "'" + projectName + "'";

        return query;
    }

    public String deleteQueryOneProject(String projectName) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN2 + "=" + "'" + projectName + "'";

        return query;
    }

    public String FetchQueryAllProjects() {

        String query = "SELECT * FROM " + TABLENAME;

        return query;
    }

    public String insertQueryOneProject(String projectName, double projectPrice, double projectDeposite) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + "," + COLUMN4 + ") VALUES (? ," + "'" + projectName + "'" + "," + projectPrice + "," + projectDeposite + ")";

        return query;
    }

    public String updateQueryOneProject(int oldId, String projectNewName, double projectNewPrice, double projectNewDeposite) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + "'" + projectNewName + "'" + ", " + COLUMN3 + "=" + projectNewPrice + "," + COLUMN4 + "=" + projectNewDeposite + " WHERE " + COLUMN1 + " = "  + oldId;

        return query;
    }

    @Override
    public String toString() {

        return this.getClass().getName();
    }
}