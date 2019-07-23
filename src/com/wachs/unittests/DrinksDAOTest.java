package com.wachs.unittests;

import com.wachs.main.dataAccess.DAO.DrinksDAO;
import com.wachs.main.dataAccess.DAO.DrinksDAOImpl;
import org.junit.Test;

public class DrinksDAOTest {


    @Test
    public void findDrinksByOneGuest_Should_Return_DrinkObject_When_idGuestAndIdProjectExist() {

        DrinksDAO newDao = new DrinksDAOImpl();
        newDao.findDrinksOneGuest(1, 1);

    }

}