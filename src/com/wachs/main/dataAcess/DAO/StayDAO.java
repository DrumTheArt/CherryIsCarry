package com.wachs.main.dataAcess.DAO;

import com.wachs.main.businessObjects.Stay;

import java.util.ArrayList;

public interface StayDAO {

    Stay findStayByOneGuest(int idGuest, int idProject);

    ArrayList findAllStayByOneProject(int idProject);

    void updateStayForOneGuest(int idGuest, int idProject, int newNights);

    void deleteStayForOneGuest(int idGuest, int idProject);

    void insertStayForOneGuest(int idGuest, int idProject, int nights);
}
