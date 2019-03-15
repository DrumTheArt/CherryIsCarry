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



        GuestModel modelOneGuest = new GuestModel("The project 2019", "Robert");

        AllGuestsModel modelAllGuest = new AllGuestsModel("The project 2019");
        DialogMainGuiView view = new DialogMainGuiView();

        ControllerMainGUI b = new ControllerMainGUI(view, modelOneGuest, modelAllGuest);

        primaryStage = b.startView();
        //primaryStage = view.displayMainGui();
        //primaryStage = new DialogMainGuiView().displayMainGui();
        //Stage dialogAddGuest = new DialogMainGuiView().displayMainGui();

    }
}