package com.wachs.testing.unitTests;

public class FoodDAOTest {

    /**
    @Test
    public void testDataBaseCall_Should_Be_Equals_To_InsertStatement() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        FoodDAO aFood = new FoodDAOImpl();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse,"Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aFood.insertData(idGuest, pkHouse,50);
        int nights_expected = aFood.findOneData(idGuest, pkHouse).getNights();
        int nights_setted = 50;

        //Assert
        assertEquals(nights_expected,nights_setted);

    }


    @Test
    public void testDataBaseCall_ShouldNot_Be_Equals_To_InsertStatement() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        FoodDAO aFood = new FoodDAOImpl();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse,"Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aFood.insertData(idGuest, pkHouse,50);
        int nights_expected = aFood.findOneData(idGuest, pkHouse).getNights();
        int nights_setted = 51;

        //Assert
        assertNotEquals(nights_expected,nights_setted);

    }


    @Test
    public void testDeletedDataBaseValue_Should_Throw_SQLException() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        FoodDAO aFood = new FoodDAOImpl();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse,"Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aFood.insertData(idGuest, pkHouse,50);
        aFood.deleteData(idGuest,pkHouse);

        /**
        //Assert
        Assertions.assertThrows(SQLException.class, () -> {
            aFood.findOneData(idGuest,pkHouse);
        });


    }


    @Test
    public void testConstraints_On_DataBase_ShouldWork_When_Same_IdGuest_AND_IdHouse() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        FoodDAO aFood = new FoodDAOImpl();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse,"Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aFood.insertData(idGuest, pkHouse,50);

        //Assert



        Assertions.assertThrows(SQLException.class, () -> {
            aFood.insertData(idGuest, pkHouse,50);
        });


    }


    @Test
    public void testReadAllData_ShouldNotBeNull() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        FoodDAO aFood = new FoodDAOImpl();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses",200.0, 300.0);
        int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(pkHouse,"Neuername");
        int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

        //Act
        aFood.insertData(idGuest, pkHouse,50);

/**
        //Assert
        ArrayList<Drinks> listOfDrinks = new ArrayList<Drinks>();
        listOfDrinks = aFood.readAllData();
        assertNotNull(listOfDrinks.get(0));

    }


    @Test
    public void testDeleteData_DataRowInDataBaseDoesNotExists() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO aHouse = new HouseDAOImpl();
        GuestDAO aGuest = new GuestDAOImpl();
        FoodDAO aFood = new FoodDAOImpl();
        aHouse.deleteData("Namedeshauses");
        aHouse.insertData("Namedeshauses",200.0, 300.0);
        int idHouse = aHouse.findOneData("Namedeshauses").getPK_id();
        aGuest.insertData(idHouse,"Neuername");
        int idGuest = aGuest.findOneData("Neuername", idHouse).getPK_id();

        //Act
        aFood.insertData(idGuest, idHouse,50);
        aFood.updateData(idGuest, idHouse, 60);

        int newNightsCount = 60;
        int oldNightCount = aFood.findOneData(idGuest,idHouse).getNights();

        //Assert
        assertEquals(newNightsCount, oldNightCount);


    }
     **/
}