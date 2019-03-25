package com.wachs.main.views.GUIDialogViews;

import com.wachs.main.models.AllProjectsDropDownMenuModel;
import com.wachs.main.views.GUIElementsGenerators.*;
import com.wachs.main.views.GUISetup.GUINamingProperties;
import com.wachs.main.views.GUISetup.GUIProperties;
import com.wachs.main.views.GUISetup.GUISourceIcons;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class DialogAddGuestView {


    //AllColumns
    private VBox verticalBox;

    // AllRows
    private HBox HBox_BTN_Save;
    private HBox HBox_LB_AreaNewGuestName;
    private HBox HBox_TF_AreaNewGuestName;

    //AllButtons
    private Button btnSaveNewGuest;

    //AllTextFields
    private TextField tf_GuestNewName;

    //ComboBox
    private ComboBox cb_SelectedProject;

    //AllModelsforComboBox
    private ObservableList<String> comboBoxProjectModel;

    //AllLabelsGuest
    private Label lb_GuestNewName;
    private Label lb_Guest_SelectedProject;

    //AllGrids
    private GridPane GridForNewGuestName_LB_TF;


    public Stage display(){

        Stage dialogAddGuest = new Stage();

        dialogAddGuest.setTitle("CherryIsCarry --- Add new Guest");
        dialogAddGuest.getIcons().add(new Image(GUISourceIcons.sourceAppIcon));
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 0, 20, 20));

        //Holding all HBoxes
        verticalBox = new VBox();

        //First Row
        HBox_BTN_Save = new CreateGUIHBox().CreateHBox(10, 20, 20, 10, 20);

        btnSaveNewGuest = new CreateGUIButton().createBtn(GUINamingProperties.BTN_SAVE_NEWGUEST, GUISourceIcons.sourceSaveData, GUIProperties.BTN_COLOR_BLUELIGHT, GUINamingProperties.TT_BTN_SAVE_GUEST);

        HBox_BTN_Save.getChildren().addAll(btnSaveNewGuest);
        HBox_BTN_Save.setAlignment(Pos.BOTTOM_CENTER);

        //Third Row Labels & TextFields for GuestDetails
        GridForNewGuestName_LB_TF = new GridPane();

        HBox_LB_AreaNewGuestName = new CreateGUIHBox().CreateHBox(10, 10, 20, 0, 20);

        lb_GuestNewName = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_NEWGUESTNAME, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);

        lb_Guest_SelectedProject = new CreateGUILabel().createLabel(GUINamingProperties.TT_LB_PROJECTS_SELECT, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);

        HBox_LB_AreaNewGuestName.getChildren().addAll(lb_GuestNewName, lb_Guest_SelectedProject);

        HBox_TF_AreaNewGuestName = new CreateGUIHBox().CreateHBox(10, 4, 20, 10, 20);

        tf_GuestNewName = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_NEWGUESTNAME, GUIProperties.TEXTFIELD_DESIGN, true);

        comboBoxProjectModel = new AllProjectsDropDownMenuModel().getGetAllProjects();
        cb_SelectedProject = new CreateGUIComboBox().createComboBox(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_PROJECTS_SELECTED, comboBoxProjectModel);

        HBox_TF_AreaNewGuestName.setAlignment(Pos.BOTTOM_CENTER);
        HBox_TF_AreaNewGuestName.getChildren().addAll(tf_GuestNewName, cb_SelectedProject);

        GridPane.setConstraints(HBox_LB_AreaNewGuestName, 1, 1);
        GridPane.setConstraints(HBox_TF_AreaNewGuestName, 1, 2);
        GridForNewGuestName_LB_TF.setAlignment(Pos.BOTTOM_CENTER);
        GridForNewGuestName_LB_TF.getChildren().addAll(HBox_LB_AreaNewGuestName, HBox_TF_AreaNewGuestName);

        verticalBox.getChildren().addAll(HBox_BTN_Save, GridForNewGuestName_LB_TF);

        Scene scene = new Scene(verticalBox, 350, 170);

        dialogAddGuest.setScene(scene);
        dialogAddGuest.show();

        return dialogAddGuest;

    }

    public void buttonSaveActionEvent(EventHandler<ActionEvent> event) {

        this.btnSaveNewGuest.setOnAction(event);

    }

    public String getTf_GuestNewName() {
        return String.valueOf(tf_GuestNewName);
    }

    public String getCb_SelectedProject() {
        return cb_SelectedProject.getValue().toString();
    }

    public void setNewGuest(String projectName, String guestName) {


    }

}