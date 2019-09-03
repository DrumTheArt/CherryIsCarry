package com.wachs.main.Models;

import com.wachs.main.BusinessEntities.Guest;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class AllGuestsDropDownMenuModel {


    //TODO
    //ACHTUNG: MOdels haben keine Parents + benutzen nur Service
    public AllGuestsDropDownMenuModel() {

    }

    //Problem -> alle Gäste angezeigt, anstatt  nur die, die auf die Projektnummer passen
    public ObservableList<String> getAllProjects() {

        ArrayList<Guest> listGuests = null;
/**
 try {
 listGuests = new GuestService().fetchAllOneProject();
 } catch (SQLException e) {
 e.printStackTrace();
 } catch (ClassNotFoundException e) {
 e.printStackTrace();
 } catch (IOException e) {
 e.printStackTrace();
 }

 ObservableList<String> content = FXCollections.observableArrayList();


 for(Guest e:listGuests){

 content.add(e.getGuestName());
 }
 **/
        return null;

    }

}
