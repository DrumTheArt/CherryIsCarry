package com.wachs.testing.unitTests;

public class HouseDAOTest {

    /**
    @Test
    public void testInsertData_Should_be_NotNull() throws SQLException, ClassNotFoundException {


        //Arrange
        HouseDAO toFindGuest = new HouseDAOImpl();

        //Act
        toFindGuest.deleteData("NeuesHaus");
        toFindGuest.insertData("NeuesHaus", 300.0, 200.0);

        //Assert
        assertNotNull(toFindGuest);

    }


    @Test
    public void testTwo_Equals_HouseObjects_Should_Not_Be_Allowed_toSave() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO toFindHouse = new HouseDAOImpl();

        //Act

        toFindHouse.deleteData("NeuesHaus");
        toFindHouse.insertData("NeuesHaus", 300., 200.0);

        //Assert
        Assertions.assertThrows(SQLException.class, () -> {
            toFindHouse.insertData("NeuesHaus", 300.0, 200.0);
        });

    }

    @Test
    public void testReadAllData_Should_Be_same_Amount_as_Houselist() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO daoObject = new HouseDAOImpl();
        ArrayList<House> listHouse = daoObject.readAllData();

        //Act
        IDbColumnValidator countRows = new TblHouseColumnValidate();
        int countHouseListObjects = ((ArrayList) listHouse).size();
        System.out.println("Count objects: " + countHouseListObjects);
        int countHouseDataBase = countRows.getCountRow();
        System.out.println("Count DB-Tupel: " + countHouseDataBase);

        //Assert
        assertEquals(countHouseListObjects, countHouseDataBase);

    }

    @Test
    public void testReadAllData_Should_BeNot_Same_Amount_when_Dropping_One_Element() throws SQLException, ClassNotFoundException {

        //Arrange
        GuestDAO daoObject = new GuestDAOImpl();
        ArrayList<House> listHouse = daoObject.readAllData();

        //Act
        IDbColumnValidator countRows = new TblGuestColumnValidate();
        listHouse.remove(0);
        int countGuestListObjects = ((ArrayList) listHouse).size();
        int countGuestDataBase = countRows.getCountRow();

        //Assert
        assertNotEquals(countGuestListObjects, countGuestDataBase);

    }

    @Test
    public void testUpdateData() throws SQLException, ClassNotFoundException {

        //Arrange
        HouseDAO daoObject = new HouseDAOImpl();
        daoObject.deleteData("NeuesHaus");
        daoObject.deleteData("NeuesHaus2");
        daoObject.insertData("NeuesHaus2", 300.0, 200.0);


        //Act
        String oldName = daoObject.findOneData("NeuesHaus2").getTXT_name();
        int oldPkId = daoObject.findOneData("NeuesHaus2").getPK_id();
        daoObject.updateData(oldPkId, "NeuesHaus");
        String newName = daoObject.findOneData("NeuesHaus").getTXT_name();
        int newPkId = daoObject.findOneData("NeuesHaus").getPK_id();

        //Assert
        assertEquals(oldPkId, newPkId);
        assertNotEquals(oldName, newName);

    }

    @Test
    public void testDeleteData_DataRowInDataBaseDoesNotExists() throws SQLException, ClassNotFoundException {

    HouseDAO testing = new HouseDAOImpl();



        Assertions.assertThrows(SQLException.class, () -> {
    House testDoNotConvertIfStringIsAllright = (House) testing.findOneData("ThisStringWillBeNeverInTheDataBaseISwearForeverForever1233213123123123");
        });


    }


    @Test
    public void testInsertData_Name_And_idHouse_already_exists() throws SQLException, SQLiteException, ClassNotFoundException {

    HouseDAO testing = new HouseDAOImpl();
    testing.deleteData("NeuesHouse22222323");
    testing.insertData("NeuesHouse22222323", 300.0, 200.0);

        Assertions.assertThrows(SQLiteException.class, () -> {
    testing.insertData("NeuesHouse22222323", 300.0, 200.0);
        });
    }

    @Test
    public void testDeleteData_Should_be_Deleting_A_DatabaseObject() throws SQLException, SQLiteException, ClassNotFoundException {

    HouseDAO testing = new HouseDAOImpl();
    testing.deleteData("NeuesHaus");
    testing.insertData("NeuesHaus", 300.00, 200.00);
    House firstTry = (House) testing.findOneData("NeuesHaus");

        assertNotNull(firstTry);

    testing.deleteData("NeuesHaus");

        Assertions.assertThrows(SQLException.class, () -> {
    testing.findOneData("NeuesHaus");
        });

    }
    **/
}