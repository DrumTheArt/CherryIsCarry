package com.wachs.main.viewLayerJavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        primaryStage.setTitle("CherryIsCarry");
        //primaryStage.setMaximized(true);


        Scene scene = new Scene(root, 1440, 900);
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);


        primaryStage.show();
        primaryStage.setMinWidth(1440);
        primaryStage.setMinHeight(900);
        primaryStage.setMaxWidth(1440);
        primaryStage.setMaxHeight(900);
    }
}
