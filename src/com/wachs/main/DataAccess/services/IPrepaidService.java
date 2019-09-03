package com.wachs.main.DataAccess.services;

import com.wachs.main.BusinessEntities.Prepaid;

import java.util.ArrayList;

public interface IPrepaidService {

    ArrayList fetchAllPrepaidOneProject(int idProject);

    Prepaid fetchPrepaidOneGuest(int idGuest, int idProject);

    void insertPrepaidOneGuest(int idGuest, int idProject, double prepaid);

    void updatePrepaidOneGuest(int idGuest, int idProject, double newPrepaid);

    void deletePrepaidOneGuest(int idGuest, int idProject);
}
