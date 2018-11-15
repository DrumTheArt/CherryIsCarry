package com.wachs.main.dataBaseLayer.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDAO {

    //CRUD Create, Read, Update, Delete

    ArrayList readAllData() throws SQLException, ClassNotFoundException;

}