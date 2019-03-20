package com.wachs.main.views.GUIElementsGenerators;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CreateGUIButton {

    public CreateGUIButton() {
    }

    public Button createBtn(String btnName, String btnIconSourcePath, String btnColor, String btnToolTip) {

        Image ButtonImageSaveData = new Image(getClass().getClassLoader().getResourceAsStream(btnIconSourcePath));
        Button newButton = new Button(btnName, new ImageView(ButtonImageSaveData));
        newButton.setStyle(btnColor);
        newButton.setTooltip(new Tooltip(btnToolTip));
        newButton.setMaxWidth(Double.MAX_VALUE);

        return newButton;
    }
}