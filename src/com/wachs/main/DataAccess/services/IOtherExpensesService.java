package com.wachs.main.DataAccess.services;

import java.util.ArrayList;

public interface IOtherExpensesService {

    ArrayList fetchOtherExpensesOneGuest(int idGuest, int idProject);

    ArrayList fetchAllOtherExpensesOneProject(int idProject);

    void deleteOtherExpensesOneGuest(int idGuest, int idProject, double spend, String reason, String when);

    void updateOtherExpensesOneGuest(int idGuest, int idProject, double price, String reason, String when, double newPrice, String newReason, String newWhen);

    void insertOtherExpensesOneGuest(int idGuest, int IdProject, double price, String reason, String when);

}
