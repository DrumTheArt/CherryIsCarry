package com.wachs.main.UserInterfaces.GUIElementsGenerators;

import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

public class CreateGUITextfield {


    public CreateGUITextfield() {

    }

    public TextField createTextfield(int size, String toolTip, String setStyle, boolean editable) {

        TextField newTextField = new TextField();
        newTextField.setPrefWidth(size);
        newTextField.setTooltip(new Tooltip(toolTip));
        newTextField.setStyle(setStyle);
        newTextField.setEditable(editable);

        return newTextField;
    }
}