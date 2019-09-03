package com.wachs.main.MVcontroller;

import com.wachs.main.Models.GuestModel;
import com.wachs.main.Models.ProjectModel;
import com.wachs.main.UserInterfaces.GUIDialogViews.DialogEditGuestView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControllerEditGuest {

    private GuestModel guestModel;
    private ProjectModel projectModel;
    private DialogEditGuestView editView;
    private Stage stage;
    
    ControllerEditGuest(ProjectModel project, GuestModel guestToEdit) {

        this.projectModel = project;
        this.guestModel = guestToEdit;
        this.editView = new DialogEditGuestView();
        this.stage = editView.display();
        this.editView.btnDeleteGuest(new BtnDeleteGuest());
        this.editView.btnSaveAll(new BtnSaveAll());
        this.editView.btnSaveExpenses(new BtnSaveExpenses());
        bindingGuestDetails();

    }


    private void bindingGuestDetails() {

        editView.set_GuestNightsCount(guestModel.getSleepOverSelectedGuest());
        editView.set_GuestDrinksCount(guestModel.getDrinksSelectedGuestCount());
        editView.set_GuestFoodCount(guestModel.getFoodSelectedGuestCount());
        editView.set_PrepaidEUR(guestModel.getPrepaidSelectedGuestEUR());
        editView.set_GuestOtherExpensesEUR(guestModel.getAllOtherExpensesSelectedProjectHaveToPayBySelectedGuestEUR());
        editView.set_GuestFoodExpensesEUR(guestModel.getAllFoodExpensesSelectedProjectSelectedGuestEUR());
        editView.set_GuestDrinksExpensesEUR(guestModel.getAllDrinksExpensesSelectedProjectSelectedGuestEUR());
    }


    class BtnSaveExpenses implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            //newSaveExpenses
            editView.display().hide();
        }
    }

    class BtnDeleteGuest implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            //deleteGuest
            editView.display().hide();
        }
    }

    class BtnSaveAll implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            //saveAllData
            editView.display().hide();
        }
    }
}