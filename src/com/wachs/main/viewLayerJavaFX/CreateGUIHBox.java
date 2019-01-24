package com.wachs.main.viewLayerJavaFX;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class CreateGUIHBox {

    public CreateGUIHBox() {
    }

    public HBox CreateHBox(int setSpacing, int top, int right, int bottom, int left) {

        HBox newHBox = new HBox();
        newHBox.setSpacing(setSpacing);
        newHBox.setPadding(new Insets(top, right, bottom, left));

        return newHBox;
    }
}