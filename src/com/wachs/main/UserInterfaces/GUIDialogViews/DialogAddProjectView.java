package com.wachs.main.UserInterfaces.GUIDialogViews;

import com.wachs.main.UserInterfaces.GUIElementsGenerators.CreateGUIButton;
import com.wachs.main.UserInterfaces.GUIElementsGenerators.CreateGUIHBox;
import com.wachs.main.UserInterfaces.GUIElementsGenerators.CreateGUILabel;
import com.wachs.main.UserInterfaces.GUIElementsGenerators.CreateGUITextfield;
import com.wachs.main.UserInterfaces.GUISetup.GUINamingProperties;
import com.wachs.main.UserInterfaces.GUISetup.GUIProperties;
import com.wachs.main.UserInterfaces.GUISetup.GUISourceIcons;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class DialogAddProjectView {

    //Stage
    Stage dialogAddProject;

    //AllColumns
    private VBox verticalBox;

    // AllRows
    private HBox HBox_BTN_Regular;
    private HBox HBox_LB_AreaProjects;
    private HBox HBox_TF_AreaProjects;

    //AllButtons
    private Button btnSaveNewProject;

    //AllTextFields
    private TextField tf_ProjectNewName;
    private TextField tf_ProjectPrice;
    private TextField tf_ProjectDeposite;

    //AllLabelsGuest
    private Label lb_ProjectNewName;
    private Label lb_ProjectPrice;
    private Label lb_ProjectDeposite;

    //AllGrids
    private GridPane GridForNewName_TF_LB;


    public Stage display() {

        dialogAddProject = new Stage();

        dialogAddProject.setTitle("CherryIsCarry --- Add new Vacation");
        dialogAddProject.getIcons().add(new Image(GUISourceIcons.sourceAppIcon));
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 0, 20, 20));

        //Holding all HBoxes
        verticalBox = new VBox();

        //First Row
        HBox_BTN_Regular = new CreateGUIHBox().CreateHBox(10, 20, 20, 10, 20);

        btnSaveNewProject = new CreateGUIButton().createBtn(GUINamingProperties.BTN_SAVE_NEWPROJECT, GUISourceIcons.sourceSaveData, GUIProperties.BTN_COLOR_BLUELIGHT, GUINamingProperties.TT_BTN_SAVE_NEWPROJECT);

        HBox_BTN_Regular.getChildren().addAll(btnSaveNewProject);
        HBox_BTN_Regular.setAlignment(Pos.BOTTOM_CENTER);

        //Third Row Labels & TextFields for GuestDetails
        GridForNewName_TF_LB = new GridPane();

        HBox_LB_AreaProjects = new CreateGUIHBox().CreateHBox(10, 10, 20, 0, 20);

        lb_ProjectNewName = new CreateGUILabel().createLabel(GUINamingProperties.LB_PROJECTS_NEWPROJECTNAME, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_ProjectPrice = new CreateGUILabel().createLabel(GUINamingProperties.LB_PROJECTS_PRICE, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_ProjectDeposite = new CreateGUILabel().createLabel(GUINamingProperties.LB_PROJECTS_DEPOSITE, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);

        HBox_LB_AreaProjects.getChildren().addAll(lb_ProjectNewName, lb_ProjectPrice, lb_ProjectDeposite);

        HBox_TF_AreaProjects = new CreateGUIHBox().CreateHBox(10, 4, 20, 10, 20);

        tf_ProjectNewName = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_PROJECTS_NEWPROJECTNAME, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_ProjectPrice = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_PROJECTS_PRICE, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_ProjectDeposite = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_PROJECTS_DEPOSITE, GUIProperties.TEXTFIELD_DESIGN, true);

        HBox_TF_AreaProjects.setAlignment(Pos.BOTTOM_CENTER);
        HBox_TF_AreaProjects.getChildren().addAll(tf_ProjectNewName, tf_ProjectPrice, tf_ProjectDeposite);

        GridPane.setConstraints(HBox_LB_AreaProjects, 1, 1);
        GridPane.setConstraints(HBox_TF_AreaProjects, 1, 2);
        GridForNewName_TF_LB.setAlignment(Pos.BOTTOM_CENTER);
        GridForNewName_TF_LB.getChildren().addAll(HBox_LB_AreaProjects, HBox_TF_AreaProjects);

        verticalBox.getChildren().addAll(HBox_BTN_Regular, GridForNewName_TF_LB);

        Scene scene = new Scene(verticalBox, 450, 170);

        dialogAddProject.setScene(scene);
        dialogAddProject.show();

        return dialogAddProject;
    }

    public void buttonCloseActionEvent(EventHandler<ActionEvent> event){

        this.btnSaveNewProject.setOnAction(event);

    }

    public String getTf_ProjectNewName() {

        return String.valueOf(tf_ProjectNewName.getText());

    }

    public double getTf_ProjectPrice() {

        return Double.valueOf(String.valueOf(tf_ProjectPrice.getText()));

    }

    public double getTf_ProjectDeposite() {

        return Double.valueOf(String.valueOf(tf_ProjectDeposite.getText()));

    }
}