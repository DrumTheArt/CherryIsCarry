package com.wachs.main.dataAccess.DAO;

import java.util.ArrayList;

public interface OtherExpensesDAO {

    ArrayList findOtherExpensesByOneGuest(int idGuest, int idProject);

    ArrayList findAllOtherExpensesByOneProject(int idProject);

    void deleteOtherExpensesForOneGuest(int idGuest, int idProject, double price, String reason, String when);

    void updateOtherExpensesForOneGuest(int idGuest, int idProject, double price, String reason, String when, double newPrice, String newReason, String newWhen);

    void insertOtherExpensesForOneGuest(int idGuest, int IdProject, double price, String reason, String when);

}
