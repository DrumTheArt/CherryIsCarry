package com.wachs.main.dataAcess.dataAccessConfigurations.DDL;

import java.io.IOException;
import java.sql.SQLException;

public interface ITableDBScript {

    void executeQuery() throws IOException, SQLException, ClassNotFoundException;
}