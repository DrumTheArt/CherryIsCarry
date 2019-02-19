package com.wachs.main.dataAccess.models;

public class GuestModel {

    /**
    private GuestDAO newDAO;
    private Guest searchedGuest;

    //findDrinksByOneGuest(String name, int id_house)

    GuestModel(String guestName, int id_house) throws SQLException, IOException, ClassNotFoundException {

        createModel(guestName, id_house);
    }

    private Guest createModel(String guestName, int id_house) throws SQLException, IOException, ClassNotFoundException {

        newDAO = new GuestDAOImpl();
        searchedGuest = newDAO.findDrinksByOneGuest(guestName, id_house);

        return searchedGuest;
    }

    public int getPK_id(){

        return searchedGuest.getPK_id();

    }

    public String getprojectTitle(){

        return searchedGuest.getGuestName();

    }

    public double getPrice(){

        return searchedGuest.getProjectPrice();

    }

    public double getDeposite(){

        return searchedGuest.getProjectDeposite();

    }
     **/
}
