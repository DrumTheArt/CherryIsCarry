package com.wachs.main.viewLayerJavaFX;

import com.wachs.main.viewLayerJavaFX.GUISetup.GUINaming;
import com.wachs.main.viewLayerJavaFX.GUISetup.GUIProperties;
import com.wachs.main.viewLayerJavaFX.GUISetup.GUISourceIcons;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
        HBox_BTN_Regular = new HBox();
        HBox_BTN_Regular.setSpacing(10);
        HBox_BTN_Regular.setPadding(new Insets(20, 20, 10, 20));

        btnSaveAll = createBtn(GUISourceIcons.sourceSaveData,GUIProperties.BTN_COLOR_BLUELIGHT,GUINaming.TT_BTN_SAVE_GUEST);

        //Button Delete Guest
        btnDeleteGuest = createBtn(GUISourceIcons.sourceDeleteGuest, GUIProperties.BTN_COLOR_BLUELIGHT, GUINaming.TT_BTN_DELETE_GUEST);

        HBox_BTN_Regular.getChildren().addAll(btnSaveAll, btnDeleteGuest);

        //Button Save Expenses
        btnSaveExpenses = createBtn(GUISourceIcons.sourceSaveExpenses, GUIProperties.BTN_COLOR_RED, GUINaming.TT_BTN_DELETE_GUEST);

        //Third Row Labels & TextFields for GuestDetails
        GridForGuestDetails = new GridPane();

        HBox_LB_AreaGuests = new HBox();
        HBox_LB_AreaGuests.setSpacing(10);
        HBox_LB_AreaGuests.setPadding(new Insets(10, 20, 0, 20));

        lb_GuestNights = new Label();
        lb_GuestNights.setText(GUINaming.LB_GUEST_NIGHTS);
        lb_GuestNights.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_GuestNights.setStyle(GUIProperties.FONT_BOLD);

        lb_GuestDrinks = new Label();
        lb_GuestDrinks.setText(GUINaming.LB_GUEST_DRINKS);
        lb_GuestDrinks.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_GuestDrinks.setStyle(GUIProperties.FONT_BOLD);

        lb_GuestFood = new Label();
        lb_GuestFood.setText(GUINaming.LB_GUEST_FOOD);
        lb_GuestFood.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_GuestFood.setStyle(GUIProperties.FONT_BOLD);

        lb_GuestPrepaid = new Label();
        lb_GuestPrepaid.setText(GUINaming.LB_GUEST_ALREADY_PAID);
        lb_GuestPrepaid.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_GuestPrepaid.setStyle(GUIProperties.FONT_BOLD);

        HBox_LB_AreaGuests.getChildren().addAll(lb_GuestNights, lb_GuestDrinks, lb_GuestFood, lb_GuestPrepaid);

        HBox_TF_AreaGuests = new HBox();
        HBox_TF_AreaGuests.setSpacing(10);
        HBox_TF_AreaGuests.setPadding(new Insets(4, 20, 10, 20));

        tf_GuestNights = new TextField("3 nights");
        tf_GuestNights.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_GuestNights.setTooltip(new Tooltip(GUINaming.TT_TF_GUEST_NIGHTS));
        tf_GuestNights.setStyle(GUIProperties.TEXTFIELD_DESIGN);

        tf_GuestDrinks = new TextField("120.25 EUR");
        tf_GuestDrinks.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_GuestDrinks.setTooltip(new Tooltip(GUINaming.TT_TF_GUEST_DRINKS_EUR));
        tf_GuestDrinks.setStyle(GUIProperties.TEXTFIELD_DESIGN);

        tf_GuestFood = new TextField();
        tf_GuestFood.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_GuestFood.setTooltip(new Tooltip(GUINaming.TT_TF_GUEST_FOOD_EUR));
        tf_GuestFood.setStyle(GUIProperties.TEXTFIELD_DESIGN);

        tf_prepaid = new TextField();
        tf_prepaid.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_prepaid.setTooltip(new Tooltip(GUINaming.TT_TF_GUEST_ALREADY_PAID));
        tf_prepaid.setStyle(GUIProperties.TEXTFIELD_DESIGN);


        HBox_TF_AreaGuests.setAlignment(Pos.BOTTOM_CENTER);
        HBox_TF_AreaGuests.getChildren().addAll(tf_GuestNights, tf_GuestDrinks, tf_GuestFood, tf_prepaid);

        GridPane.setConstraints(HBox_LB_AreaGuests, 1, 1);
        GridPane.setConstraints(HBox_TF_AreaGuests, 1, 2);
        GridForGuestDetails.setAlignment(Pos.BOTTOM_CENTER);
        GridForGuestDetails.getChildren().addAll(HBox_LB_AreaGuests, HBox_TF_AreaGuests);


        //Fourth Row Labels & TextFields for AllDetails
        GridForExpensesDetails = new GridPane();

        HBox_LB_AreaExpenses = new HBox();
        HBox_LB_AreaExpenses.setSpacing(10);
        HBox_LB_AreaExpenses.setPadding(new Insets(40, 20, 0, 20));

        lb_GuestExpensePrice = new Label();
        lb_GuestExpensePrice.setText(GUINaming.LB_GUEST_EXPENSE_PRICE);
        lb_GuestExpensePrice.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_GuestExpensePrice.setStyle(GUIProperties.FONT_BOLD);

        lb_GuestExpenseReason = new Label();
        lb_GuestExpenseReason.setText(GUINaming.LB_GUEST_EXPENSE_REASON);
        lb_GuestExpenseReason.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_GuestExpenseReason.setStyle(GUIProperties.FONT_BOLD);

        lb_GuestExpenseWhen = new Label();
        lb_GuestExpenseWhen.setText(GUINaming.LB_GUEST_EXPENSE_WHEN);
        lb_GuestExpenseWhen.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        lb_GuestExpenseWhen.setStyle(GUIProperties.FONT_BOLD);

        HBox_LB_AreaExpenses.setAlignment(Pos.BOTTOM_CENTER);
        HBox_LB_AreaExpenses.getChildren().addAll(lb_GuestExpensePrice, lb_GuestExpenseReason, lb_GuestExpenseWhen);


        HBox_TF_AreaExpenses = new HBox();
        HBox_TF_AreaExpenses.setSpacing(10);
        HBox_TF_AreaExpenses.setPadding(new Insets(4, 20, 10, 20));

        tf_GuestExpensesPrice = new TextField();
        tf_GuestExpensesPrice.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_GuestExpensesPrice.setTooltip(new Tooltip(GUINaming.TT_TF_GUEST_EXPENSE_PRICE));
        tf_GuestExpensesPrice.setStyle(GUIProperties.TEXTFIELD_DESIGN);
        tf_GuestExpensesReason = new TextField();
        tf_GuestExpensesReason.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_GuestExpensesReason.setTooltip(new Tooltip(GUINaming.TT_TF_GUEST_EXPENSE_REASON));
        tf_GuestExpensesReason.setStyle(GUIProperties.TEXTFIELD_DESIGN);
        tf_GuestExpensesWhen = new TextField();
        tf_GuestExpensesWhen.setPrefWidth(GUIProperties.SIZE_GUI_ELEMENTS);
        tf_GuestExpensesWhen.setTooltip(new Tooltip(GUINaming.TT_TF_GUEST_EXPENSE_WHEN));
        tf_GuestExpensesWhen.setStyle(GUIProperties.TEXTFIELD_DESIGN);


        HBox_TF_AreaExpenses.getChildren().addAll(tf_GuestExpensesPrice, tf_GuestExpensesReason, tf_GuestExpensesWhen);

        //Fifth Row
        HBox_BTN_SaveExpense = new HBox();
        HBox_BTN_SaveExpense.setSpacing(10);
        HBox_BTN_SaveExpense.setPadding(new Insets(20, 20, 10, 20));

        HBox_BTN_SaveExpense.setAlignment(Pos.BOTTOM_CENTER);
        HBox_BTN_SaveExpense.getChildren().add(btnSaveExpenses);

        GridPane.setConstraints(HBox_LB_AreaExpenses, 1, 1);
        GridPane.setConstraints(HBox_TF_AreaExpenses, 1, 2);
        GridForExpensesDetails.setAlignment(Pos.BOTTOM_CENTER);
        GridForExpensesDetails.getChildren().addAll(HBox_LB_AreaExpenses, HBox_TF_AreaExpenses);

        //Sixth Row
        HBox_LIST_Expense = new HBox();
        HBox_LIST_Expense.setSpacing(10);
        HBox_LIST_Expense.setPadding(new Insets(4, 20, 10, 20));

        tableExpenses = createTable("Amount", "Reason", "Date");

        HBox_LIST_Expense.setAlignment(Pos.BOTTOM_CENTER);
        HBox_LIST_Expense.getChildren().add(tableExpenses);

        verticalBox.getChildren().addAll(HBox_BTN_Regular, GridForGuestDetails, GridForExpensesDetails, HBox_BTN_SaveExpense, HBox_LIST_Expense);

        Scene scene = new Scene(verticalBox, 700, 700);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    private Button createBtn(String source, String color, String toolTip) {

        //DEPENDECY INJECTION HIER TROTZDEM NÖTIG ... NEW OPERATOR
        Image ButtonImageSaveData = new Image(getClass().getClassLoader().getResourceAsStream(source));
        Button newButton = new Button(GUINaming.BTN_SAVE_ALLDATA, new ImageView(ButtonImageSaveData));
        newButton.setStyle(color);
        newButton.setTooltip(new Tooltip(toolTip));
        newButton.setMaxWidth(Double.MAX_VALUE);

        return newButton;
    }

    private TableView createTable(String column1, String column2, String column3) {

        TableView newTable = new TableView();
        newTable.setEditable(false);
        newTable.setPrefSize(630, 500);

        TableColumn<Void, Void> amountColumn = new TableColumn<>(column1);
        TableColumn<Void, Void> reasonColumn = new TableColumn<>(column2);
        TableColumn<Void, Void> whenColumn = new TableColumn<>(column3);

        newTable.getColumns().add(amountColumn);
        newTable.getColumns().add(reasonColumn);
        newTable.getColumns().add(whenColumn);

        newTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        amountColumn.prefWidthProperty().bind(newTable.widthProperty().multiply(0.1));

        return newTable;
    }
}
