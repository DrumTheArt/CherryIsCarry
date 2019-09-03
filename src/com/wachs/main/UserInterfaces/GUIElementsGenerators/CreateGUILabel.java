package com.wachs.main.UserInterfaces.GUIElementsGenerators;

import javafx.scene.control.Label;

public class CreateGUILabel {

    public CreateGUILabel() {

    }

    public Label createLabel(String labelName, int sizeWidth, String front) {

        Label newLabel = new Label();
        newLabel.setText(labelName);
        newLabel.setPrefWidth(sizeWidth);
        newLabel.setStyle(front);

        return newLabel;
    }
}