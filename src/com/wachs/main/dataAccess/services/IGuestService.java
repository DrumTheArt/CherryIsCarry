package com.wachs.main.dataAccess.services;

import com.wachs.main.POJO.Guest;

import java.util.ArrayList;

public interface IGuestService {

    Guest fetchOneGuestOneProject(String name, int idProject);

    ArrayList fetchAllGuestsOneProject(int idProject);

    //For INSERT, UPDATE or DELETE use the executeUpdate() and for select use the executeQuery() which returns the ResultSet.
    void insertGuestOneProject(int idProject, String name);

    void updateGuestOneProject(int oldId, String name, int idProject);

    void deleteGuestOneProject(String name, int idProject);

}
