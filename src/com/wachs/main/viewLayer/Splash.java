package com.wachs.main.viewLayer;

import javax.swing.*;

public class Splash{


    public static void main (String args[]) {


    try {
        // select Look and Feel
        UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.SmartLookAndFeel");
        // start application
        new MainFrame();
    }
        catch (Exception ex) {
        ex.printStackTrace();
    }

    }

}


