package com.wachs.main.controllerLayer;

import com.wachs.main.models.ProjectModel;
import com.wachs.main.views.GUIDialogViews.DialogAddProjectView;
import com.wachs.main.views.GUIDialogViews.DialogMainGuiView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControllerAddNewProject {

    private DialogAddProjectView viewAddProject;
    private ProjectModel modelProject;
    private Stage stage;
    private String projectName;
    private double deposite;
    private double price;

    public ControllerAddNewProject(DialogAddProjectView viewAddProject, ProjectModel projectModel) {

        this.viewAddProject = viewAddProject;
        this.modelProject = projectModel;
        this.stage = this.viewAddProject.display();
        this.viewAddProject.buttonCloseActionEvent(new BtnSaveNewProject());
    }

    private void setNewProject() {

        projectName = viewAddProject.getTf_ProjectNewName();
        deposite = viewAddProject.getTf_ProjectDeposite();
        price = viewAddProject.getTf_ProjectPrice();

        modelProject.setNewProject(projectName, deposite, price);
    }

    class BtnSaveNewProject implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            new DialogMainGuiView().displayMainGui();
            setNewProject();
            viewAddProject.display().close();
        }
    }
}