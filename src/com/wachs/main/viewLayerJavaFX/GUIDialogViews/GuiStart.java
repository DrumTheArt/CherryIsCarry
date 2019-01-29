package com.wachs.main.viewLayerJavaFX.GUIDialogViews;

import javafx.application.Application;

import javafx.stage.Stage;

import java.net.URISyntaxException;

public class GuiStart extends Application {

    DialogMainGuiView newMainDialog;


    public void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws URISyntaxException {

       Stage newStage = new DialogMainGuiView().displayMainGui();

    }
}