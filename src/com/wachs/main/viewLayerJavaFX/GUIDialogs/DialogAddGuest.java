package com.wachs.main.viewLayerJavaFX.GUIDialogs;

import com.wachs.main.viewLayerJavaFX.GUIElementsGenerators.*;
import com.wachs.main.viewLayerJavaFX.GUISetup.GUINaming;
import com.wachs.main.viewLayerJavaFX.GUISetup.GUIProperties;
import com.wachs.main.viewLayerJavaFX.GUISetup.GUISourceIcons;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URISyntaxException;

public class DialogAddGuest extends Application {

    //AllColumns
    private VBox verticalBox;

    // AllRows
    private HBox HBox_BTN_Save;
    private HBox HBox_LB_AreaNewGuestName;
    private HBox HBox_TF_AreaNewGuestName;

    //AllButtons
    private Button btnSave;

    //AllTextFields
    private TextField tf_GuestNewName;

    //ComboBox
    private ComboBox cb_SelectedProject;

    //AllLabelsGuest
    private Label lb_GuestNewName;
    private Label lb_Guest_SelectedProject;

    //AllGrids
    private GridPane GridForNewGuestName_LB_TF;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws URISyntaxException {

        primaryStage.setTitle("CherryIsCarry --- Add new Guest");

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 0, 20, 20));

        //Holding all HBoxes
        verticalBox = new VBox();

        //First Row
        HBox_BTN_Save = new CreateGUIHBox().CreateHBox(10, 20, 20, 10, 20);

        btnSave = new CreateGUIButton().createBtn(GUINaming.BTN_SAVE_NEWGUEST, GUISourceIcons.sourceSaveData, GUIProperties.BTN_COLOR_BLUELIGHT, GUINaming.TT_BTN_SAVE_GUEST);

        HBox_BTN_Save.getChildren().addAll(btnSave);
        HBox_BTN_Save.setAlignment(Pos.BOTTOM_CENTER);

        //Third Row Labels & TextFields for GuestDetails
        GridForNewGuestName_LB_TF = new GridPane();

        HBox_LB_AreaNewGuestName = new CreateGUIHBox().CreateHBox(10, 10, 20, 0, 20);

        lb_GuestNewName = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_NEWGUESTNAME, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);

        lb_Guest_SelectedProject = new CreateGUILabel().createLabel(GUINaming.TT_LB_PROJECTS_SELECT, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);

        HBox_LB_AreaNewGuestName.getChildren().addAll(lb_GuestNewName, lb_Guest_SelectedProject);

        HBox_TF_AreaNewGuestName = new CreateGUIHBox().CreateHBox(10, 4, 20, 10, 20);


        tf_GuestNewName = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_NEWGUESTNAME, GUIProperties.TEXTFIELD_DESIGN, true);

        cb_SelectedProject = new CreateGUIComboBox().createComboBox(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_PROJECTS_SELECTED);

        HBox_TF_AreaNewGuestName.setAlignment(Pos.BOTTOM_CENTER);
        HBox_TF_AreaNewGuestName.getChildren().addAll(tf_GuestNewName, cb_SelectedProject);

        GridPane.setConstraints(HBox_LB_AreaNewGuestName, 1, 1);
        GridPane.setConstraints(HBox_TF_AreaNewGuestName, 1, 2);
        GridForNewGuestName_LB_TF.setAlignment(Pos.BOTTOM_CENTER);
        GridForNewGuestName_LB_TF.getChildren().addAll(HBox_LB_AreaNewGuestName, HBox_TF_AreaNewGuestName);

        verticalBox.getChildren().addAll(HBox_BTN_Save, GridForNewGuestName_LB_TF);

        Scene scene = new Scene(verticalBox, 350, 170);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

}
