package com.wachs.main.viewLayerJavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URISyntaxException;

public class SecondMain extends Application {

    //AllColumns
    private VBox verticalBox;

    // AllRows
    private HBox HBox_Buttons;
    private HBox HBox_Selector;
    private HBox HBox_LabelFieldsGuests;
    private HBox HBox_TextFieldsGuests;
    private HBox HBox_LabelFieldsAll;
    private HBox HBox_TextFieldsAll;

    //AllButtons
    private Button btnAddProject;
    private Button btnAddGuest;
    private Button btnEditGuestData;

    //AllTextFields
    private TextField TF_firstGuestDetails;
    private TextField TF_secondGuestDetails;
    private TextField TF_thirdGuestDetails;
    private TextField TF_fourthGuestDetails;
    private TextField TF_fifthGuestDetails;
    private TextField TF_sixthGuestDetails;
    private TextField TF_seventhGuestDetails;
    private TextField TF_eighthGuestDetails;
    private TextField TF_ninthGuestDetails;

    //AllTextFields
    private TextField TF_firstAllDetails;
    private TextField TF_secondAllDetails;
    private TextField TF_thirdAllDetails;
    private TextField TF_fourthAllDetails;
    private TextField TF_fifthAllDetails;

    //AllLabelsGuest
    private Label LB_firstGuest;
    private Label LB_secondGuest;
    private Label LB_thirdGuest;
    private Label LB_fourthGuest;
    private Label LB_fifthGuest;
    private Label LB_sixthGuest;
    private Label LB_seventhGuest;
    private Label LB_eighthGuest;
    private Label LB_ninthGuest;

    //AllLabelsAll
    private Label LB_firstAll;
    private Label LB_secondAll;
    private Label LB_thirdAll;
    private Label LB_fourthAll;
    private Label LB_fifthAll;

    //AllGrids
    private GridPane GridForGuestDetails;
    private GridPane GridForAllDetails;

