package com.wachs.main.dataAccess.services;

import com.wachs.main.POJO.Project;

import java.util.ArrayList;

public interface IProjectService {

    Project fetchOneProject(String name);

    ArrayList fetchAllProjects();

    void insertProject(String projectName, double projectPrice, double projectDeposite);

    void updateProject(int oldId, String newProjectName, double projectPrice, double projectDeposite);

    void deleteProject(String projectName);
}
