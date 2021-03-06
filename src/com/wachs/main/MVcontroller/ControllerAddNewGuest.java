package com.wachs.main.MVcontroller;

import com.wachs.main.Models.ProjectModel;
import com.wachs.main.UserInterfaces.GUIDialogViews.DialogAddGuestView;
import com.wachs.main.UserInterfaces.GUIDialogViews.DialogMainGuiView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControllerAddNewGuest {

    private DialogAddGuestView viewAddNewGuest;
    private ProjectModel modelProject;
    private Stage stage;
    private String projectName;
    private String guestName;

    public ControllerAddNewGuest(DialogAddGuestView viewAddGuest, ProjectModel projectModel) {

        this.viewAddNewGuest = viewAddGuest;
        this.modelProject = projectModel;
        this.stage = this.viewAddNewGuest.display();
        this.viewAddNewGuest.buttonSaveActionEvent(new BtnSaveNewGuest());
    }

    private void setNewGuest() {

        projectName = viewAddNewGuest.getCb_SelectedProject();
        guestName = viewAddNewGuest.getTf_GuestNewName();

        //TODO wo soll jetzt das services Ding den INSERT Befehl reinmachen?
        //viewAddNewGuest.setNewGuest(projectName, guestName);
    }

    class BtnSaveNewGuest implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            new DialogMainGuiView().displayMainGui();
            setNewGuest();
            viewAddNewGuest.display().close();
        }
    }
}