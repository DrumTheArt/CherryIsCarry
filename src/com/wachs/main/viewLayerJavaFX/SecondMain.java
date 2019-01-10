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
    private TextField tf_GuestNights;
    private TextField tf_GuestNightsEUR;
    private TextField tf_GuestDrinks;
    private TextField tf_GuestDrinksEUR;
    private TextField tf_GuestFood;
    private TextField tf_GuestFoodEUR;
    private TextField tf_GuestTotalCosts;
    private TextField tf_GuestAlreadyPaid;
    private TextField tf_StillToPay;


    //AllTextFields
    private TextField tf_AllRentPrice;
    private TextField tf_AllDrinks;
    private TextField tf_AllFood;
    private TextField tf_AllTotalCosts;
    private TextField tf_AllOutstandingPayment;


    //AllLabelsGuest
    private Label lb_GuestNights;
    private Label lb_GuestNightsEUR;
    private Label lb_GuestDrinks;
    private Label lb_GuestDrinksEUR;
    private Label lb_GuestFood;
    private Label lb_GuestFoodEUR;
    private Label lb_GuestTotalCosts;
    private Label lb_GuestAlreadyPaid;
    private Label lb_GuestStillToPay;


    //AllLabelsAll
    private Label lb_AllRentPrice;
    private Label lb_AllDrinks;
    private Label lb_AllFood;
    private Label lb_AllTotalCosts;
    private Label lb_AllOutstandingPayment;


    //AllGrids
    private GridPane GridForGuestDetails;
    private GridPane GridForAllDetails;


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
        btnAddProject = new Button(GUINaming.BTN_ADD_PROJECT, new ImageView(ButtonImageAddProject));
        btnAddProject.setStyle(GUIProperties.BTN_COLOR_BLUELIGHT);
        btnAddProject.setTooltip(new Tooltip(GUINaming.TT_BTN_ADD_PROJECT));
        btnAddProject.setMaxWidth(Double.MAX_VALUE);

        //Button Add new Guest
        Image ButtonImageAddGuest = new Image(getClass().getClassLoader().getResourceAsStream("com/wachs/main/viewLayerJavaFX/Icons/addGuest2.png"));
        btnAddGuest = new Button(GUINaming.BTN_ADD_GUEST, new ImageView(ButtonImageAddGuest));
        btnAddGuest.setStyle(GUIProperties.BTN_COLOR_BLUELIGHT);
        btnAddGuest.setTooltip(new Tooltip(GUINaming.TT_BTN_ADD_GUEST));
        btnAddGuest.setMaxWidth(Double.MAX_VALUE);

        //Button Edit Guest
        Image ButtonImageEditGuest = new Image(getClass().getClassLoader().getResourceAsStream("com/wachs/main/viewLayerJavaFX/Icons/editGuest.png"));
        btnEditGuestData = new Button(GUINaming.BTN_EDIT_GUEST, new ImageView(ButtonImageEditGuest));
        btnEditGuestData.setStyle(GUIProperties.BTN_COLOR_BLUELIGHT);
        btnEditGuestData.setTooltip(new Tooltip(GUINaming.TT_BTN_EDIT_GUEST));
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

        lb_GuestNights = new Label();
        lb_GuestNights.setText(GUINaming.LB_GUEST_NIGHTS);
        lb_GuestNights.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_GuestNights.setStyle(GUIProperties.FONT_BOLD);

        lb_GuestNightsEUR = new Label();
        lb_GuestNightsEUR.setText(GUINaming.LB_GUEST_NIGHTS_EUR);
        lb_GuestNightsEUR.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_GuestNightsEUR.setStyle(GUIProperties.FONT_BOLD);

        lb_GuestDrinks = new Label();
        lb_GuestDrinks.setText(GUINaming.LB_GUEST_DRINKS);
        lb_GuestDrinks.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_GuestDrinks.setStyle(GUIProperties.FONT_BOLD);

        lb_GuestDrinksEUR = new Label();
        lb_GuestDrinksEUR.setText(GUINaming.LB_GUEST_DRINKS_EUR);
        lb_GuestDrinksEUR.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_GuestDrinksEUR.setStyle(GUIProperties.FONT_BOLD);

        lb_GuestFood = new Label();
        lb_GuestFood.setText(GUINaming.LB_GUEST_FOOD_EUR);
        lb_GuestFood.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_GuestFood.setStyle(GUIProperties.FONT_BOLD);

        lb_GuestFoodEUR = new Label();
        lb_GuestFoodEUR.setText(GUINaming.LB_GUEST_FOOD);
        lb_GuestFoodEUR.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_GuestFoodEUR.setStyle(GUIProperties.FONT_BOLD);

        lb_GuestTotalCosts = new Label();
        lb_GuestTotalCosts.setText(GUINaming.LB_GUEST_TOTAL_COSTS);
        lb_GuestTotalCosts.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_GuestTotalCosts.setStyle(GUIProperties.FONT_BOLD);

        lb_GuestAlreadyPaid = new Label();
        lb_GuestAlreadyPaid.setText(GUINaming.LB_GUEST_ALREADY_PAID);
        lb_GuestAlreadyPaid.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_GuestAlreadyPaid.setStyle(GUIProperties.FONT_BOLD);

        lb_GuestStillToPay = new Label();
        lb_GuestStillToPay.setText(GUINaming.LB_GUEST_STILL_TO_PAY);
        lb_GuestStillToPay.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_GuestStillToPay.setStyle(GUIProperties.FONT_BOLD);


        HBox_LabelFieldsGuests.getChildren().addAll(lb_GuestNights, lb_GuestNightsEUR, lb_GuestDrinks, lb_GuestDrinksEUR, lb_GuestFood, lb_GuestFoodEUR, lb_GuestTotalCosts, lb_GuestAlreadyPaid, lb_GuestStillToPay);


        HBox_TextFieldsGuests = new HBox();
        HBox_TextFieldsGuests.setSpacing(10);
        HBox_TextFieldsGuests.setPadding(new Insets(4, 20, 10, 20));

        tf_GuestNights = new TextField("3 nights");
        tf_GuestNights.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_GuestNights.setTooltip(new Tooltip(GUINaming.TT_TF_GUEST_NIGHTS));
        tf_GuestNights.setEditable(false);
        tf_GuestNights.setStyle(GUIProperties.TEXTFIELD_DESIGN);

        tf_GuestNightsEUR = new TextField("120.25 EUR");
        tf_GuestNightsEUR.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_GuestNightsEUR.setTooltip(new Tooltip(GUINaming.TT_TF_GUEST_NIGHTS_EUR));
        tf_GuestNightsEUR.setEditable(false);
        tf_GuestNightsEUR.setStyle(GUIProperties.TEXTFIELD_DESIGN);

        tf_GuestDrinks = new TextField();
        tf_GuestDrinks.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_GuestDrinks.setTooltip(new Tooltip(GUINaming.TT_TF_GUEST_DRINKS));
        tf_GuestDrinks.setEditable(false);
        tf_GuestDrinks.setStyle(GUIProperties.TEXTFIELD_DESIGN);

        tf_GuestDrinksEUR = new TextField();
        tf_GuestDrinksEUR.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_GuestDrinksEUR.setTooltip(new Tooltip(GUINaming.TT_TF_GUEST_DRINKS_EUR));
        tf_GuestDrinksEUR.setEditable(false);
        tf_GuestDrinksEUR.setStyle(GUIProperties.TEXTFIELD_DESIGN);

        tf_GuestFood = new TextField();
        tf_GuestFood.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_GuestFood.setTooltip(new Tooltip(GUINaming.TT_TF_GUEST_FOOD));
        tf_GuestFood.setEditable(false);
        tf_GuestFood.setStyle(GUIProperties.TEXTFIELD_DESIGN);

        tf_GuestFoodEUR = new TextField();
        tf_GuestFoodEUR.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_GuestFoodEUR.setTooltip(new Tooltip(GUINaming.TT_TF_GUEST_FOOD_EUR));
        tf_GuestFoodEUR.setEditable(false);
        tf_GuestFoodEUR.setStyle(GUIProperties.TEXTFIELD_DESIGN);

        tf_GuestTotalCosts = new TextField();
        tf_GuestTotalCosts.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_GuestTotalCosts.setTooltip(new Tooltip(GUINaming.TT_TF_GUEST_TOTAL_COSTS));
        tf_GuestTotalCosts.setEditable(false);
        tf_GuestTotalCosts.setStyle(GUIProperties.TEXTFIELD_DESIGN);

        tf_GuestAlreadyPaid = new TextField();
        tf_GuestAlreadyPaid.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_GuestAlreadyPaid.setTooltip(new Tooltip(GUINaming.TT_TF_GUEST_ALREADY_PAID));
        tf_GuestAlreadyPaid.setEditable(false);
        tf_GuestAlreadyPaid.setStyle(GUIProperties.TEXTFIELD_DESIGN);

        tf_StillToPay = new TextField();
        tf_StillToPay.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_StillToPay.setTooltip(new Tooltip(GUINaming.TT_TF_GUEST_STILL_TO_PAY));
        tf_StillToPay.setEditable(false);
        tf_StillToPay.setStyle(GUIProperties.TEXTFIELD_DESIGN);


        HBox_TextFieldsGuests.getChildren().addAll(tf_GuestNights, tf_GuestNightsEUR, tf_GuestDrinks, tf_GuestDrinksEUR, tf_GuestFood, tf_GuestFoodEUR, tf_GuestTotalCosts, tf_GuestAlreadyPaid, tf_StillToPay);

        GridPane.setConstraints(HBox_LabelFieldsGuests, 1, 1);
        GridPane.setConstraints(HBox_TextFieldsGuests, 1, 2);
        GridForGuestDetails.getChildren().addAll(HBox_LabelFieldsGuests, HBox_TextFieldsGuests);


        //Fourth Row Labels & TextFields for AllDetails
        GridForAllDetails = new GridPane();

        HBox_LabelFieldsAll = new HBox();
        HBox_LabelFieldsAll.setSpacing(10);
        HBox_LabelFieldsAll.setPadding(new Insets(80, 20, 0, 20));

        lb_AllRentPrice = new Label();
        lb_AllRentPrice.setText(GUINaming.LB_ALL_RENT_PRICE);
        lb_AllRentPrice.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_AllRentPrice.setStyle(GUIProperties.FONT_BOLD);

        lb_AllDrinks = new Label();
        lb_AllDrinks.setText(GUINaming.LB_ALL_DRINKS_EUR);
        lb_AllDrinks.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_AllDrinks.setStyle(GUIProperties.FONT_BOLD);

        lb_AllFood = new Label();
        lb_AllFood.setText(GUINaming.LB_ALL_FOOD_EUR);
        lb_AllFood.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_AllFood.setStyle(GUIProperties.FONT_BOLD);

        lb_AllTotalCosts = new Label();
        lb_AllTotalCosts.setText(GUINaming.LB_ALL_TOTAL_COSTS);
        lb_AllTotalCosts.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_AllTotalCosts.setStyle(GUIProperties.FONT_BOLD);

        lb_AllOutstandingPayment = new Label();
        lb_AllOutstandingPayment.setText(GUINaming.LB_ALL_OUTSTANDING_PAYMENT);
        lb_AllOutstandingPayment.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_AllOutstandingPayment.setStyle(GUIProperties.FONT_BOLD);


        HBox_LabelFieldsAll.getChildren().addAll(lb_AllRentPrice, lb_AllDrinks, lb_AllFood, lb_AllTotalCosts, lb_AllOutstandingPayment);


        HBox_TextFieldsAll = new HBox();
        HBox_TextFieldsAll.setSpacing(10);
        HBox_TextFieldsAll.setPadding(new Insets(4, 20, 10, 20));

        tf_AllRentPrice = new TextField();
        tf_AllRentPrice.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_AllRentPrice.setTooltip(new Tooltip(GUINaming.TT_TF_ALL_RENT));
        tf_AllRentPrice.setEditable(false);
        tf_AllRentPrice.setStyle(GUIProperties.TEXTFIELD_DESIGN);
        tf_AllDrinks = new TextField();
        tf_AllDrinks.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_AllDrinks.setTooltip(new Tooltip(GUINaming.TT_TF_ALL_DRINKS_EUR));
        tf_AllDrinks.setEditable(false);
        tf_AllDrinks.setStyle(GUIProperties.TEXTFIELD_DESIGN);
        tf_AllFood = new TextField();
        tf_AllFood.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_AllFood.setTooltip(new Tooltip(GUINaming.TT_TF_ALL_FOOD_EUR));
        tf_AllFood.setEditable(false);
        tf_AllFood.setStyle(GUIProperties.TEXTFIELD_DESIGN);
        tf_AllTotalCosts = new TextField();
        tf_AllTotalCosts.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_AllTotalCosts.setTooltip(new Tooltip(GUINaming.TT_TF_ALL_TOTAL_COSTS));
        tf_AllTotalCosts.setEditable(false);
        tf_AllTotalCosts.setStyle(GUIProperties.TEXTFIELD_DESIGN);
        tf_AllOutstandingPayment = new TextField();
        tf_AllOutstandingPayment.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_AllOutstandingPayment.setTooltip(new Tooltip(GUINaming.TT_TF_ALL_OUTSTANDING_SUM));
        tf_AllOutstandingPayment.setEditable(false);
        tf_AllOutstandingPayment.setStyle(GUIProperties.TEXTFIELD_DESIGN);


        HBox_TextFieldsAll.getChildren().addAll(tf_AllRentPrice, tf_AllDrinks, tf_AllFood, tf_AllTotalCosts, tf_AllOutstandingPayment);

        GridPane.setConstraints(HBox_LabelFieldsAll, 1, 1);
        GridPane.setConstraints(HBox_TextFieldsAll, 1, 2);
        GridForAllDetails.getChildren().addAll(HBox_LabelFieldsAll, HBox_TextFieldsAll);


        verticalBox.getChildren().addAll(HBox_Buttons, HBox_Selector, GridForGuestDetails, GridForAllDetails);

        Scene scene = new Scene(verticalBox, 1200, 450);

        primaryStage.setScene(scene);

        primaryStage.show();

    }
}
