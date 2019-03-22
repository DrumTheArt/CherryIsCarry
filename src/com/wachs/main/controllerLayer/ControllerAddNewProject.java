package com.wachs.main.controllerLayer;

import com.wachs.main.models.ProjectModel;
import com.wachs.main.views.GUIDialogViews.DialogAddProjectView;
import com.wachs.main.views.GUIDialogViews.DialogMainGuiView;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.awt.event.ActionListener;

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

        //this.viewAddProject.buttonCloseActionEvent(new CloseEvent());
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

    class CloseEvent implements EventHandler<ActionEvent> {


        @Override
        public void handle(ActionEvent event) {

            new DialogMainGuiView().displayMainGui();
            viewAddProject.display().close();
        }
    }
}