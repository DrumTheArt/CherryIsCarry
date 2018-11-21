package com.wachs.main.viewLayer.old;

import javax.swing.*;
import java.awt.*;

public class PanelForGuestDetails extends JPanel {

    private JPanel panelGuestData;
    private JPanel panelHoldingAllreadyPaidAndStillToPay;

    //PanelGuestData
    private JTextField tfNights;
    private JTextField tfNightsPrice;
    private JTextField tfDrinksDays;
    private JTextField tfDrinksPrice;
    private JTextField tfFoodDays;
    private JTextField tfFoodPrice;
    private JTextField tfAllCost;



    PanelForGuestDetails(){

        panelGuestData = new JPanel(new GridLayout(2,8));
    }


    public JPanel getPanelGuestData(){


        //Here the Model:
        String[] names = {"Basti", "Nils", "Paula"};

        JComboBox cbGuestName = new JComboBox(names);
        cbGuestName.setPreferredSize(new Dimension(150,30));

        JTextField tfNights= new JTextField();
        JTextField tfNightsPrice= new JTextField();
        JTextField tfDrinksDays= new JTextField();
        JTextField tfDrinksPrice= new JTextField();
        JTextField tfFoodDays= new JTextField();
        JTextField tfFoodPrice= new JTextField();
        JTextField tfAllCost= new JTextField();


        JLabel lbGuestName = new JLabel(UILabelNames.GUESTNAMES_label);
        lbGuestName.setPreferredSize(new Dimension(150,30));
        lbGuestName.setHorizontalAlignment(SwingConstants.CENTER);
        lbGuestName.setVerticalAlignment(SwingConstants.CENTER);

        JLabel lbNights = new JLabel(UILabelNames.GUEST_NIGHTS_label);
        lbNights.setPreferredSize(new Dimension(150,30));
        lbNights.setHorizontalAlignment(SwingConstants.CENTER);
        lbNights.setVerticalAlignment(SwingConstants.CENTER);
        tfNights = new JTextField("8 (Nights)");
        tfNights.setHorizontalAlignment(SwingConstants.CENTER);
        tfNights.setPreferredSize(new Dimension(150,30));
        tfNights.setEditable(false);

        JLabel lbNightsPrice = new JLabel(UILabelNames.GUEST_NIGHTS_PRICE_label);
        lbNightsPrice.setPreferredSize(new Dimension(150,30));
        lbNightsPrice.setHorizontalAlignment(SwingConstants.CENTER);
        lbNightsPrice.setVerticalAlignment(SwingConstants.CENTER);
        tfNightsPrice = new JTextField("13,50 EUR (Nights)");
        tfNightsPrice.setHorizontalAlignment(SwingConstants.CENTER);
        tfNightsPrice.setPreferredSize(new Dimension(150,30));
        tfNightsPrice.setEditable(false);

        JLabel lbDrinksDays = new JLabel(UILabelNames.GUEST_DRINKS_DAYS_label);
        lbDrinksDays.setPreferredSize(new Dimension(150,30));
        lbDrinksDays.setHorizontalAlignment(SwingConstants.CENTER);
        lbDrinksDays.setVerticalAlignment(SwingConstants.CENTER);
        tfDrinksDays = new JTextField("8Days (Drinks)");
        tfDrinksDays.setHorizontalAlignment(SwingConstants.CENTER);
        tfDrinksDays.setPreferredSize(new Dimension(150,30));
        tfDrinksDays.setEditable(false);

        JLabel lbDrinksPrice = new JLabel(UILabelNames.GUEST_DRINKS_PRICE_label);
        lbDrinksPrice.setPreferredSize(new Dimension(150,30));
        lbDrinksPrice.setHorizontalAlignment(SwingConstants.CENTER);
        lbDrinksPrice.setVerticalAlignment(SwingConstants.CENTER);
        tfDrinksPrice = new JTextField("13,50 EUR (Drinks)");
        tfDrinksPrice.setHorizontalAlignment(SwingConstants.CENTER);
        tfDrinksPrice.setPreferredSize(new Dimension(150,30));
        tfDrinksPrice.setEditable(false);

        JLabel lbFoodDays = new JLabel(UILabelNames.GUEST_FOOD_DAYS_label);
        lbFoodDays.setPreferredSize(new Dimension(150,30));
        lbFoodDays.setHorizontalAlignment(SwingConstants.CENTER);
        lbFoodDays.setVerticalAlignment(SwingConstants.CENTER);
        tfFoodDays = new JTextField("8Days (Food)");
        tfFoodDays.setHorizontalAlignment(SwingConstants.CENTER);
        tfFoodDays.setPreferredSize(new Dimension(150,30));
        tfFoodDays.setEditable(false);

        JLabel lbFoodPrice = new JLabel(UILabelNames.GUEST_FOOD_PRICE_label);
        lbFoodPrice.setPreferredSize(new Dimension(150,30));
        lbFoodPrice.setHorizontalAlignment(SwingConstants.CENTER);
        lbFoodPrice.setVerticalAlignment(SwingConstants.CENTER);
        tfFoodPrice = new JTextField("13,50 EUR (Food)");
        tfFoodPrice.setHorizontalAlignment(SwingConstants.CENTER);
        tfFoodPrice.setPreferredSize(new Dimension(150,30));
        tfFoodPrice.setEditable(false);

        JLabel lbAllCost = new JLabel(UILabelNames.GUEST_ALLCOST_label);
        lbAllCost.setPreferredSize(new Dimension(150,30));
        lbAllCost.setHorizontalAlignment(SwingConstants.CENTER);
        lbAllCost.setVerticalAlignment(SwingConstants.CENTER);
        tfAllCost = new JTextField("26,50 EUR (AllCosts)");
        tfAllCost.setHorizontalAlignment(SwingConstants.CENTER);
        tfAllCost.setPreferredSize(new Dimension(150,30));
        tfAllCost.setEditable(false);

        panelGuestData.add(lbGuestName);
        panelGuestData.add(lbNights);
        panelGuestData.add(lbNightsPrice);
        panelGuestData.add(lbDrinksDays);
        panelGuestData.add(lbDrinksPrice);
        panelGuestData.add(lbFoodDays);
        panelGuestData.add(lbFoodPrice);
        panelGuestData.add(lbAllCost);

        panelGuestData.add(cbGuestName);
        panelGuestData.add(tfNights);
        panelGuestData.add(tfNightsPrice);
        panelGuestData.add(tfDrinksDays);
        panelGuestData.add(tfDrinksPrice);
        panelGuestData.add(tfFoodDays);
        panelGuestData.add(tfFoodPrice);
        panelGuestData.add(tfAllCost);


        panelGuestData.setVisible(true);

        return panelGuestData;

    }


    public String getNights(){
            return this.tfNights.getText();
    }

    public void setNights(String nights){
            this.tfNights.setText(nights);
    }

    public String getNightPrice(){
        return this.tfNightsPrice.getText();
    }

    public void setNightPrice(String nightsPrice){
        this.tfNightsPrice.setText(nightsPrice);
    }

    public String getDrinksDays(){
        return this.tfDrinksDays.getText();
    }

    public void setDrinksDays(String days){
        this.tfDrinksDays.setText(days);
    }

    public String getDrinksPrice(){
        return this.tfDrinksPrice.getText();
    }

    public void setDrinksPrice(String drinksPrice){
        this.tfDrinksPrice.setText(drinksPrice);
    }

    public String getFoodDays(){
        return this.tfFoodDays.getText();
    }

    public void setFoodDays(String foodDays){
        this.tfFoodDays.setText(foodDays);
    }

    public String getFoodPrice(){
        return this.tfFoodPrice.getText();
    }

    public void setFoodPrice(String foodPrice){
        this.tfFoodPrice.setText(foodPrice);
    }

    public String getAllCost(){
        return this.tfAllCost.getText();
    }

    public void setAllCost(String allCost){
        this.tfAllCost.setText(allCost);
    }



}
