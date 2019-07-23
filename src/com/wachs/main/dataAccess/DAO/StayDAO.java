package com.wachs.main.dataAccess.DAO;

import com.wachs.main.POJO.Stay;

import java.util.ArrayList;

public interface StayDAO {

    Stay findStayByOneGuest(int idGuest, int idProject);

    ArrayList findAllStayByOneProject(int idProject);

    void updateStayForOneGuest(int idGuest, int idProject, int newNights);

    void deleteStayForOneGuest(int idGuest, int idProject);

    void insertStayForOneGuest(int idGuest, int idProject, int nights);
}
