package com.wachs.main.views.GUIDialogViews;

import com.wachs.main.controllerLayer.ControllerMainGUI;
import com.wachs.main.models.AllGuestsModel;
import com.wachs.main.models.GuestModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class GuiStart extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        GuestModel modelOneGuest = new GuestModel("Frankreich", "Kim");

        AllGuestsModel modelAllGuest = new AllGuestsModel("Frankreich");
        DialogMainGuiView view = new DialogMainGuiView();

        ControllerMainGUI b = new ControllerMainGUI(view, modelOneGuest, modelAllGuest);

        primaryStage = b.startView();
        //primaryStage = view.displayMainGui();
        //primaryStage = new DialogMainGuiView().displayMainGui();
        //Stage dialogAddGuest = new DialogMainGuiView().displayMainGui();

    }
}