package com.wachs.main.viewLayerJavaFX;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;

public class CreateGUIComboBox {

    public CreateGUIComboBox() {
    }

    public ComboBox createComboBox(int size, String toolTip) {

        ComboBox newComboBox = new ComboBox();
        newComboBox.setPrefWidth(size);
        newComboBox.setTooltip(new Tooltip(toolTip));

        return newComboBox;
    }
}