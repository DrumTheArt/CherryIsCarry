package com.wachs.main.viewLayer;

import javax.swing.*;
import java.awt.*;

public class PanelForAllCosts extends JPanel {

    private JPanel panelAllCosts;
    
    private JTextField tfHousePrice;
    private JTextField tfDrinkCosts;
    private JTextField tfFoodCosts;
    private JTextField tfAllCosts;
    private JTextField tfAlreadyPaid;


    public PanelForAllCosts(){

        panelAllCosts = new JPanel(new GridLayout(2,5));
    }

    public JPanel getPanelForAllCosts(){

        tfHousePrice = new JTextField();
        tfDrinkCosts = new JTextField();
        tfFoodCosts = new JTextField();
        tfAllCosts = new JTextField();
        tfAlreadyPaid = new JTextField();


        JLabel lbHousePrice = new JLabel(UILabelNames.ALL_HOUSE_PRICE_label);
        lbHousePrice.setPreferredSize(new Dimension(150,30));
        lbHousePrice.setHorizontalAlignment(SwingConstants.CENTER);
        lbHousePrice.setVerticalAlignment(SwingConstants.CENTER);
        tfHousePrice = new JTextField("1333,50 EUR (spend)");
        tfHousePrice.setHorizontalAlignment(SwingConstants.CENTER);
        tfHousePrice.setPreferredSize(new Dimension(150,30));
        tfHousePrice.setBackground(Color.lightGray);
        tfHousePrice.setEditable(false);

        JLabel lbDrinkCosts = new JLabel(UILabelNames.ALL_DRINKS_PIRCE_label);
        lbDrinkCosts.setPreferredSize(new Dimension(150,30));
        lbDrinkCosts.setHorizontalAlignment(SwingConstants.CENTER);
        lbDrinkCosts.setVerticalAlignment(SwingConstants.CENTER);
        tfDrinkCosts = new JTextField("460,50 EUR (toPay)");
        tfDrinkCosts.setHorizontalAlignment(SwingConstants.CENTER);
        tfDrinkCosts.setPreferredSize(new Dimension(150,30));
        tfDrinkCosts.setBackground(Color.lightGray);
        tfDrinkCosts.setEditable(false);

        JLabel lbFoodCosts = new JLabel(UILabelNames.ALL_Food_PRICE_label);
        lbFoodCosts.setPreferredSize(new Dimension(150,30));
        lbFoodCosts.setHorizontalAlignment(SwingConstants.CENTER);
        lbFoodCosts.setVerticalAlignment(SwingConstants.CENTER);
        tfFoodCosts = new JTextField("340,50 EUR (toPay)");
        tfFoodCosts.setHorizontalAlignment(SwingConstants.CENTER);
        tfFoodCosts.setPreferredSize(new Dimension(150,30));
        tfFoodCosts.setBackground(Color.lightGray);
        tfFoodCosts.setEditable(false);

        JLabel lbAllCosts = new JLabel(UILabelNames.ALL_COSTS_PRICE_label);
        lbAllCosts.setPreferredSize(new Dimension(150,30));
        lbAllCosts.setHorizontalAlignment(SwingConstants.CENTER);
        lbAllCosts.setVerticalAlignment(SwingConstants.CENTER);
        tfAllCosts = new JTextField("2622,50 EUR (toPay)");
        tfAllCosts.setHorizontalAlignment(SwingConstants.CENTER);
        tfAllCosts.setPreferredSize(new Dimension(150,30));
        tfAllCosts.setBackground(Color.lightGray);
        tfAllCosts.setEditable(false);

        JLabel lbAlreadyPaid = new JLabel(UILabelNames.ALL_RENT_TOPAY_label);
        lbAlreadyPaid.setPreferredSize(new Dimension(150,30));
        lbAlreadyPaid.setHorizontalAlignment(SwingConstants.CENTER);
        lbAlreadyPaid.setVerticalAlignment(SwingConstants.CENTER);
        tfAlreadyPaid = new JTextField("326,50 EUR (toPay)");
        tfAlreadyPaid.setHorizontalAlignment(SwingConstants.CENTER);
        tfAlreadyPaid.setPreferredSize(new Dimension(150,30));
        tfAlreadyPaid.setBackground(Color.lightGray);
        tfAlreadyPaid.setEditable(false);

        panelAllCosts.add(lbHousePrice);
        panelAllCosts.add(lbDrinkCosts);
        panelAllCosts.add(lbFoodCosts);
        panelAllCosts.add(lbAllCosts);
        panelAllCosts.add(lbAlreadyPaid);

        panelAllCosts.add(tfHousePrice);
        panelAllCosts.add(tfDrinkCosts);
        panelAllCosts.add(tfFoodCosts);
        panelAllCosts.add(tfAllCosts);
        panelAllCosts.add(tfAlreadyPaid);

        panelAllCosts.setVisible(true);

        return panelAllCosts;

    }

    public JTextField getTfHousePrice() {
        return tfHousePrice;
    }

    public void setTfHousePrice(JTextField tfHousePrice) {
        this.tfHousePrice = tfHousePrice;
    }

    public JTextField getTfDrinkCosts() {
        return tfDrinkCosts;
    }

    public void setTfDrinkCosts(JTextField tfDrinkCosts) {
        this.tfDrinkCosts = tfDrinkCosts;
    }

    public JTextField getTfFoodCosts() {
        return tfFoodCosts;
    }

    public void setTfFoodCosts(JTextField tfFoodCosts) {
        this.tfFoodCosts = tfFoodCosts;
    }

    public JTextField getTfAllCosts() {
        return tfAllCosts;
    }

    public void setTfAllCosts(JTextField tfAllCosts) {
        this.tfAllCosts = tfAllCosts;
    }

    public JTextField getTfAlreadyPaid() {
        return tfAlreadyPaid;
    }

    public void setTfAlreadyPaid(JTextField tfAlreadyPaid) {
        this.tfAlreadyPaid = tfAlreadyPaid;
    }
}