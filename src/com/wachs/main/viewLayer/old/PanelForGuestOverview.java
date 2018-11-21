package com.wachs.main.viewLayer.old;

import javax.swing.*;
import java.awt.*;

public class PanelForGuestOverview extends JPanel {

    private JPanel panelHoldingAllreadyPaidAndStillToPay;


    //panelHoldingAllreadyPaidAndStillToPay
    private JTextField tfSpend;
    private JTextField tfToPay;


    PanelForGuestOverview(){

        panelHoldingAllreadyPaidAndStillToPay = new JPanel(new GridLayout(2,2));
    }

    public JPanel getPanelForGuestOverview(){

        tfSpend = new JTextField();
        tfToPay = new JTextField();

        JLabel lbSpend = new JLabel(UILabelNames.GUEST_ALREADY_SPEND_label);
        lbSpend.setPreferredSize(new Dimension(150,30));
        lbSpend.setHorizontalAlignment(SwingConstants.CENTER);
        lbSpend.setVerticalAlignment(SwingConstants.CENTER);
        tfSpend = new JTextField("13,50 EUR (spend)");
        tfSpend.setHorizontalAlignment(SwingConstants.CENTER);
        tfSpend.setPreferredSize(new Dimension(150,30));
        tfSpend.setEditable(false);

        JLabel lbToPay = new JLabel(UILabelNames.GUEST_STILL_TOPAY_label);
        lbToPay.setPreferredSize(new Dimension(150,30));
        lbToPay.setHorizontalAlignment(SwingConstants.CENTER);
        lbToPay.setVerticalAlignment(SwingConstants.CENTER);
        tfToPay = new JTextField("26,50 EUR (toPay)");
        tfToPay.setHorizontalAlignment(SwingConstants.CENTER);
        tfToPay.setPreferredSize(new Dimension(150,30));
        tfToPay.setEditable(false);


        panelHoldingAllreadyPaidAndStillToPay.add(lbSpend);
        panelHoldingAllreadyPaidAndStillToPay.add(lbToPay);
        panelHoldingAllreadyPaidAndStillToPay.add(tfSpend);
        panelHoldingAllreadyPaidAndStillToPay.add(tfToPay);

        panelHoldingAllreadyPaidAndStillToPay.setVisible(true);

        return panelHoldingAllreadyPaidAndStillToPay;


    }

    public String getSpend(){
        return this.tfSpend.getText();
    }

    public void setSpend(String spend){
        this.tfSpend.setText(spend);
    }

    public String getToPay(){
        return this.tfToPay.getText();
    }

    public void setToPay(String ToPay){
        this.tfToPay.setText(ToPay);
    }

}
