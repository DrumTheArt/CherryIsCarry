package com.wachs.main.viewLayerJavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewGUI extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("NewGUI.fxml"));
        primaryStage.setTitle("CherryIsCarry");
        primaryStage.setScene(new Scene(root, 1500, 700));
        primaryStage.show();
    }


}
