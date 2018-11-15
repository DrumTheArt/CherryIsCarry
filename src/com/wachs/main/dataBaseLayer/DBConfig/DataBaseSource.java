package com.wachs.main.dataBaseLayer.DBConfig;

import javax.swing.*;
import java.io.File;

public class DataBaseSource {

    //"/Users/sebastiansc/IdeaProjects/ADH/DataBase/adhApp.db");

    private static String DATABASEDRIVERNAME = "jdbc:sqlite:";
    private static File DATABASEPATH = new File("sources/database");
    private static String DATABASENAME = "adhDB.db";

    public static String getDataBaseLink(){

        return DATABASEDRIVERNAME + DATABASEPATH.getAbsolutePath()+ "/" + DATABASENAME;
    }


    public static void getInfoSourceLinkDataBase(){
        JOptionPane.showMessageDialog(null,"Die Datenbank dieser Anwendung " +
                "liegt unter: " + DATABASEPATH.getAbsolutePath()+ "/" + DATABASENAME);
    }

}

