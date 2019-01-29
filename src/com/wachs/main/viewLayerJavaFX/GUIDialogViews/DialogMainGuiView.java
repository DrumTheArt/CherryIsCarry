package com.wachs.main.viewLayerJavaFX.GUIDialogViews;

import com.wachs.main.viewLayerJavaFX.GUIElementsGenerators.*;
import com.wachs.main.viewLayerJavaFX.GUISetup.GUINaming;
import com.wachs.main.viewLayerJavaFX.GUISetup.GUIProperties;
import com.wachs.main.viewLayerJavaFX.GUISetup.GUISourceIcons;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DialogMainGuiView {

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

    //AllComboBox
    private ComboBox selectProject;
    private ComboBox selectGuest;


    public Stage displayMainGui() {

        Stage primaryStage = new Stage();

        primaryStage.setTitle("CherryIsCarry");

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 0, 20, 20));

        //Holding all HBoxes
        verticalBox = new VBox();

        //First Row
        HBox_Buttons = new CreateGUIHBox().CreateHBox(10, 20, 20, 10, 20);

        //Button Add new Project
        btnAddProject = new CreateGUIButton().createBtn(GUINaming.BTN_ADD_PROJECT, GUISourceIcons.sourceAddProject, GUIProperties.BTN_COLOR_BLUELIGHT, GUINaming.TT_BTN_ADD_PROJECT);

        btnAddProject.setOnAction(e -> {

            new DialogAddProjectView().display();
            primaryStage.close();

        });
        //Button Add new Guest
        btnAddGuest = new CreateGUIButton().createBtn(GUINaming.BTN_ADD_GUEST, GUISourceIcons.sourceAddGuest2, GUIProperties.BTN_COLOR_BLUELIGHT, GUINaming.TT_BTN_ADD_GUEST);

        btnAddGuest.setOnAction(e -> {

            new DialogAddGuestView().display();
            primaryStage.close();

        });

        //Button Edit Guest
        btnEditGuestData = new CreateGUIButton().createBtn(GUINaming.BTN_EDIT_GUEST, GUISourceIcons.sourceEditGuest, GUIProperties.BTN_COLOR_BLUELIGHT, GUINaming.TT_BTN_EDIT_GUEST);

        btnEditGuestData.setOnAction(e -> {

            new DialogEditGuestView().display();
            primaryStage.close();

        });

        HBox_Buttons.getChildren().addAll(btnAddProject, btnAddGuest, btnEditGuestData);

        //Second Row
        HBox_Selector = new CreateGUIHBox().CreateHBox(10, 20, 20, 10, 20);

        selectProject = new CreateGUIComboBox().createComboBox(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_LB_PROJECTS_SELECT);
        selectGuest = new CreateGUIComboBox().createComboBox(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_LB_GUEST_SELECT);

        HBox_Selector.getChildren().addAll(selectProject, selectGuest);

        //Third Row Labels & TextFields for GuestDetails
        GridForGuestDetails = new GridPane();

        HBox_LabelFieldsGuests = new CreateGUIHBox().CreateHBox(10, 80, 20, 0, 20);

        lb_GuestNights = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_NIGHTS, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestNightsEUR = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_NIGHTS_EUR, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestDrinks = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_DRINKS, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestDrinksEUR = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_DRINKS_EUR, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestFood = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_FOOD_EUR, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestFoodEUR = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_FOOD, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestTotalCosts = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_TOTAL_COSTS, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestAlreadyPaid = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_ALREADY_PAID, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestStillToPay = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_STILL_TO_PAY, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);

        HBox_LabelFieldsGuests.getChildren().addAll(lb_GuestNights, lb_GuestNightsEUR, lb_GuestDrinks, lb_GuestDrinksEUR, lb_GuestFood, lb_GuestFoodEUR, lb_GuestTotalCosts, lb_GuestAlreadyPaid, lb_GuestStillToPay);

        HBox_TextFieldsGuests = new CreateGUIHBox().CreateHBox(10, 4, 20, 10, 20);

        tf_GuestNights = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_NIGHTS, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_GuestNightsEUR = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_NIGHTS_EUR, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_GuestDrinks = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_DRINKS, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_GuestDrinksEUR = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_DRINKS_EUR, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_GuestFood = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_FOOD, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_GuestFoodEUR = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_FOOD_EUR, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_GuestTotalCosts = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_TOTAL_COSTS, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_GuestAlreadyPaid = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_ALREADY_PAID, GUIProperties.TEXTFIELD_DESIGN, false);

        tf_StillToPay = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_STILL_TO_PAY, GUIProperties.TEXTFIELD_DESIGN, false);

        HBox_TextFieldsGuests.getChildren().addAll(tf_GuestNights, tf_GuestNightsEUR, tf_GuestDrinks, tf_GuestDrinksEUR, tf_GuestFood, tf_GuestFoodEUR, tf_GuestTotalCosts, tf_GuestAlreadyPaid, tf_StillToPay);

        GridPane.setConstraints(HBox_LabelFieldsGuests, 1, 1);
        GridPane.setConstraints(HBox_TextFieldsGuests, 1, 2);
        GridForGuestDetails.getChildren().addAll(HBox_LabelFieldsGuests, HBox_TextFieldsGuests);

        //Fourth Row Labels & TextFields for AllDetails
        GridForAllDetails = new GridPane();

        HBox_LabelFieldsAll = new CreateGUIHBox().CreateHBox(10, 80, 20, 0, 20);

        lb_AllRentPrice = new CreateGUILabel().createLabel(GUINaming.LB_ALL_RENT_PRICE, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_AllDrinks = new CreateGUILabel().createLabel(GUINaming.LB_ALL_DRINKS_EUR, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_AllFood = new CreateGUILabel().createLabel(GUINaming.LB_ALL_FOOD_EUR, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_AllTotalCosts = new CreateGUILabel().createLabel(GUINaming.LB_ALL_TOTAL_COSTS, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_AllOutstandingPayment = new CreateGUILabel().createLabel(GUINaming.LB_ALL_OUTSTANDING_PAYMENT, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);

        HBox_LabelFieldsAll.getChildren().addAll(lb_AllRentPrice, lb_AllDrinks, lb_AllFood, lb_AllTotalCosts, lb_AllOutstandingPayment);

        HBox_TextFieldsAll = new CreateGUIHBox().CreateHBox(10, 4, 20, 10, 20);

        tf_AllRentPrice = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_ALL_RENT, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_AllDrinks = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_ALL_DRINKS_EUR, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_AllFood = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_ALL_FOOD_EUR, GUIProperties.TEXTFIELD_DESIGN, false);

        tf_AllTotalCosts = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_ALL_TOTAL_COSTS, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_AllOutstandingPayment = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_ALL_OUTSTANDING_SUM, GUIProperties.TEXTFIELD_DESIGN, false);

        HBox_TextFieldsAll.getChildren().addAll(tf_AllRentPrice, tf_AllDrinks, tf_AllFood, tf_AllTotalCosts, tf_AllOutstandingPayment);

        GridPane.setConstraints(HBox_LabelFieldsAll, 1, 1);
        GridPane.setConstraints(HBox_TextFieldsAll, 1, 2);
        GridForAllDetails.getChildren().addAll(HBox_LabelFieldsAll, HBox_TextFieldsAll);

        verticalBox.getChildren().addAll(HBox_Buttons, HBox_Selector, GridForGuestDetails, GridForAllDetails);

        Scene scene = new Scene(verticalBox, 1200, 450);

        primaryStage.setScene(scene);

        primaryStage.show();

        return primaryStage;
    }

    public TextField getTf_GuestNights() {
        return tf_GuestNights;
    }

    public void setTf_GuestNights(TextField tf_GuestNights) {
        this.tf_GuestNights = tf_GuestNights;
    }

    public TextField getTf_GuestNightsEUR() {
        return tf_GuestNightsEUR;
    }

    public void setTf_GuestNightsEUR(TextField tf_GuestNightsEUR) {
        this.tf_GuestNightsEUR = tf_GuestNightsEUR;
    }

    public TextField getTf_GuestDrinks() {
        return tf_GuestDrinks;
    }

    public void setTf_GuestDrinks(TextField tf_GuestDrinks) {
        this.tf_GuestDrinks = tf_GuestDrinks;
    }

    public TextField getTf_GuestDrinksEUR() {
        return tf_GuestDrinksEUR;
    }

    public void setTf_GuestDrinksEUR(TextField tf_GuestDrinksEUR) {
        this.tf_GuestDrinksEUR = tf_GuestDrinksEUR;
    }

    public TextField getTf_GuestFood() {
        return tf_GuestFood;
    }

    public void setTf_GuestFood(String tf_GuestFood) {

        this.tf_GuestFood.setText(tf_GuestFood);

    }

    public TextField getTf_GuestFoodEUR() {
        return tf_GuestFoodEUR;
    }

    public void setTf_GuestFoodEUR(TextField tf_GuestFoodEUR) {
        this.tf_GuestFoodEUR = tf_GuestFoodEUR;
    }

    public TextField getTf_GuestTotalCosts() {
        return tf_GuestTotalCosts;
    }

    public void setTf_GuestTotalCosts(TextField tf_GuestTotalCosts) {
        this.tf_GuestTotalCosts = tf_GuestTotalCosts;
    }

    public TextField getTf_GuestAlreadyPaid() {
        return tf_GuestAlreadyPaid;
    }

    public void setTf_GuestAlreadyPaid(TextField tf_GuestAlreadyPaid) {
        this.tf_GuestAlreadyPaid = tf_GuestAlreadyPaid;
    }

    public TextField getTf_StillToPay() {
        return tf_StillToPay;
    }

    public void setTf_StillToPay(TextField tf_StillToPay) {
        this.tf_StillToPay = tf_StillToPay;
    }

    public TextField getTf_AllRentPrice() {
        return tf_AllRentPrice;
    }

    public void setTf_AllRentPrice(TextField tf_AllRentPrice) {
        this.tf_AllRentPrice = tf_AllRentPrice;
    }

    public TextField getTf_AllDrinks() {
        return tf_AllDrinks;
    }

    public void setTf_AllDrinks(TextField tf_AllDrinks) {
        this.tf_AllDrinks = tf_AllDrinks;
    }

    public TextField getTf_AllFood() {
        return tf_AllFood;
    }

    public void setTf_AllFood(TextField tf_AllFood) {
        this.tf_AllFood = tf_AllFood;
    }

    public TextField getTf_AllTotalCosts() {
        return tf_AllTotalCosts;
    }

    public void setTf_AllTotalCosts(TextField tf_AllTotalCosts) {
        this.tf_AllTotalCosts = tf_AllTotalCosts;
    }

    public TextField getTf_AllOutstandingPayment() {
        return tf_AllOutstandingPayment;
    }

    public void setTf_AllOutstandingPayment(TextField tf_AllOutstandingPayment) {
        this.tf_AllOutstandingPayment = tf_AllOutstandingPayment;
    }

    public GridPane getGridForGuestDetails() {
        return GridForGuestDetails;
    }

    public void setGridForGuestDetails(GridPane gridForGuestDetails) {
        GridForGuestDetails = gridForGuestDetails;
    }

    public GridPane getGridForAllDetails() {
        return GridForAllDetails;
    }

    public void setGridForAllDetails(GridPane gridForAllDetails) {
        GridForAllDetails = gridForAllDetails;
    }

    public ComboBox getSelectProject() {
        return selectProject;
    }

    public void setSelectProject(ComboBox selectProject) {
        this.selectProject = selectProject;
    }

    public ComboBox getSelectGuest() {
        return selectGuest;
    }

    public void setSelectGuest(ComboBox selectGuest) {
        this.selectGuest = selectGuest;
    }
}