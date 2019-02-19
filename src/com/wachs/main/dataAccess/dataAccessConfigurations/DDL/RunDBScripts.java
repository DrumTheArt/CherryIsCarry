package com.wachs.main.dataAccess.dataAccessConfigurations.DDL;

import com.wachs.testing.dbTestConfig.InsertValuesDBTestData;

import java.io.IOException;
import java.sql.SQLException;

public class RunDBScripts {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        ITableDBScript createScript = new DropAndCreateTableDB();
        InsertValuesDBTestData insertValuesTest = new InsertValuesDBTestData();

        createScript.executeQuery();
        insertValuesTest.executeQuery();

    }
}
