package com.wachs.testing.unitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        UtilClassTests.class,
        DrinksDAOTest.class,
        ExpenseDAOTest.class,
        FoodDAOTest.class,
        GuestDAOTest.class,
        HouseDAOTest.class,
        PrepaidDAOTest.class,
        StayDAOTest.class

        /**
        DrinksModelTest.class,
        ExpenseModelTest.class,
        FoodModelTest.class,
        GuestModelTest.class,
        AllGuestModelTest.class,
        HouseModelTest.class,
        PrepaidModelTest.class,
        StayModelTest.class
         **/
})

public class RunAllTests {

}