    //Sizes
    private int sizeWidthForLabelsAndTextFields = 140;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws URISyntaxException {

        primaryStage.setTitle("CherryIsCarry");


        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 0, 20, 20));


        //Holding all HBoxes
        verticalBox = new VBox();


        //First Row
        HBox_Buttons = new HBox();
        HBox_Buttons.setSpacing(10);
        HBox_Buttons.setPadding(new Insets(20, 20, 10, 20));


        //Button Add new Project
        Image ButtonImageAddProject = new Image(getClass().getClassLoader().getResourceAsStream("com/wachs/main/viewLayerJavaFX/Icons/addProject.png"));
        btnAddProject = new Button(GUILabels.BTN_ADD_PROJECT, new ImageView(ButtonImageAddProject));
        btnAddProject.setStyle("-fx-base: #b6e7c9;");
        btnAddProject.setTooltip(new Tooltip(GUILabels.BTN_ADD_PROJECT_TT));
        btnAddProject.setMaxWidth(Double.MAX_VALUE);

        //Button Add new Guest
        Image ButtonImageAddGuest = new Image(getClass().getClassLoader().getResourceAsStream("com/wachs/main/viewLayerJavaFX/Icons/addGuest.png"));
        btnAddGuest = new Button(GUILabels.BTN_ADD_GUEST, new ImageView(ButtonImageAddGuest));
        btnAddGuest.setStyle("-fx-base: #b6e7c9;");
        btnAddGuest.setTooltip(new Tooltip(GUILabels.BTN_ADD_GUEST_TT));
        btnAddGuest.setMaxWidth(Double.MAX_VALUE);

        //Button Edit Guest
        Image ButtonImageEditGuest = new Image(getClass().getClassLoader().getResourceAsStream("com/wachs/main/viewLayerJavaFX/Icons/editGuest.png"));
        btnEditGuestData = new Button(GUILabels.BTN_EDIT_GUEST, new ImageView(ButtonImageEditGuest));
        btnEditGuestData.setStyle("-fx-base: #c2dbe7;");
        btnEditGuestData.setTooltip(new Tooltip(GUILabels.BTN_EDIT_GUEST_TT));
        btnEditGuestData.setMaxWidth(Double.MAX_VALUE);

        HBox_Buttons.getChildren().addAll(btnAddProject, btnAddGuest, btnEditGuestData);


        //Second Row
        HBox_Selector = new HBox();
        HBox_Selector.setSpacing(10);
        HBox_Selector.setPadding(new Insets(20, 20, 10, 20));

        ScrollPane selectProject = new ScrollPane();
        ScrollPane selectGuest = new ScrollPane();

        HBox_Selector.getChildren().addAll(selectProject, selectGuest);


        //Third Row Labels & TextFields for GuestDetails
        GridForGuestDetails = new GridPane();

        HBox_LabelFieldsGuests = new HBox();
        HBox_LabelFieldsGuests.setSpacing(10);
        HBox_LabelFieldsGuests.setPadding(new Insets(80, 20, 0, 20));

        LB_firstGuest = new Label();
        LB_firstGuest.setText(GUILabels.FIRST_LB_GUEST);
        LB_firstGuest.setPrefWidth(sizeWidthForLabelsAndTextFields);
        LB_firstGuest.setStyle("-fx-font-weight: bold");

        LB_secondGuest = new Label();
        LB_secondGuest.setText(GUILabels.SECOND_LB_GUEST);
        LB_secondGuest.setPrefWidth(sizeWidthForLabelsAndTextFields);
        LB_secondGuest.setStyle("-fx-font-weight: bold");

        LB_thirdGuest = new Label();
        LB_thirdGuest.setText(GUILabels.THIRD_LB_GUEST);
        LB_thirdGuest.setPrefWidth(sizeWidthForLabelsAndTextFields);
        LB_thirdGuest.setStyle("-fx-font-weight: bold");

        LB_fourthGuest = new Label();
        LB_fourthGuest.setText(GUILabels.FOURTH_LB_GUEST);
        LB_fourthGuest.setPrefWidth(sizeWidthForLabelsAndTextFields);
        LB_fourthGuest.setStyle("-fx-font-weight: bold");

        LB_fifthGuest = new Label();
        LB_fifthGuest.setText(GUILabels.FIFTH_LB_GUEST);
        LB_fifthGuest.setPrefWidth(sizeWidthForLabelsAndTextFields);
        LB_fifthGuest.setStyle("-fx-font-weight: bold");

        LB_sixthGuest = new Label();
        LB_sixthGuest.setText(GUILabels.SIXTH_LB_GUEST);
        LB_sixthGuest.setPrefWidth(sizeWidthForLabelsAndTextFields);
        LB_sixthGuest.setStyle("-fx-font-weight: bold");

        LB_seventhGuest = new Label();
        LB_seventhGuest.setText(GUILabels.SEVENTH_LB_GUEST);
        LB_seventhGuest.setPrefWidth(sizeWidthForLabelsAndTextFields);
        LB_seventhGuest.setStyle("-fx-font-weight: bold");

        LB_eighthGuest = new Label();
        LB_eighthGuest.setText(GUILabels.EIGHTH_LB_GUEST);
        LB_eighthGuest.setPrefWidth(sizeWidthForLabelsAndTextFields);
        LB_eighthGuest.setStyle("-fx-font-weight: bold");

        LB_ninthGuest = new Label();
        LB_ninthGuest.setText(GUILabels.NINTH_LB_GUEST);
        LB_ninthGuest.setPrefWidth(sizeWidthForLabelsAndTextFields);
        LB_ninthGuest.setStyle("-fx-font-weight: bold");


        HBox_LabelFieldsGuests.getChildren().addAll(LB_firstGuest, LB_secondGuest, LB_thirdGuest, LB_fourthGuest, LB_fifthGuest, LB_sixthGuest, LB_seventhGuest, LB_eighthGuest, LB_ninthGuest);


        HBox_TextFieldsGuests = new HBox();
        HBox_TextFieldsGuests.setSpacing(10);
        HBox_TextFieldsGuests.setPadding(new Insets(4, 20, 10, 20));

        TF_firstGuestDetails = new TextField("TEST");
        TF_firstGuestDetails.setPrefWidth(sizeWidthForLabelsAndTextFields);
        TF_firstGuestDetails.setTooltip(new Tooltip(GUILabels.FIRST_LB_GUEST_TT));
        TF_firstGuestDetails.setEditable(false);
        //TF_firstGuestDetails.setStyle("-fx-border-color:red;-fx-text-fill: green;-fx-background-color: blue; -fx-font-weight: bold;");

        TF_secondGuestDetails = new TextField();
        TF_secondGuestDetails.setPrefWidth(sizeWidthForLabelsAndTextFields);
        TF_secondGuestDetails.setTooltip(new Tooltip(GUILabels.SECOND_LB_GUEST_TT));
        TF_secondGuestDetails.setEditable(false);

        TF_thirdGuestDetails = new TextField();
        TF_thirdGuestDetails.setPrefWidth(sizeWidthForLabelsAndTextFields);
        TF_thirdGuestDetails.setTooltip(new Tooltip(GUILabels.THIRD_LB_GUEST_TT));
        TF_thirdGuestDetails.setEditable(false);

        TF_fourthGuestDetails = new TextField();
        TF_fourthGuestDetails.setPrefWidth(sizeWidthForLabelsAndTextFields);
        TF_fourthGuestDetails.setTooltip(new Tooltip(GUILabels.FOURTH_LB_GUEST_TT));
        TF_fourthGuestDetails.setEditable(false);

        TF_fifthGuestDetails = new TextField();
        TF_fifthGuestDetails.setPrefWidth(sizeWidthForLabelsAndTextFields);
        TF_fifthGuestDetails.setTooltip(new Tooltip(GUILabels.FIFTH_LB_GUEST_TT));
        TF_fifthGuestDetails.setEditable(false);

        TF_sixthGuestDetails = new TextField();
        TF_sixthGuestDetails.setPrefWidth(sizeWidthForLabelsAndTextFields);
        TF_sixthGuestDetails.setTooltip(new Tooltip(GUILabels.SIXTH_LB_GUEST_TT));
        TF_sixthGuestDetails.setEditable(false);

        TF_seventhGuestDetails = new TextField();
        TF_seventhGuestDetails.setPrefWidth(sizeWidthForLabelsAndTextFields);
        TF_seventhGuestDetails.setTooltip(new Tooltip(GUILabels.SEVENTH_LB_GUEST_TT));
        TF_seventhGuestDetails.setEditable(false);

        TF_eighthGuestDetails = new TextField();
        TF_eighthGuestDetails.setPrefWidth(sizeWidthForLabelsAndTextFields);
        TF_eighthGuestDetails.setTooltip(new Tooltip(GUILabels.EIGHTH_LB_GUEST_TT));
        TF_eighthGuestDetails.setEditable(false);

        TF_ninthGuestDetails = new TextField();
        TF_ninthGuestDetails.setPrefWidth(sizeWidthForLabelsAndTextFields);
        TF_ninthGuestDetails.setTooltip(new Tooltip(GUILabels.NINTH_LB_GUEST_TT));
        TF_ninthGuestDetails.setEditable(false);


        HBox_TextFieldsGuests.getChildren().addAll(TF_firstGuestDetails, TF_secondGuestDetails, TF_thirdGuestDetails, TF_fourthGuestDetails, TF_fifthGuestDetails, TF_sixthGuestDetails, TF_seventhGuestDetails, TF_eighthGuestDetails, TF_ninthGuestDetails);

        GridPane.setConstraints(HBox_LabelFieldsGuests, 1, 1);
        GridPane.setConstraints(HBox_TextFieldsGuests, 1, 2);
        GridForGuestDetails.getChildren().addAll(HBox_LabelFieldsGuests, HBox_TextFieldsGuests);


        //Fourth Row Labels & TextFields for AllDetails
        GridForAllDetails = new GridPane();

        HBox_LabelFieldsAll = new HBox();
        HBox_LabelFieldsAll.setSpacing(10);
        HBox_LabelFieldsAll.setPadding(new Insets(80, 20, 0, 20));

        LB_firstAll = new Label();
        LB_firstAll.setText(GUILabels.FIRST_LB_ALL);
        LB_firstAll.setPrefWidth(sizeWidthForLabelsAndTextFields);
        LB_firstAll.setStyle("-fx-font-weight: bold");

        LB_secondAll = new Label();
        LB_secondAll.setText(GUILabels.SECOND_LB_ALL);
        LB_secondAll.setPrefWidth(sizeWidthForLabelsAndTextFields);
        LB_secondAll.setStyle("-fx-font-weight: bold");

        LB_thirdAll = new Label();
        LB_thirdAll.setText(GUILabels.THIRD_LB_ALL);
        LB_thirdAll.setPrefWidth(sizeWidthForLabelsAndTextFields);
        LB_thirdAll.setStyle("-fx-font-weight: bold");

        LB_fourthAll = new Label();
        LB_fourthAll.setText(GUILabels.FOURTH_LB_ALL);
        LB_fourthAll.setPrefWidth(sizeWidthForLabelsAndTextFields);
        LB_fourthAll.setStyle("-fx-font-weight: bold");

        LB_fifthAll = new Label();
        LB_fifthAll.setText(GUILabels.FIFTH_LB_ALL);
        LB_fifthAll.setPrefWidth(sizeWidthForLabelsAndTextFields);
        LB_fifthAll.setStyle("-fx-font-weight: bold");


        HBox_LabelFieldsAll.getChildren().addAll(LB_firstAll, LB_secondAll, LB_thirdAll, LB_fourthAll, LB_fifthAll);


        HBox_TextFieldsAll = new HBox();
        HBox_TextFieldsAll.setSpacing(10);
        HBox_TextFieldsAll.setPadding(new Insets(4, 20, 10, 20));

        TF_firstAllDetails = new TextField();
        TF_firstAllDetails.setPrefWidth(sizeWidthForLabelsAndTextFields);
        TF_firstAllDetails.setTooltip(new Tooltip(GUILabels.FIRST_LB_ALL_TT));
        TF_firstAllDetails.setEditable(false);
        TF_secondAllDetails = new TextField();
        TF_secondAllDetails.setPrefWidth(sizeWidthForLabelsAndTextFields);
        TF_secondAllDetails.setTooltip(new Tooltip(GUILabels.SECOND_LB_ALL_TT));
        TF_secondAllDetails.setEditable(false);
        TF_thirdAllDetails = new TextField();
        TF_thirdAllDetails.setPrefWidth(sizeWidthForLabelsAndTextFields);
        TF_thirdAllDetails.setTooltip(new Tooltip(GUILabels.THIRD_LB_ALL_TT));
        TF_thirdAllDetails.setEditable(false);
        TF_fourthAllDetails = new TextField();
        TF_fourthAllDetails.setPrefWidth(sizeWidthForLabelsAndTextFields);
        TF_fourthAllDetails.setTooltip(new Tooltip(GUILabels.FOURTH_LB_ALL_TT));
        TF_fourthAllDetails.setEditable(false);
        TF_fifthAllDetails = new TextField();
        TF_fifthAllDetails.setPrefWidth(sizeWidthForLabelsAndTextFields);
        TF_fifthAllDetails.setTooltip(new Tooltip(GUILabels.FIFTH_LB_ALL_TT));
        TF_fifthAllDetails.setEditable(false);


        HBox_TextFieldsAll.getChildren().addAll(TF_firstAllDetails, TF_secondAllDetails, TF_thirdAllDetails, TF_fourthAllDetails, TF_fifthAllDetails);

        GridPane.setConstraints(HBox_LabelFieldsAll, 1, 1);
        GridPane.setConstraints(HBox_TextFieldsAll, 1, 2);
        GridForAllDetails.getChildren().addAll(HBox_LabelFieldsAll, HBox_TextFieldsAll);


        verticalBox.getChildren().addAll(HBox_Buttons, HBox_Selector, GridForGuestDetails, GridForAllDetails);

        Scene scene = new Scene(verticalBox, 1200, 400);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
