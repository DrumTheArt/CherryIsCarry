package com.wachs.main.controllerLayer;

import com.wachs.main.models.ProjectModel;
import com.wachs.main.views.GUIDialogViews.DialogAddProjectView;
import com.wachs.main.views.GUIDialogViews.DialogMainGuiView;
import javafx.stage.Stage;

public class ControllerAddNewProject {

    private DialogAddProjectView viewAddProject;
    private ProjectModel modelProject;
    private Stage stage;
    private String projectName;
    private double deposite;
    private double price;

    public ControllerAddNewProject(DialogAddProjectView theView, ProjectModel projectModel) {

        viewAddProject = theView;
        this.modelProject = projectModel;
        this.stage = viewAddProject.display();
    }

    public void setNewProject() {

        projectName = viewAddProject.getTf_ProjectNewName();
        deposite = viewAddProject.getTf_ProjectDeposite();
        price = viewAddProject.getTf_ProjectPrice();

        modelProject.setNewProject(projectName, deposite, price);
    }

    public void closeAction() {

        stage.setOnCloseRequest(event -> {

            new DialogMainGuiView().displayMainGui();
            stage.close();
        });

    }

    public void saveAction() {

        setNewProject();

        stage.setOnCloseRequest(event -> {

            modelProject.setNewProject(projectName, price, deposite);
            new DialogMainGuiView().displayMainGui();
            stage.close();
        });
    }
}