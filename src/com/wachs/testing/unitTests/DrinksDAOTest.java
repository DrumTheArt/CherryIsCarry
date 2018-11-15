package com.wachs.testing.unitTests;

public class DrinksDAOTest {

    /**
     public HouseDAO aHouse = new StubsHouseDAO();
     GuestDAO aGuest = new StubsGuestDAO();
     DrinksDAO aDrink = new StubsDrinksDAO();

     public void setUp() throws SQLException, ClassNotFoundException {

     aHouse.insertData("newHouse",200,300);

     }

     public void tearDown() throws SQLException, ClassNotFoundException {

     aHouse.deleteData("newHouse");

     }

     @Test public void test_InsertStatement_Should_Equals_To_InsertStatement() throws SQLException, ClassNotFoundException {

     //Arrange

     int pkHouse = aHouse.findOneData("newHouse").getPK_id();
     aGuest.insertData(pkHouse,"newGuest");
     int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

     //Act
     aDrink.insertData(idGuest, pkHouse,50);
     int nights_expected = aDrink.findOneData(idGuest, pkHouse).getNights();
     int nights_setted = 50;

     //Assert
     assertEquals(nights_expected,nights_setted);

     }

     /**
     @Test public void testDataBaseCall_ShouldNot_Be_Equals_To_InsertStatement() throws SQLException, ClassNotFoundException {

     //Arrange
     HouseDAO aHouse = new HouseDAOImpl();
     GuestDAO aGuest = new GuestDAOImpl();
     DrinksDAO aDrink = new DrinksDAOImpl();
     aHouse.deleteData("Namedeshauses");
     aHouse.insertData("Namedeshauses",200.0, 300.0);
     int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
     aGuest.insertData(pkHouse,"NeuerName");
     int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

     //Act
     aDrink.insertData(idGuest, pkHouse,50);
     int nights_expected = aDrink.findOneData(idGuest, pkHouse).getNights();
     int nights_setted = 51;

     //Assert
     assertNotEquals(nights_expected,nights_setted);

     }


     @Test public void testDeletedDataBaseValue_Should_Throw_SQLException() throws SQLException, ClassNotFoundException {

     //Arrange
     HouseDAO aHouse = new HouseDAOImpl();
     GuestDAO aGuest = new GuestDAOImpl();
     DrinksDAO aDrink = new DrinksDAOImpl();
     aHouse.deleteData("Namedeshauses");
     aHouse.insertData("Namedeshauses",200.0, 300.0);
     int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
     aGuest.insertData(pkHouse,"Neuername");
     int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

     //Act
     aDrink.insertData(idGuest, pkHouse,50);
     aDrink.deleteData(idGuest,pkHouse);


     //Assert
     Assertions.assertThrows(SQLException.class, () -> {
     aDrink.findOneData(idGuest,pkHouse);
     });


     }


     @Test public void testConstraints_On_DataBase_ShouldWork_When_Same_IdGuest_AND_IdHouse() throws SQLException, ClassNotFoundException {

     //Arrange
     HouseDAO aHouse = new HouseDAOImpl();
     GuestDAO aGuest = new GuestDAOImpl();
     DrinksDAO aDrink = new DrinksDAOImpl();
     aHouse.deleteData("Namedeshauses");
     aHouse.insertData("Namedeshauses",200.0, 300.0);
     int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
     aGuest.insertData(pkHouse,"Neuername");
     int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

     //Act
     aDrink.insertData(idGuest, pkHouse,50);


     //Assert
     Assertions.assertThrows(SQLException.class, () -> {
     aDrink.insertData(idGuest, pkHouse,50);
     });

     }


     @Test public void testReadAllData_ShouldNotBeNull() throws SQLException, ClassNotFoundException {

     //Arrange
     HouseDAO aHouse = new HouseDAOImpl();
     GuestDAO aGuest = new GuestDAOImpl();
     DrinksDAO aDrink = new DrinksDAOImpl();
     aHouse.deleteData("Namedeshauses");
     aHouse.insertData("Namedeshauses",200.0, 300.0);
     int pkHouse = aHouse.findOneData("Namedeshauses").getPK_id();
     aGuest.insertData(pkHouse,"Neuername");
     int idGuest = aGuest.findOneData("Neuername", pkHouse).getPK_id();

     //Act
     aDrink.insertData(idGuest, pkHouse,50);


     //Assert
     ArrayList<Drinks> listOfDrinks = new ArrayList<Drinks>();
     listOfDrinks = aDrink.readAllData();
     assertNotNull(listOfDrinks.get(0));

     }


     @Test public void testDeleteData_DataRowInDataBaseDoesNotExists() throws SQLException, ClassNotFoundException {

     //Arrange
     HouseDAO aHouse = new HouseDAOImpl();
     GuestDAO aGuest = new GuestDAOImpl();
     DrinksDAO aDrink = new DrinksDAOImpl();
     aHouse.deleteData("Namedeshauses");
     aHouse.insertData("Namedeshauses",200.0, 300.0);
     int idHouse = aHouse.findOneData("Namedeshauses").getPK_id();
     aGuest.insertData(idHouse,"Neuername");
     int idGuest = aGuest.findOneData("Neuername", idHouse).getPK_id();

     //Act
     aDrink.insertData(idGuest, idHouse,50);
     aDrink.updateData(idGuest, idHouse, 60);

     int newNightsCount = 60;
     int oldNightCount = aDrink.findOneData(idGuest,idHouse).getNights();

     //Assert
     assertEquals(newNightsCount, oldNightCount);


     }
**/
}