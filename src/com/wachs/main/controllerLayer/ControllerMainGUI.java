package com.wachs.main.controllerLayer;

import com.wachs.main.models.AllGuestsModel;
import com.wachs.main.models.GuestModel;
import com.wachs.main.views.GUIDialogViews.DialogMainGuiView;

public class ControllerMainGUI {

    DialogMainGuiView view;
    GuestModel modelGuest;
    AllGuestsModel modelAllGuest;

    ControllerMainGUI(DialogMainGuiView theView, GuestModel theModel, AllGuestsModel allGuestModel) {

        view = theView;
        modelGuest = theModel;
        modelAllGuest = allGuestModel;
        bindingAllGuest();

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

}

