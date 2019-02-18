package com.wachs.main.dataAcess.DAO;

import java.util.ArrayList;

public interface ExpenseDAO {

    ArrayList findExpensesByOneGuest(int idGuest, int idProject);

    ArrayList findAllExpensesByOneProject(int idProject);

    void deleteExpensesForOneGuest(int idGuest, int idProject, double price, String reason, String when);

    void updateExpensesForOneGuest(int idGuest, int idProject, double price, String reason, String when, double newPrice, String newReason, String newWhen);

    void insertExpensesForOneGuest(int idGuest, int IdProject, double price, String reason, String when);

}
