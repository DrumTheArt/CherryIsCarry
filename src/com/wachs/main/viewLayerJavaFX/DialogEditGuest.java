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
        HBox_BTN_Regular = createHBox(10, 20, 20, 10, 20);

        btnSaveAll = createBtn(GUINaming.BTN_SAVE_ALLDATA, GUISourceIcons.sourceSaveData, GUIProperties.BTN_COLOR_BLUELIGHT, GUINaming.TT_BTN_SAVE_GUEST);

        //Button Delete Guest
        btnDeleteGuest = createBtn(GUINaming.BTN_DELETE_GUEST, GUISourceIcons.sourceDeleteGuest, GUIProperties.BTN_COLOR_BLUELIGHT, GUINaming.TT_BTN_DELETE_GUEST);

        HBox_BTN_Regular.getChildren().addAll(btnSaveAll, btnDeleteGuest);

        //Button Save Expenses
        btnSaveExpenses = createBtn(GUINaming.BTN_SAVE_EXPENSE, GUISourceIcons.sourceSaveExpenses, GUIProperties.BTN_COLOR_RED, GUINaming.TT_BTN_DELETE_GUEST);

        //Third Row Labels & TextFields for GuestDetails
        GridForGuestDetails = new GridPane();


        HBox_LB_AreaGuests = createHBox(10,10,20,0,20);

        lb_GuestNights = createLabel(GUINaming.LB_GUEST_NIGHTS, GUIProperties.SIZE_GUI_ELEMENTS,GUIProperties.FONT_BOLD);
        lb_GuestDrinks = createLabel(GUINaming.LB_GUEST_DRINKS, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestFood = createLabel(GUINaming.LB_GUEST_FOOD, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestPrepaid = createLabel(GUINaming.LB_GUEST_ALREADY_PAID, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);


        HBox_LB_AreaGuests.getChildren().addAll(lb_GuestNights, lb_GuestDrinks, lb_GuestFood, lb_GuestPrepaid);

        HBox_TF_AreaGuests = createHBox(10, 4, 20, 10, 20);

        tf_GuestNights = createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_NIGHTS, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_GuestDrinks = createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_DRINKS_EUR, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_GuestFood = createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_FOOD_EUR, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_prepaid = createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_ALREADY_PAID, GUIProperties.TEXTFIELD_DESIGN, true);


        HBox_TF_AreaGuests.setAlignment(Pos.BOTTOM_CENTER);
        HBox_TF_AreaGuests.getChildren().addAll(tf_GuestNights, tf_GuestDrinks, tf_GuestFood, tf_prepaid);

        GridPane.setConstraints(HBox_LB_AreaGuests, 1, 1);
        GridPane.setConstraints(HBox_TF_AreaGuests, 1, 2);
        GridForGuestDetails.setAlignment(Pos.BOTTOM_CENTER);
        GridForGuestDetails.getChildren().addAll(HBox_LB_AreaGuests, HBox_TF_AreaGuests);


        //Fourth Row Labels & TextFields for AllDetails
        GridForExpensesDetails = new GridPane();

        HBox_LB_AreaExpenses = createHBox(10, 40, 20, 0, 20);

        lb_GuestExpensePrice = createLabel(GUINaming.LB_GUEST_EXPENSE_PRICE, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestExpenseReason = createLabel(GUINaming.LB_GUEST_EXPENSE_REASON, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);
        lb_GuestExpenseWhen = createLabel(GUINaming.LB_GUEST_EXPENSE_WHEN, GUIProperties.SIZE_GUI_ELEMENTS, GUIProperties.FONT_BOLD);

        HBox_LB_AreaExpenses.setAlignment(Pos.BOTTOM_CENTER);
        HBox_LB_AreaExpenses.getChildren().addAll(lb_GuestExpensePrice, lb_GuestExpenseReason, lb_GuestExpenseWhen);


        HBox_TF_AreaExpenses = createHBox(10, 4, 20, 10, 20);

        tf_GuestExpensesPrice = createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_EXPENSE_PRICE, GUIProperties.TEXTFIELD_DESIGN, true );
        tf_GuestExpensesReason = createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_EXPENSE_REASON, GUIProperties.TEXTFIELD_DESIGN, true);
        tf_GuestExpensesWhen = createTextfield(GUIProperties.SIZE_GUI_ELEMENTS, GUINaming.TT_TF_GUEST_EXPENSE_WHEN, GUIProperties.TEXTFIELD_DESIGN,true);


        HBox_TF_AreaExpenses.getChildren().addAll(tf_GuestExpensesPrice, tf_GuestExpensesReason, tf_GuestExpensesWhen);

        //Fifth Row
        HBox_BTN_SaveExpense = createHBox(10, 20, 20, 10, 20);

        HBox_BTN_SaveExpense.setAlignment(Pos.BOTTOM_CENTER);
        HBox_BTN_SaveExpense.getChildren().add(btnSaveExpenses);

        GridPane.setConstraints(HBox_LB_AreaExpenses, 1, 1);
        GridPane.setConstraints(HBox_TF_AreaExpenses, 1, 2);
        GridForExpensesDetails.setAlignment(Pos.BOTTOM_CENTER);
        GridForExpensesDetails.getChildren().addAll(HBox_LB_AreaExpenses, HBox_TF_AreaExpenses);

        //Sixth Row
        HBox_LIST_Expense = createHBox(10, 4, 20, 10,20);

        tableExpenses = createTable("Amount", "Reason", "Date");

        HBox_LIST_Expense.setAlignment(Pos.BOTTOM_CENTER);
        HBox_LIST_Expense.getChildren().add(tableExpenses);

        verticalBox.getChildren().addAll(HBox_BTN_Regular, GridForGuestDetails, GridForExpensesDetails, HBox_BTN_SaveExpense, HBox_LIST_Expense);

        Scene scene = new Scene(verticalBox, 700, 700);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    private HBox createHBox(int spacing, int top, int right, int bottom, int left) {

        HBox newHBox = new HBox();
        newHBox.setSpacing(spacing);
        newHBox.setPadding(new Insets(top, right, bottom, left));

        return newHBox;
    }

    private TextField createTextfield(int size, String toolTip, String setStyle, boolean editable) {

        TextField newTextField = new TextField();
        newTextField.setPrefWidth(size);
        newTextField.setTooltip(new Tooltip(toolTip));
        newTextField.setStyle(setStyle);
        newTextField.setEditable(editable);

        return newTextField;
    }

    private Label createLabel(String labelName, int sizeWidth, String front) {

        Label newLabel = new Label();
        newLabel.setText(labelName);
        newLabel.setPrefWidth(sizeWidth);
        newLabel.setStyle(front);

        return newLabel;
    }

    private Button createBtn(String btnName, String btnIconSourcePath, String btnColor, String btnToolTip) {

        //DEPENDECY INJECTION HIER TROTZDEM NÖTIG ... NEW OPERATOR
        Image ButtonImageSaveData = new Image(getClass().getClassLoader().getResourceAsStream(btnIconSourcePath));
        Button newButton = new Button(btnName, new ImageView(ButtonImageSaveData));
        newButton.setStyle(btnColor);
        newButton.setTooltip(new Tooltip(btnToolTip));
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
