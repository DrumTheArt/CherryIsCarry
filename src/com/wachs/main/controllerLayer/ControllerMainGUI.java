package com.wachs.main.controllerLayer;

import com.wachs.main.models.AllGuestsModel;
import com.wachs.main.models.GuestModel;
import com.wachs.main.views.GUIDialogViews.DialogMainGuiView;

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

    private void bindingAllGuest(){

        view.setTf_AllRentPrice(modelAllGuest.getRentProject());
        view.setTf_AllOutstandingPayment(modelAllGuest.getOutstandingPayments());
        view.setTf_AllTotalCosts(modelAllGuest.getTotalCostsAll());
        view.setTf_AllDrinksEUR(modelAllGuest.getDrinksAllGuests());
        view.setTf_AllFoodEUR(modelAllGuest.getFoodAllGuests());
        view.setTf_AllAlreadyPaid(modelAllGuest.getAllPrepaid());
        view.setTf_Deposite(modelAllGuest.getDepositeProject());
    }

    private void bindingOneGuest() {

        view.setTf_GuestNights(modelOneGuest.getSleepOver());
        view.setTf_GuestNightsEUR(modelOneGuest.getSleepOverEUR());
        view.setTf_GuestDrinks(modelOneGuest.getDrinksCount());
        view.setTf_GuestDrinksEUR(modelOneGuest.getDrinksEUR());
        view.setTf_GuestFood(modelOneGuest.getFoodCount());
        view.setTf_GuestFoodEUR(modelOneGuest.getFoodEUR());
        view.setTf_GuestTotalCosts(modelOneGuest.getTotalCost());
        view.setTf_GuestAlreadyPaid(modelOneGuest.getAlreadyPaid());
        view.setTf_StillToPay(modelOneGuest.getStillToPay());
    }
}

