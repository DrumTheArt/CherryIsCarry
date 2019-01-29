package com.wachs.main.viewLayerJavaFX.GUIDialogs;

import javafx.application.Application;

import javafx.stage.Stage;

import java.net.URISyntaxException;

public class GuiStart extends Application {

    DialogMain newMainDialog;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws URISyntaxException {

        DialogMain r = new DialogMain();
        Stage newStage = new DialogMain().displayMainGui();


    }
}