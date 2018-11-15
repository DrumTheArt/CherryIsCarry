package com.wachs.testing.dbTestConfig;

import javax.swing.*;
import java.io.File;

public class DataBaseSourceForTest {


    //"/Users/sebastiansc/IdeaProjects/CherryIsCarry/sources/testdatabase/testDB.db");

    private static String DATABASEDRIVERNAME = "jdbc:sqlite:";
    private static File DATABASEPATH = new File("sources/testdatabase");
    private static String DATABASENAME = "testDB.db";

    public static String getTestDataBaseLink() {

        return DATABASEDRIVERNAME + DATABASEPATH.getAbsolutePath() + "/" + DATABASENAME;
    }


    public static void getInfoSourceLinkTestDataBase() {
        JOptionPane.showMessageDialog(null, "Die Test-Datenbank dieser Anwendung " +
                "liegt unter: " + DATABASEPATH.getAbsolutePath() + "/" + DATABASENAME);
    }

}
