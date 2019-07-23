package com.wachs.main.dataAccess.dataAccessConfigurations.DBConfig;

import javax.swing.*;
import java.io.File;

public class DataBaseSource {

    //"/Users/sebastiansc/IdeaProjects/ADH/DataBase/adhApp.db");

    private static String DATABASEDRIVERNAME = "jdbc:sqlite:";
    private static File DATABASEPATH = new File("sources/database");
    private static String DATABASENAME = "adhDB.db";
    private static File TESTDATABASEPATH= new File("sources/testDatabase");
    private static String TESTDATABASENAME = "adhDB.db";

    public static String getDataBaseLink(){

        return DATABASEDRIVERNAME + DATABASEPATH.getAbsolutePath()+ "/" + DATABASENAME;
    }

    public static String getTestDataBaseLink(){

        return DATABASEDRIVERNAME + TESTDATABASEPATH.getAbsolutePath()+ "/" + TESTDATABASENAME;
    }


    public static void getInfoSourceLinkDataBase(){
        JOptionPane.showMessageDialog(null,"Die Datenbank dieser Anwendung " +
                "liegt unter: " + DATABASEPATH.getAbsolutePath()+ "/" + DATABASENAME);
    }

    public static void getInfoSourceLinkDTestataBase(){
        JOptionPane.showMessageDialog(null,"Die Datenbank dieser Anwendung " +
                "liegt unter: " + TESTDATABASEPATH.getAbsolutePath()+ "/" + TESTDATABASENAME);
    }
}