package com.wachs.testing.stubs;

import com.wachs.main.businessObjects.Prepaid;
import com.wachs.main.dataAcess.DAO.PrepaidDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class StubsPrepaidDAO implements PrepaidDAO {

    private Prepaid alphaPrepaid;
    private Prepaid prepaidOne;
    private Prepaid prepaidTwo;
    private ArrayList<Prepaid> listOfPrepaid;

    public StubsPrepaidDAO() {

        listOfPrepaid = new ArrayList<Prepaid>();
        alphaPrepaid = new Prepaid();
        prepaidOne = new Prepaid();
        listOfPrepaid.add(alphaPrepaid);
        listOfPrepaid.add(prepaidOne);
    }

    @Override
    public ArrayList readAllData() throws SQLException, ClassNotFoundException {

        return listOfPrepaid;
    }

    @Override
    public Prepaid findOneData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        return this.alphaPrepaid;
    }

    @Override
    public void insertData(int id_guest, int id_house, double prepaid) throws SQLException, ClassNotFoundException {

        prepaidTwo = new Prepaid(1,prepaid,id_guest, id_house);
        listOfPrepaid.add(prepaidTwo);
    }

    @Override
    public void updateData(int id_guest, int id_house, double newPrepaid) throws SQLException, ClassNotFoundException {

        this.alphaPrepaid.setPrepaid(newPrepaid);
    }

    @Override
    public void deleteData(int id_guest, int id_house) throws SQLException, ClassNotFoundException {

        this.alphaPrepaid.setPrepaid(0);
        this.alphaPrepaid.setId_guest(0);
        this.alphaPrepaid.setId_house(0);
        this.alphaPrepaid.setPK_id(0);
    }

}