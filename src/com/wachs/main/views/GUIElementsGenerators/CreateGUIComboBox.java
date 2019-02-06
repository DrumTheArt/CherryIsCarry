package com.wachs.main.views.GUIElementsGenerators;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;

public class CreateGUIComboBox {

    public CreateGUIComboBox() {
    }

    public ComboBox createComboBox(int size, String toolTip, ObservableList<String> comboBoxModel) {

        ComboBox newComboBox = new ComboBox(comboBoxModel);
        newComboBox.setPrefWidth(size);
        newComboBox.setTooltip(new Tooltip(toolTip));

        return newComboBox;
    }
}