package com.wachs.main.viewLayerJavaFX.GUIDialogs;

import com.wachs.main.viewLayerJavaFX.GUIElementsGenerators.CreateGUIButton;
import com.wachs.main.viewLayerJavaFX.GUIElementsGenerators.CreateGUIHBox;
import com.wachs.main.viewLayerJavaFX.GUIElementsGenerators.CreateGUILabel;
import com.wachs.main.viewLayerJavaFX.GUIElementsGenerators.CreateGUITextfield;
import com.wachs.main.viewLayerJavaFX.GUISetup.GUINaming;
import com.wachs.main.viewLayerJavaFX.GUISetup.GUIProperties;
import com.wachs.main.viewLayerJavaFX.GUISetup.GUISourceIcons;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URISyntaxException;

public class DialogAddProject extends Application {

    //AllColumns
    private VBox verticalBox;

    // AllRows
    private HBox HBox_BTN_Regular;
    private HBox HBox_LB_AreaProjects;
    private HBox HBox_TF_AreaProjects;

    //AllButtons
    private Button btnSave;

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


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws URISyntaxException {

        primaryStage.setTitle("CherryIsCarry --- Add new Vacation");

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 0, 20, 20));

        //Holding all HBoxes
        verticalBox = new VBox();

        //First Row
        HBox_BTN_Regular = new CreateGUIHBox().CreateHBox(10, 20, 20, 10, 20);

        btnSave = new CreateGUIButton().createBtn(GUINaming.BTN_SAVE_NEWPROJECT, GUISourceIcons.sourceSaveData, GUIProperties.BTN_COLOR_BLUELIGHT, GUINaming.TT_BTN_SAVE_NEWPROJECT);

        HBox_BTN_Regular.getChildren().addAll(btnSave);
        HBox_BTN_Regular.setAlignment(Pos.BOTTOM_CENTER);

        //Third Row Labels & TextFields for GuestDetails
        GridForNewName_TF_LB = new GridPane();

        HBox_LB_AreaProjects = new CreateGUIHBox().CreateHBox(10, 10, 20, 0, 20);

        lb_ProjectNewName = new CreateGUILabel().createLabel(GUINaming.LB_PROJECTS_NEWPROJECTNAME, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_ProjectPrice = new CreateGUILabel().createLabel(GUINaming.LB_PROJECTS_PRICE, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_ProjectDeposite = new CreateGUILabel().createLabel(GUINaming.LB_PROJECTS_DEPOSITE, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);

        HBox_LB_AreaProjects.getChildren().addAll(lb_ProjectNewName, lb_ProjectPrice, lb_ProjectDeposite);

        HBox_TF_AreaProjects = new CreateGUIHBox().CreateHBox(10, 4, 20, 10, 20);

        tf_ProjectNewName = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_PROJECTS_NEWPROJECTNAME, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_ProjectPrice = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_PROJECTS_PRICE, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_ProjectDeposite = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_PROJECTS_DEPOSITE, GUIProperties.TEXTFIELD_DESIGN, true);

        HBox_TF_AreaProjects.setAlignment(Pos.BOTTOM_CENTER);
        HBox_TF_AreaProjects.getChildren().addAll(tf_ProjectNewName, tf_ProjectPrice, tf_ProjectDeposite);

        GridPane.setConstraints(HBox_LB_AreaProjects, 1, 1);
        GridPane.setConstraints(HBox_TF_AreaProjects, 1, 2);
        GridForNewName_TF_LB.setAlignment(Pos.BOTTOM_CENTER);
        GridForNewName_TF_LB.getChildren().addAll(HBox_LB_AreaProjects, HBox_TF_AreaProjects);

        verticalBox.getChildren().addAll(HBox_BTN_Regular, GridForNewName_TF_LB);

        Scene scene = new Scene(verticalBox, 450, 170);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
