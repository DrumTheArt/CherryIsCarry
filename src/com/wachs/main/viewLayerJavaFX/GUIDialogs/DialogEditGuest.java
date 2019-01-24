package com.wachs.main.viewLayerJavaFX.GUIDialogs;

import com.wachs.main.viewLayerJavaFX.*;
import com.wachs.main.viewLayerJavaFX.GUISetup.GUINaming;
import com.wachs.main.viewLayerJavaFX.GUISetup.GUIProperties;
import com.wachs.main.viewLayerJavaFX.GUISetup.GUISourceIcons;
import javafx.application.Application;
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

import java.net.URISyntaxException;

public class DialogEditGuest extends Application {

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

    //AllTextFields
    private TextField tf_GuestExpensesPrice;
    private TextField tf_GuestExpensesReason;
    private TextField tf_GuestExpensesWhen;

    //AllLabelsGuest
    private Label lb_GuestNights;
    private Label lb_GuestDrinks;
    private Label lb_GuestFood;
    private Label lb_GuestPrepaid;

    //AllLabelsAll
    private Label lb_GuestExpensePrice;
    private Label lb_GuestExpenseReason;
    private Label lb_GuestExpenseWhen;

    //AllGrids
    private GridPane GridForGuestDetails;
    private GridPane GridForExpensesDetails;

    //AllLists
    private TableView tableExpenses;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws URISyntaxException {

        primaryStage.setTitle("CherryIsCarry --- Edit Guest Details");

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 0, 20, 20));

        //Holding all HBoxes
        verticalBox = new VBox();

        //First Row
        HBox_BTN_Regular = new CreateGUIHBox().CreateHBox(10, 20, 20, 10, 20);

        btnSaveAll = new CreateGUIButton().createBtn(GUINaming.BTN_SAVE_ALLDATA, GUISourceIcons.sourceSaveData, GUIProperties.BTN_COLOR_BLUELIGHT, GUINaming.TT_BTN_SAVE_GUEST);

        //Button Delete Guest
        btnDeleteGuest = new CreateGUIButton().createBtn(GUINaming.BTN_DELETE_GUEST, GUISourceIcons.sourceDeleteGuest, GUIProperties.BTN_COLOR_BLUELIGHT, GUINaming.TT_BTN_DELETE_GUEST);

        HBox_BTN_Regular.getChildren().addAll(btnSaveAll, btnDeleteGuest);

        //Button Save Expenses
        btnSaveExpenses = new CreateGUIButton().createBtn(GUINaming.BTN_SAVE_EXPENSE, GUISourceIcons.sourceSaveExpenses, GUIProperties.BTN_COLOR_RED, GUINaming.TT_BTN_SAVE_EXPENSE);

        //Third Row Labels & TextFields for GuestDetails
        GridForGuestDetails = new GridPane();

        HBox_LB_AreaGuests = new CreateGUIHBox().CreateHBox(10, 10, 20, 0, 20);


        lb_GuestNights = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_NIGHTS, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestDrinks = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_DRINKS, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestFood = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_FOOD, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestPrepaid = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_ALREADY_PAID, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);


        HBox_LB_AreaGuests.getChildren().addAll(lb_GuestNights, lb_GuestDrinks, lb_GuestFood, lb_GuestPrepaid);

        HBox_TF_AreaGuests = new CreateGUIHBox().CreateHBox(10, 4, 20, 10, 20);

        tf_GuestNights = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_NIGHTS, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_GuestDrinks = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_DRINKS_EUR, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_GuestFood = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_FOOD_EUR, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_prepaid = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_ALREADY_PAID, GUIProperties.TEXTFIELD_DESIGN, true);


        HBox_TF_AreaGuests.setAlignment(Pos.BOTTOM_CENTER);
        HBox_TF_AreaGuests.getChildren().addAll(tf_GuestNights, tf_GuestDrinks, tf_GuestFood, tf_prepaid);

        GridPane.setConstraints(HBox_LB_AreaGuests, 1, 1);
        GridPane.setConstraints(HBox_TF_AreaGuests, 1, 2);
        GridForGuestDetails.setAlignment(Pos.BOTTOM_CENTER);
        GridForGuestDetails.getChildren().addAll(HBox_LB_AreaGuests, HBox_TF_AreaGuests);


        //Fourth Row Labels & TextFields for AllDetails
        GridForExpensesDetails = new GridPane();

        HBox_LB_AreaExpenses = new CreateGUIHBox().CreateHBox(10, 40, 20, 0, 20);


        lb_GuestExpensePrice = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_EXPENSE_PRICE, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestExpenseReason = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_EXPENSE_REASON, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestExpenseWhen = new CreateGUILabel().createLabel(GUINaming.LB_GUEST_EXPENSE_WHEN, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);

        HBox_LB_AreaExpenses.setAlignment(Pos.BOTTOM_CENTER);
        HBox_LB_AreaExpenses.getChildren().addAll(lb_GuestExpensePrice, lb_GuestExpenseReason, lb_GuestExpenseWhen);


        HBox_TF_AreaExpenses = new CreateGUIHBox().CreateHBox(10, 4, 20, 10, 20);

        tf_GuestExpensesPrice = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_EXPENSE_PRICE, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_GuestExpensesReason = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_EXPENSE_REASON, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_GuestExpensesWhen = new CreateGUITextfield().createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_EXPENSE_WHEN, GUIProperties.TEXTFIELD_DESIGN, true);


        HBox_TF_AreaExpenses.getChildren().addAll(tf_GuestExpensesPrice, tf_GuestExpensesReason, tf_GuestExpensesWhen);

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

        Scene scene = new Scene(verticalBox, 700, 700);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

}
