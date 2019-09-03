package com.wachs.main.DataAccess.services;

import com.wachs.main.BusinessEntities.Stay;

import java.util.ArrayList;

public interface IStayService {

    Stay fetchStayOneGuest(int idGuest, int idProject);

    ArrayList fetchAllStayOneProject(int idProject);

    void updateStayOneGuest(int idGuest, int idProject, int newNights);

    void deleteStayOneGuest(int idGuest, int idProject);

    void insertStayOneGuest(int idGuest, int idProject, int nights);
}
