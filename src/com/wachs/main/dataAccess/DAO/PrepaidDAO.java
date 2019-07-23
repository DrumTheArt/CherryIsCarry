package com.wachs.main.dataAccess.DAO;

import com.wachs.main.POJO.Prepaid;

import java.util.ArrayList;

public interface PrepaidDAO {

    ArrayList findAllPrepaidByOneProject(int idProject);

    Prepaid findPrepaidByOneGuest(int idGuest, int idProject);

    void insertPrepaidForOneGuest(int idGuest, int idProject, double prepaid);

    void updatePrepaidForOneGuest(int idGuest, int idProject, double newPrepaid);

    void deletePrepaidForOneGuest(int idGuest, int idProject);
}
