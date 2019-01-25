package com.wachs.main.viewModelLayer;

import com.wachs.main.businessLayer.Food;
import com.wachs.main.dataBaseLayer.DAO.FoodDAO;
import com.wachs.main.dataBaseLayer.DAO.FoodDAOImpl;

import java.io.IOException;
import java.sql.SQLException;


    public class FoodModel {

        private FoodDAO newDAO;
        private Food foodSearchedGuest;

        FoodModel(int idGuest, int idHouse) throws SQLException, IOException, ClassNotFoundException {

            createModel(idGuest, idHouse);
        }

        private Food createModel(int idGuest, int idHouse) throws SQLException, IOException, ClassNotFoundException {

            newDAO = new FoodDAOImpl();
            foodSearchedGuest = newDAO.findOneData(idGuest, idHouse);

            return foodSearchedGuest;
        }

        public int getIdHouse(){

            return foodSearchedGuest.getId_house();

        }

        public int getIdGuest(){

            return foodSearchedGuest.getId_guest();

        }

        public int getNightCount(){

            return foodSearchedGuest.getNights();

        }

}
