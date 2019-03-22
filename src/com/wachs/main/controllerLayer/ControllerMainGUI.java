package com.wachs.main.controllerLayer;

import com.wachs.main.models.AllGuestsModel;
import com.wachs.main.models.GuestModel;
import com.wachs.main.views.GUIDialogViews.DialogMainGuiView;
import javafx.stage.Stage;

public class ControllerMainGUI {

    private DialogMainGuiView viewMainGui;
    private GuestModel modelOneGuest;
    private AllGuestsModel modelAllGuest;

    public ControllerMainGUI(DialogMainGuiView theView, GuestModel modelOneGuest, AllGuestsModel allGuestModel) {

        viewMainGui = theView;
        this.modelOneGuest = modelOneGuest;
        modelAllGuest = allGuestModel;
        bindingAllGuest();
        bindingOneGuest();

    }

    public Stage startView() {
        return viewMainGui.getDisplayMainGUIStage();

    }
    private void bindingAllGuest(){

        viewMainGui.setTf_AllRentPrice(modelAllGuest.getRentProject());
        viewMainGui.setTf_AllOutstandingPayment(modelAllGuest.getOutstandingPayments());
        viewMainGui.setTf_AllTotalCosts(modelAllGuest.getTotalCostsAll());
        viewMainGui.setTf_AllDrinksEUR(modelAllGuest.getDrinksAllGuests());
        viewMainGui.setTf_AllFoodEUR(modelAllGuest.getFoodAllGuests());
        viewMainGui.setTf_AllAlreadyPaid(modelAllGuest.getAllPrepaid());
        viewMainGui.setTf_Deposite(modelAllGuest.getDepositeProject());
        viewMainGui.setTf_AllOtherExpenses(modelAllGuest.getAllOtherExpenses());
    }

    private void bindingOneGuest() {

        viewMainGui.setTf_GuestNights(modelOneGuest.getSleepOverSelectedGuest());
        viewMainGui.setTf_GuestNightsEUR(modelOneGuest.getSleepOverSelectedGuestEUR());
        viewMainGui.setTf_GuestDrinks(modelOneGuest.getDrinksSelectedGuestCount());
        viewMainGui.setTf_GuestDrinksEUR(modelOneGuest.getDrinksSelectedGuestEUR());
        viewMainGui.setTf_GuestFood(modelOneGuest.getFoodSelectedGuestCount());
        viewMainGui.setTf_GuestFoodEUR(modelOneGuest.getFoodSelectedGuestEUR());
        viewMainGui.setTf_GuestTotalCosts(modelOneGuest.getTotalCostSelectedGuestEUR());
        viewMainGui.setTf_GuestAlreadyPaid(modelOneGuest.getAlreadyPaidSelectedGuestEUR());
        viewMainGui.setTf_StillToPay(modelOneGuest.getStillToPaySelectedGuestEUR());
    }
}

