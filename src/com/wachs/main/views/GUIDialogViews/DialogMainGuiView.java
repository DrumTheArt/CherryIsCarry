package com.wachs.main.views.GUIDialogViews;

import com.wachs.main.models.AllGuestsDropDownMenuModel;
import com.wachs.main.models.AllProjectsDropDownMenuModel;
import com.wachs.main.views.GUIElementsGenerators.*;
import com.wachs.main.views.GUISetup.GUINamingProperties;
import com.wachs.main.views.GUISetup.GUIProperties;
import com.wachs.main.views.GUISetup.GUISourceIcons;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
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
    private TextField tf_Deposite;
    private TextField tf_AllTotalCosts;
    private TextField tf_AllOutstandingPayment;
    private TextField tf_AllAllreadyPaid;

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
    private Label lb_Deposite;
    private Label lb_AllDrinks;
    private Label lb_AllFood;
    private Label lb_AllTotalCosts;
    private Label lb_AllOutstandingPayment;
    private Label lb_AllAlreadyPaid;

    //AllGrids
    private GridPane GridForGuestDetails;
    private GridPane GridForAllDetails;

    //AllComboBox
    private ComboBox selectProject;
    private ComboBox selectGuest;

    //AllComboBox models
    private ObservableList<String> comboBoxGuestModel;
    private ObservableList<String> comboBoxProjectModel;


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
        btnAddProject = new CreateGUIButton().createBtn(GUINamingProperties.BTN_ADD_PROJECT, GUISourceIcons.sourceAddProject, GUIProperties.BTN_COLOR_BLUELIGHT, GUINamingProperties.TT_BTN_ADD_PROJECT);

        btnAddProject.setOnAction(e -> {

            new DialogAddProjectView().display();
            primaryStage.close();

        });
        //Button Add new Guest
        btnAddGuest = new CreateGUIButton().createBtn(GUINamingProperties.BTN_ADD_GUEST, GUISourceIcons.sourceAddGuest2, GUIProperties.BTN_COLOR_BLUELIGHT, GUINamingProperties.TT_BTN_ADD_GUEST);

        btnAddGuest.setOnAction(e -> {

            new DialogAddGuestView().display();
            primaryStage.close();

        });

        //Button Edit Guest
        btnEditGuestData = new CreateGUIButton().createBtn(GUINamingProperties.BTN_EDIT_GUEST, GUISourceIcons.sourceEditGuest, GUIProperties.BTN_COLOR_BLUELIGHT, GUINamingProperties.TT_BTN_EDIT_GUEST);

        btnEditGuestData.setOnAction(e -> {

            new DialogEditGuestView().display();
            primaryStage.close();

        });

        HBox_Buttons.getChildren().addAll(btnAddProject, btnAddGuest, btnEditGuestData);

        //Second Row
        HBox_Selector = new CreateGUIHBox().CreateHBox(10, 20, 20, 10, 20);

        //Generate ComboBox Model for all Guests
        comboBoxProjectModel = new AllProjectsDropDownMenuModel().getGetAllProjects();
        selectProject = new CreateGUIComboBox().createComboBox(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_LB_PROJECTS_SELECT, comboBoxProjectModel);

        //Generate ComboBox Model for all Guests
        comboBoxGuestModel = new AllGuestsDropDownMenuModel().getAllProjects();
        selectGuest = new CreateGUIComboBox().createComboBox(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_LB_GUEST_SELECT, comboBoxGuestModel);

        HBox_Selector.getChildren().addAll(selectProject, selectGuest);

        //Third Row Labels & TextFields for GuestDetails
        GridForGuestDetails = new GridPane();

        HBox_LabelFieldsGuests = new CreateGUIHBox().CreateHBox(10, 80, 20, 0, 20);

        lb_GuestNights = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_NIGHTS, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestNightsEUR = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_NIGHTS_EUR, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestDrinks = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_DRINKS, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestDrinksEUR = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_DRINKS_EUR, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestFood = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_FOOD_EUR, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestFoodEUR = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_FOOD, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestTotalCosts = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_TOTAL_COSTS, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestAlreadyPaid = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_ALREADY_PAID, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestStillToPay = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_STILL_TO_PAY, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);

        HBox_LabelFieldsGuests.getChildren().addAll(lb_GuestNights, lb_GuestNightsEUR, lb_GuestDrinks, lb_GuestDrinksEUR, lb_GuestFood, lb_GuestFoodEUR, lb_GuestTotalCosts, lb_GuestAlreadyPaid, lb_GuestStillToPay);

        HBox_TextFieldsGuests = new CreateGUIHBox().CreateHBox(10, 4, 20, 10, 20);

        tf_GuestNights = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_NIGHTS, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_GuestNightsEUR = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_NIGHTS_EUR, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_GuestDrinks = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_DRINKS, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_GuestDrinksEUR = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_DRINKS_EUR, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_GuestFood = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_FOOD, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_GuestFoodEUR = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_FOOD_EUR, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_GuestTotalCosts = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_TOTAL_COSTS, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_GuestAlreadyPaid = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_ALREADY_PAID, GUIProperties.TEXTFIELD_DESIGN, false);

        tf_StillToPay = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_STILL_TO_PAY, GUIProperties.TEXTFIELD_DESIGN, false);

        HBox_TextFieldsGuests.getChildren().addAll(tf_GuestNights, tf_GuestNightsEUR, tf_GuestDrinks, tf_GuestDrinksEUR, tf_GuestFood, tf_GuestFoodEUR, tf_GuestTotalCosts, tf_GuestAlreadyPaid, tf_StillToPay);

        GridPane.setConstraints(HBox_LabelFieldsGuests, 1, 1);
        GridPane.setConstraints(HBox_TextFieldsGuests, 1, 2);
        GridForGuestDetails.getChildren().addAll(HBox_LabelFieldsGuests, HBox_TextFieldsGuests);

        //Fourth Row Labels & TextFields for AllDetails
        GridForAllDetails = new GridPane();

        HBox_LabelFieldsAll = new CreateGUIHBox().CreateHBox(10, 80, 20, 0, 20);

        lb_AllRentPrice = new CreateGUILabel().createLabel(GUINamingProperties.LB_ALL_RENT_PRICE, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_Deposite = new CreateGUILabel().createLabel(GUINamingProperties.LB_PROJECTS_DEPOSITE, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_AllDrinks = new CreateGUILabel().createLabel(GUINamingProperties.LB_ALL_DRINKS_EUR, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_AllFood = new CreateGUILabel().createLabel(GUINamingProperties.LB_ALL_FOOD_EUR, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_AllTotalCosts = new CreateGUILabel().createLabel(GUINamingProperties.LB_ALL_TOTAL_COSTS, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_AllOutstandingPayment = new CreateGUILabel().createLabel(GUINamingProperties.LB_ALL_OUTSTANDING_PAYMENT, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_AllAlreadyPaid = new CreateGUILabel().createLabel(GUINamingProperties.LB_ALL_ALREADYPAID, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);

        HBox_LabelFieldsAll.getChildren().addAll(lb_AllRentPrice, lb_Deposite, lb_AllDrinks, lb_AllFood, lb_AllTotalCosts, lb_AllAlreadyPaid, lb_AllOutstandingPayment);

        HBox_TextFieldsAll = new CreateGUIHBox().CreateHBox(10, 4, 20, 10, 20);

        tf_AllRentPrice = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_ALL_RENT, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_AllDrinks = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_ALL_DRINKS_EUR, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_AllFood = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_ALL_FOOD_EUR, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_Deposite = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_ALL_DEPOSITE_EUR, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_AllTotalCosts = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_ALL_TOTAL_COSTS, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_AllOutstandingPayment = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_ALL_OUTSTANDING_SUM, GUIProperties.TEXTFIELD_DESIGN, false);
        tf_AllAllreadyPaid = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_ALL_ALLREADYPAID_SUM, GUIProperties.TEXTFIELD_DESIGN, false);

        HBox_TextFieldsAll.getChildren().addAll(tf_AllRentPrice, tf_Deposite, tf_AllDrinks, tf_AllFood, tf_AllTotalCosts, tf_AllAllreadyPaid, tf_AllOutstandingPayment);

        GridPane.setConstraints(HBox_LabelFieldsAll, 1, 1);
        GridPane.setConstraints(HBox_TextFieldsAll, 1, 2);
        GridForAllDetails.getChildren().addAll(HBox_LabelFieldsAll, HBox_TextFieldsAll);

        verticalBox.getChildren().addAll(HBox_Buttons, HBox_Selector, GridForGuestDetails, GridForAllDetails);

        Scene scene = new Scene(verticalBox, 1200, 450);

        primaryStage.setScene(scene);

        primaryStage.show();

        return primaryStage;
    }

    public void setTf_GuestNights(int nights) {
        this.tf_GuestNights.setText(String.valueOf(nights));
    }

    public void setTf_GuestNightsEUR(double amount) {
        this.tf_GuestNightsEUR.setText(String.valueOf(amount));
    }

    public void setTf_GuestDrinks(int nights) {
        this.tf_GuestDrinks.setText(String.valueOf(nights));
    }

    public void setTf_GuestDrinksEUR(double amount) {
        this.tf_GuestDrinksEUR.setText(String.valueOf(amount));
    }

    public void setTf_GuestFood(int nights) {
        this.tf_GuestFood.setText(String.valueOf(nights));
    }

    public void setTf_GuestFoodEUR(double amount) {
        this.tf_GuestFoodEUR.setText(String.valueOf(amount));
    }

    public void setTf_GuestTotalCosts(double amount) {
        this.tf_GuestTotalCosts.setText(String.valueOf(amount));
    }

    public void setTf_GuestAlreadyPaid(double amount) {
        this.tf_GuestAlreadyPaid.setText(String.valueOf(amount));
    }

    public void setTf_StillToPay(double amount) {
        this.tf_StillToPay.setText(String.valueOf(amount));
    }

    public void setTf_AllRentPrice(double amount) {
        this.tf_AllRentPrice.setText(String.valueOf(amount));
    }

    public void setTf_AllDrinksEUR(double amount) {
        this.tf_AllDrinks.setText(String.valueOf(amount));
    }

    public void setTf_AllFoodEUR(double amount) {
        this.tf_AllFood.setText(String.valueOf(amount));
    }

    public void setTf_AllTotalCosts(double amount) {
        this.tf_AllTotalCosts.setText(String.valueOf(amount));
    }

    public void setTf_AllOutstandingPayment(double amount) {
        this.tf_AllOutstandingPayment.setText(String.valueOf(amount));
    }

    public void setTf_Deposite(double amount) {
        this.tf_Deposite.setText(String.valueOf(amount));
    }

    public void setTf_AllAlreadyPaid(double amount) {
        this.tf_AllAllreadyPaid.setText(String.valueOf(amount));
    }

}