package com.wachs.testing.stubs;

import com.wachs.main.businessLayer.Expense;
import com.wachs.main.dataBaseLayer.DAO.ExpenseDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class StubsExpenseDAO implements ExpenseDAO {

    private ArrayList<Expense> alphaExpense;
    private Expense expenseOne;
    private Expense expenseTwo;
    private ArrayList<Expense> listOfExpenses;

    public StubsExpenseDAO() {

        listOfExpenses = new ArrayList<Expense>();
        alphaExpense = new ArrayList<Expense>();
        expenseOne = new Expense();
        listOfExpenses.add(alphaExpense);
        listOfExpenses.add(expenseOne);
    }

    @Override
    public ArrayList findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        return this.alphaExpense;
    }

    @Override
    public ArrayList readAllData() throws SQLException, ClassNotFoundException {

        return listOfExpenses;
    }

    @Override
    public void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        this.alphaExpense.setId_guest(0);
        this.alphaExpense.setId_house(0);
        this.alphaExpense.setPK_id(0);
        this.alphaExpense.setREAL_price(0);
        this.alphaExpense.setTXT_name("");
        this.alphaExpense.setWhen("");
    }

    @Override
    public void updateData(int id_guest, int id_house, double price, String reason, String when) throws SQLException, ClassNotFoundException {

        this.alphaExpense.setId_guest(id_guest);
        this.alphaExpense.setId_house(id_house);
        this.alphaExpense.setREAL_price(price);
        this.alphaExpense.setTXT_name(reason);
        this.alphaExpense.setWhen(when);
    }

    @Override
    public void insertData(int id_guest, int id_house, double price, String reason, String when) throws SQLException, ClassNotFoundException {

        expenseTwo = new Expense(1, price, reason, when, id_guest,id_house);
        listOfExpenses.add(expenseTwo);
    }
}