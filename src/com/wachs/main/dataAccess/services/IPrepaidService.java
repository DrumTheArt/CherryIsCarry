package com.wachs.main.dataAccess.services;

import com.wachs.main.POJO.Prepaid;

import java.util.ArrayList;

public interface IPrepaidService {

    ArrayList fetchAllPrepaidOneProject(int idProject);

    Prepaid fetchPrepaidOneGuest(int idGuest, int idProject);

    void insertPrepaidOneGuest(int idGuest, int idProject, double prepaid);

    void updatePrepaidOneGuest(int idGuest, int idProject, double newPrepaid);

    void deletePrepaidOneGuest(int idGuest, int idProject);
}
