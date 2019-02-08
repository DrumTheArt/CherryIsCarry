package com.wachs.testing.stubs;

import com.wachs.main.businessObjects.Expense;
import com.wachs.main.dataAcess.DAO.ExpenseDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class StubsExpenseDAO implements ExpenseDAO {

    private ArrayList<Expense> AllExpensesSelectedGuestOne;
    private ArrayList<Expense> AllExpensesSelectedGuestTwo;
    private ArrayList<Expense> listOfExpensesAllGuests;
    private ArrayList<Expense> listOfExpensesOneGuests;
    private Expense expenseOneForGuestOne;
    private Expense expenseTwoForGuestOne;
    private Expense expenseOneForGuestTwo;
    private Expense expenseTwoForGuestTwo;

    public StubsExpenseDAO() throws SQLException, ClassNotFoundException {

        addTwoExpensesToTwoGuests();

        AllExpensesSelectedGuestOne = new ArrayList<Expense>();
        AllExpensesSelectedGuestTwo = new ArrayList<Expense>();

        listOfExpensesAllGuests = new ArrayList<Expense>();
        listOfExpensesOneGuests = new ArrayList<Expense>();
    }

    @Override
    public ArrayList fineAllDataToOneGuest(int id_guest, int id_house) {

        for (Expense e : listOfExpensesAllGuests) {

            if ((e.getId_guest() == id_guest) && (e.getId_house() == id_house)) {

                listOfExpensesOneGuests.add(e);
            }
        }

        return this.listOfExpensesOneGuests;
    }

    @Override
    public ArrayList readAllData() {

        return listOfExpensesAllGuests;
    }

    @Override
    public void deleteData(int id_guest, int id_house, double price, String reason, String when) {


        for (Expense e : listOfExpensesAllGuests) {

            if ((e.getId_guest() == id_guest) && (e.getId_house() == id_house) && (e.getREAL_price() == price) && (e.getTXT_reason() == reason) && (e.getWhen() == when)) {

                listOfExpensesAllGuests.remove(e);
            }
        }
    }

    @Override
    public void updateData(int id_guest, int id_house, double price, String reason, String when, double newPrice, String newReason, String newWhen) {


        for (Expense e : listOfExpensesAllGuests) {

            if ((e.getId_guest() == id_guest) && (e.getId_house() == id_house) && (e.getREAL_price() == price) && (e.getTXT_reason() == reason) && (e.getWhen() == when)) {

                e.setTXT_reason(newReason);
                e.setWhen(newWhen);
                e.setREAL_price(newPrice);
            }
        }

    }

    @Override
    public void insertData(int id_guest, int id_house, double price, String reason, String when) {

        Expense someExpense = new Expense(1, price, reason, when, id_guest, id_house);
        listOfExpensesAllGuests.add(someExpense);

    }

    private void addTwoExpensesToTwoGuests() throws SQLException, ClassNotFoundException {

        insertData(1, 1, 100, "buyingMilk", "01.01.2019");
        insertData(1, 1, 200, "buyingButter", "02.02.2019");
        insertData(2, 1, 100, "buyongToilettePaper", "03.03.2019");
        insertData(2, 1, 200, "buyingDrugs", "04.04.2019");

    }

}