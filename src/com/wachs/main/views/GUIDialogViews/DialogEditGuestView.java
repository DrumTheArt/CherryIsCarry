package com.wachs.main.views.GUIDialogViews;

import com.wachs.main.views.GUIElementsGenerators.*;
import com.wachs.main.views.GUISetup.GUINamingProperties;
import com.wachs.main.views.GUISetup.GUIProperties;
import com.wachs.main.views.GUISetup.GUISourceIcons;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DialogEditGuestView {

    //AllColumns
    private VBox verticalBox;

    // AllRows
    private HBox HBox_BTN_Regular;
    private HBox HBox_LB_AreaGuests;
    private HBox HBox_TF_AreaGuests;
    private HBox HBox_LB_AreaExpenses;
    private HBox HBox_TF_AreaExpenses;
    private HBox HBox_BTN_SaveExpense;
    private HBox HBox_LIST_Expense;

    //AllButtons
    private Button btnSaveAll;
    private Button btnDeleteGuest;
    private Button btnSaveExpenses;

    //AllTextFields
    private TextField tf_GuestNights;
    private TextField tf_GuestDrinks;
    private TextField tf_GuestFood;
    private TextField tf_prepaid;
    private TextField tf_GuestExpensesPrice;
    private TextField tf_GuestExpensesReason;
    private TextField tf_GuestExpensesWhen;
    private TextField tf_GuestDrinksExpensePrice;
    private TextField tf_GuestFoodExpensePrice;

    //AllLabelsGuest
    private Label lb_GuestNights;
    private Label lb_GuestDrinks;
    private Label lb_GuestFood;
    private Label lb_GuestPrepaid;

    //AllLabelsAll
    private Label lb_GuestFoodExpensePrice;
    private Label lb_GuestDrinksExpensePrice;
    private Label lb_GuestExpensePrice;
    private Label lb_GuestExpenseReason;
    private Label lb_GuestExpenseWhen;

    //AllGrids
    private GridPane GridForGuestDetails;
    private GridPane GridForExpensesDetails;

    //AllLists
    private TableView tableExpenses;

    public Stage display(){

        Stage dialogEditGuest = new Stage();

        dialogEditGuest.setTitle("CherryIsCarry --- Edit Guest Details");

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 0, 20, 20));

        //Holding all HBoxes
        verticalBox = new VBox();

        //First Row
        HBox_BTN_Regular = new CreateGUIHBox().CreateHBox(10, 20, 20, 10, 20);

        btnSaveAll = new CreateGUIButton().createBtn(GUINamingProperties.BTN_SAVE_ALLDATA, GUISourceIcons.sourceSaveData, GUIProperties.BTN_COLOR_BLUELIGHT, GUINamingProperties.TT_BTN_SAVE_GUEST);

        btnSaveAll.setOnAction(e -> {

            new DialogMainGuiView().displayMainGui();
            dialogEditGuest.close();

        });
        //Button Delete Guest
        btnDeleteGuest = new CreateGUIButton().createBtn(GUINamingProperties.BTN_DELETE_GUEST, GUISourceIcons.sourceDeleteGuest, GUIProperties.BTN_COLOR_BLUELIGHT, GUINamingProperties.TT_BTN_DELETE_GUEST);

        HBox_BTN_Regular.getChildren().addAll(btnSaveAll, btnDeleteGuest);

        //Button Save Expenses
        btnSaveExpenses = new CreateGUIButton().createBtn(GUINamingProperties.BTN_SAVE_EXPENSE, GUISourceIcons.sourceSaveExpenses, GUIProperties.BTN_COLOR_RED, GUINamingProperties.TT_BTN_SAVE_EXPENSE);

        //Third Row Labels & TextFields for GuestDetails
        GridForGuestDetails = new GridPane();

        HBox_LB_AreaGuests = new CreateGUIHBox().CreateHBox(10, 10, 20, 0, 20);

        lb_GuestNights = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_NIGHTS, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestDrinks = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_DRINKS, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestFood = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_FOOD, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestPrepaid = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_ALREADY_PAID, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);


        HBox_LB_AreaGuests.getChildren().addAll(lb_GuestNights, lb_GuestDrinks, lb_GuestFood, lb_GuestPrepaid);

        HBox_TF_AreaGuests = new CreateGUIHBox().CreateHBox(10, 4, 20, 10, 20);

        tf_GuestNights = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_NIGHTS, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_GuestDrinks = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_DRINKS, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_GuestFood = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_FOOD, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_prepaid = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_ALREADY_PAID, GUIProperties.TEXTFIELD_DESIGN, true);


        HBox_TF_AreaGuests.setAlignment(Pos.BOTTOM_CENTER);
        HBox_TF_AreaGuests.getChildren().addAll(tf_GuestNights, tf_GuestDrinks, tf_GuestFood, tf_prepaid);

        GridPane.setConstraints(HBox_LB_AreaGuests, 1, 1);
        GridPane.setConstraints(HBox_TF_AreaGuests, 1, 2);
        GridForGuestDetails.setAlignment(Pos.BOTTOM_CENTER);
        GridForGuestDetails.getChildren().addAll(HBox_LB_AreaGuests, HBox_TF_AreaGuests);


        //Fourth Row Labels & TextFields for AllDetails
        GridForExpensesDetails = new GridPane();

        HBox_LB_AreaExpenses = new CreateGUIHBox().CreateHBox(10, 40, 20, 0, 20);

        lb_GuestFoodExpensePrice = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_FOODEXPENSES, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestDrinksExpensePrice = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_DRINKSEXPENSES, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestExpensePrice = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_OTHEREXPENSES_PRICE, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestExpenseReason = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_OTHEREXPENSES_REASON, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestExpenseWhen = new CreateGUILabel().createLabel(GUINamingProperties.LB_GUEST_OTHEREXPENSES_WHEN, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);

        HBox_LB_AreaExpenses.setAlignment(Pos.BOTTOM_CENTER);
        HBox_LB_AreaExpenses.getChildren().addAll(lb_GuestFoodExpensePrice, lb_GuestDrinksExpensePrice, lb_GuestExpensePrice, lb_GuestExpenseReason, lb_GuestExpenseWhen);


        HBox_TF_AreaExpenses = new CreateGUIHBox().CreateHBox(10, 4, 20, 10, 20);

        tf_GuestDrinksExpensePrice = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_DRINKSEXPENSES, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_GuestFoodExpensePrice = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_FOODEXPENSES, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_GuestExpensesPrice = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_EXPENSE_PRICE, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_GuestExpensesReason = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_EXPENSE_REASON, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_GuestExpensesWhen = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINamingProperties.TT_TF_GUEST_EXPENSE_WHEN, GUIProperties.TEXTFIELD_DESIGN, true);


        HBox_TF_AreaExpenses.getChildren().addAll(tf_GuestDrinksExpensePrice, tf_GuestFoodExpensePrice, tf_GuestExpensesPrice, tf_GuestExpensesReason, tf_GuestExpensesWhen);

        //Fifth Row
        HBox_BTN_SaveExpense = new CreateGUIHBox().CreateHBox(10, 20, 20, 10, 20);

        HBox_BTN_SaveExpense.setAlignment(Pos.BOTTOM_CENTER);
        HBox_BTN_SaveExpense.getChildren().add(btnSaveExpenses);

        GridPane.setConstraints(HBox_LB_AreaExpenses, 1, 1);
        GridPane.setConstraints(HBox_TF_AreaExpenses, 1, 2);
        GridForExpensesDetails.setAlignment(Pos.BOTTOM_CENTER);
        GridForExpensesDetails.getChildren().addAll(HBox_LB_AreaExpenses, HBox_TF_AreaExpenses);

        //Sixth Row
        HBox_LIST_Expense = new CreateGUIHBox().CreateHBox(10, 4, 20, 10, 20);


        tableExpenses = new CreateGUITable().createTable("Amount", "Reason", "Date");

        HBox_LIST_Expense.setAlignment(Pos.BOTTOM_CENTER);
        HBox_LIST_Expense.getChildren().add(tableExpenses);

        verticalBox.getChildren().addAll(HBox_BTN_Regular, GridForGuestDetails, GridForExpensesDetails, HBox_BTN_SaveExpense, HBox_LIST_Expense);

        Scene scene = new Scene(verticalBox, 900, 700);

        dialogEditGuest.setOnCloseRequest(event -> {

            new DialogMainGuiView().displayMainGui();
            dialogEditGuest.close();

        });

        dialogEditGuest.setScene(scene);

        dialogEditGuest.show();

        return dialogEditGuest;

    }

    public TextField getTf_GuestNights() {
        return tf_GuestNights;
    }

    public void setTf_GuestNights(TextField tf_GuestNights) {
        this.tf_GuestNights = tf_GuestNights;
    }

    public TextField getTf_GuestDrinks() {
        return tf_GuestDrinks;
    }

    public void setTf_GuestDrinks(TextField tf_GuestDrinks) {
        this.tf_GuestDrinks = tf_GuestDrinks;
    }

    public TextField getTf_GuestFood() {
        return tf_GuestFood;
    }

    public void setTf_GuestFood(TextField tf_GuestFood) {
        this.tf_GuestFood = tf_GuestFood;
    }

    public TextField getTf_prepaid() {
        return tf_prepaid;
    }

    public void setTf_prepaid(TextField tf_prepaid) {
        this.tf_prepaid = tf_prepaid;
    }

    public TextField getTf_GuestExpensesPrice() {
        return tf_GuestExpensesPrice;
    }

    public void setTf_GuestExpensesPrice(TextField tf_GuestExpensesPrice) {
        this.tf_GuestExpensesPrice = tf_GuestExpensesPrice;
    }

    public TextField getTf_GuestExpensesReason() {
        return tf_GuestExpensesReason;
    }

    public void setTf_GuestExpensesReason(TextField tf_GuestExpensesReason) {
        this.tf_GuestExpensesReason = tf_GuestExpensesReason;
    }

    public TextField getTf_GuestExpensesWhen() {
        return tf_GuestExpensesWhen;
    }

    public void setTf_GuestExpensesWhen(TextField tf_GuestExpensesWhen) {
        this.tf_GuestExpensesWhen = tf_GuestExpensesWhen;
    }

    public GridPane getGridForGuestDetails() {
        return GridForGuestDetails;
    }

    public void setGridForGuestDetails(GridPane gridForGuestDetails) {
        GridForGuestDetails = gridForGuestDetails;
    }

    public GridPane getGridForExpensesDetails() {
        return GridForExpensesDetails;
    }

    public void setGridForExpensesDetails(GridPane gridForExpensesDetails) {
        GridForExpensesDetails = gridForExpensesDetails;
    }

    public TableView getTableExpenses() {
        return tableExpenses;
    }

    public void setTableExpenses(TableView tableExpenses) {
        this.tableExpenses = tableExpenses;
    }

}


