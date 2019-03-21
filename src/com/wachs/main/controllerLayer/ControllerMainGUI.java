package com.wachs.main.controllerLayer;

import com.wachs.main.models.AllGuestsModel;
import com.wachs.main.models.GuestModel;
import com.wachs.main.views.GUIDialogViews.DialogMainGuiView;
import javafx.stage.Stage;

public class ControllerMainGUI {

    private DialogMainGuiView view;
    private GuestModel modelOneGuest;
    private AllGuestsModel modelAllGuest;

    public ControllerMainGUI(DialogMainGuiView theView, GuestModel modelOneGuest, AllGuestsModel allGuestModel) {

        view = theView;
        this.modelOneGuest = modelOneGuest;
        modelAllGuest = allGuestModel;
        bindingAllGuest();
        bindingOneGuest();

    }

    public Stage startView() {
        return view.getDisplayMainGUIStage();

    }
    private void bindingAllGuest(){

        view.setTf_AllRentPrice(modelAllGuest.getRentProject());
        view.setTf_AllOutstandingPayment(modelAllGuest.getOutstandingPayments());
        view.setTf_AllTotalCosts(modelAllGuest.getTotalCostsAll());
        view.setTf_AllDrinksEUR(modelAllGuest.getDrinksAllGuests());
        view.setTf_AllFoodEUR(modelAllGuest.getFoodAllGuests());
        view.setTf_AllAlreadyPaid(modelAllGuest.getAllPrepaid());
        view.setTf_Deposite(modelAllGuest.getDepositeProject());
        view.setTf_AllOtherExpenses(modelAllGuest.getAllOtherExpenses());
    }

    private void bindingOneGuest() {

        view.setTf_GuestNights(modelOneGuest.getSleepOverSelectedGuest());
        view.setTf_GuestNightsEUR(modelOneGuest.getSleepOverSelectedGuestEUR());
        view.setTf_GuestDrinks(modelOneGuest.getDrinksSelectedGuestCount());
        view.setTf_GuestDrinksEUR(modelOneGuest.getDrinksSelectedGuestEUR());
        view.setTf_GuestFood(modelOneGuest.getFoodSelectedGuestCount());
        view.setTf_GuestFoodEUR(modelOneGuest.getFoodSelectedGuestEUR());
        view.setTf_GuestTotalCosts(modelOneGuest.getTotalCostSelectedGuestEUR());
        view.setTf_GuestAlreadyPaid(modelOneGuest.getAlreadyPaidSelectedGuestEUR());
        view.setTf_StillToPay(modelOneGuest.getStillToPaySelectedGuestEUR());
    }
}

