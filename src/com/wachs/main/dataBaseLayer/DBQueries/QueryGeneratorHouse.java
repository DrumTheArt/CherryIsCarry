package com.wachs.main.dataBaseLayer.DBQueries;

public class QueryGeneratorHouse {

    public static final String TABLENAME = "TBL_HOUSE";
    public static String COLUMN1 = "PK_id";
    public static String COLUMN2 = "TXT_title";
    public static String COLUMN3 = "REAL_price";
    public static String COLUMN4 = "REAL_deposite";


    public String queryFindOneData(String name) {

        String query = "SELECT " + COLUMN1 + ", " + COLUMN2 + ", " + COLUMN3 + ", " + COLUMN4 + " from " + TABLENAME + " WHERE " + COLUMN2 + " = " + "'" + name + "'";

        return query;
    }

    public String queryDeleteData(String name) {

        String query = "DELETE FROM " + TABLENAME + " WHERE " + COLUMN2 + "=" + "'" + name + "'";

        return query;
    }

    public String queryReadAllData() {

        String query = "SELECT * FROM " + TABLENAME;

        return query;
    }

    public String queryInsertData(String name, double realPrice, double realDeposite) {

        String query = "INSERT INTO " + TABLENAME + "(" + COLUMN1 + "," + COLUMN2 + "," + COLUMN3 + "," + COLUMN4 + ") VALUES (? ," + "'" + name + "'" + "," + realPrice + "," + realDeposite + ")";

        return query;
    }

    public String queryUpdateData(int oldId, String newName, double newPrice, double newDeposite) {

        String query = "UPDATE " + TABLENAME + " SET " + COLUMN2 + " = " + "'" + newName + "'" + ", " + COLUMN3 + "=" + newPrice + "," + COLUMN4 + "=" + newDeposite + " WHERE " + COLUMN1 + " = "  + oldId;

        return query;
    }

}
