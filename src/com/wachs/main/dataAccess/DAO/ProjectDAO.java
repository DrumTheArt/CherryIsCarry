package com.wachs.main.dataAccess.DAO;

import com.wachs.main.businessObjects.Project;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProjectDAO {

    Project findOneProject(String name);

    ArrayList findAllProjects();

    void insertProject(String projectName, double projectPrice, double projectDeposite);

    void updateProject(int oldId, String newProjectName, double projectPrice, double projectDeposite);

    void deleteProject(String projectName);
}
