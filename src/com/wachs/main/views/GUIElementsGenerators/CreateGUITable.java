package com.wachs.main.views.GUIElementsGenerators;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CreateGUITable {
    public CreateGUITable() {
    }

    public TableView createTable(String column1, String column2, String column3) {

        TableView newTable = new TableView();
        newTable.setEditable(false);
        newTable.setPrefSize(630, 500);

        TableColumn<Void, Void> amountColumn = new TableColumn<Void, Void>(column1);
        TableColumn<Void, Void> reasonColumn = new TableColumn<Void, Void>(column2);
        TableColumn<Void, Void> whenColumn = new TableColumn<Void, Void>(column3);

        newTable.getColumns().add(amountColumn);
        newTable.getColumns().add(reasonColumn);
        newTable.getColumns().add(whenColumn);

        newTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        amountColumn.prefWidthProperty().bind(newTable.widthProperty().multiply(0.1));

        return newTable;
    }
}