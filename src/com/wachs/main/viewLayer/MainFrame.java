package com.wachs.main.viewLayer;

import com.wachs.main.viewModelLayer.InitializingComboBoxModel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.SQLException;

public class MainFrame extends JFrame {


    /**
     * Explanation:
     * menuBar takes menus, which takes menuItems
     */


    private JFrame frame;
    private JPanel mainPanelWest;
    private JPanel mainPanelCenter;
    private JPanel mainPanelNorth;
    private PanelForGuestDetails panelGuestData;
    private PanelForGuestOverview panelHoldingAlreadyPaidAndStillToPay;
    private PanelForAllCosts panelForAllCosts;

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu infoMenu;
    private JMenuItem exportXLS;
    private JMenuItem exit;
    private JMenuItem info;
    private JComboBox cbSelectedHouse;

    private JButton btnPlusProject;
    private JButton btnPlusGuest;
    private JButton btnEditGuest;


    MainFrame() throws SQLException, ClassNotFoundException {

        frame = new JFrame();

        mainPanelWest = new JPanel(new FlowLayout());
        mainPanelCenter = new JPanel(new FlowLayout());
        mainPanelNorth = new JPanel(new FlowLayout());

        this.pack();
        mainPanelCenter.setPreferredSize(new Dimension(10,60));
        mainPanelCenter.setMaximumSize(new Dimension(10,60));

        //mainPanelCenter.setBackground(Color.gray);

        panelGuestData = new PanelForGuestDetails();
        panelHoldingAlreadyPaidAndStillToPay = new PanelForGuestOverview();
        panelForAllCosts = new PanelForAllCosts();


        mainPanelWest.setVisible(true);
        mainPanelCenter.setVisible(true);
        mainPanelNorth.setVisible(true);

        frame.setSize(1400, 300);
        frame.setTitle(UILabelNames.APP_name);
        frame.setName(UILabelNames.APP_header);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add (mainPanelWest,BorderLayout.WEST);
        frame.getContentPane().add (mainPanelCenter,BorderLayout.CENTER);
        frame.getContentPane().add (mainPanelNorth,BorderLayout.NORTH);

        //Centering the app at start & and not resizable
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        initializingHouseJComboBox();
        buildingSummaryDetails();
        makeMenu();

        JButton btnPlusProject = plusProjectButton();
        JButton btnPlusGuest = plusGuestButton();
        JButton btnEditGuest = plusEditGuestButton();

        mainPanelNorth.add(btnPlusProject);
        mainPanelNorth.add(btnPlusGuest);
        mainPanelNorth.add(btnEditGuest);

        frame.setVisible(true);

    }

    public double getAllCost(){

        return Double.parseDouble(panelGuestData.getAllCost());

    }

    public void setAllCost(double allCosts){

        panelGuestData.setAllCost(Double.toString(allCosts));

    }

    public double getNightsPrice(){

        return Double.parseDouble(panelGuestData.getNightPrice());

    }

    public void setNightsPrice(double nightsPrice){

        panelGuestData.setNightPrice(Double.toString(nightsPrice));

    }


    public int getNights(){

        return Integer.parseInt(panelGuestData.getNights());

    }

    public void setNights(int nights){

        panelGuestData.setNights(Integer.toString(nights));

    }

    public int getDrinksDays(){

        return Integer.parseInt(panelGuestData.getDrinksDays());

    }

    public void setDrinksDays(int drinksDays){

        panelGuestData.setDrinksDays(Integer.toString(drinksDays));

    }

    public double getDrinksPrice(){

        return Double.parseDouble(panelGuestData.getDrinksPrice());

    }

    public void setDrinksPrice(double drinksPrice){

        panelGuestData.setDrinksPrice(Double.toString(drinksPrice));

    }

    public int getFoodDays(){

        return Integer.parseInt(panelGuestData.getFoodDays());

    }

    public void setFoodDays(int foodDays){

        panelGuestData.setFoodDays(Integer.toString(foodDays));

    }

    public double getFoodPrice(){

        return Double.parseDouble(panelGuestData.getFoodPrice());

    }

    public void setFoodPrice(double foodPrice){

        panelGuestData.setFoodPrice(Double.toString(foodPrice));

    }

    public double getSpend(){

        return Double.parseDouble(panelHoldingAlreadyPaidAndStillToPay.getSpend());

    }

    public void setSpend(double spend){

        panelHoldingAlreadyPaidAndStillToPay.setSpend(Double.toString(spend));

    }

    public double getToPay(){

        return Double.parseDouble(panelHoldingAlreadyPaidAndStillToPay.getToPay());

    }

    public void setToPay(double toPay){

        panelHoldingAlreadyPaidAndStillToPay.setToPay(Double.toString(toPay));

    }

    private void makeMenu() {

        menuBar = new JMenuBar();
        menuBar.setVisible(true);
        frame.setJMenuBar(menuBar);

        //Menu File including two MenuItems
        fileMenu = new JMenu(UILabelNames.FILEMENU);
        exportXLS = new JMenuItem(UILabelNames.FILEMENU_SUB1);
        exit = new JMenuItem(UILabelNames.FILEMENU_SUB2);
        menuBar.add(fileMenu);
        fileMenu.add(exportXLS);
        fileMenu.add(exit);

        //Menu Info including one MenuItems
        infoMenu = new JMenu(UILabelNames.INFOMENU);
        info = new JMenuItem(UILabelNames.INFOMENU_SUB1);
        menuBar.add(infoMenu);
        infoMenu.add(info);

    }

    private void initializingHouseJComboBox() throws SQLException, ClassNotFoundException {

        cbSelectedHouse = new InitializingComboBoxModel().getAllHouses();
        cbSelectedHouse.setPreferredSize(new Dimension(150,30));

        mainPanelWest.add(cbSelectedHouse,BorderLayout.CENTER);

    }

    private void buildingSummaryDetails(){

        mainPanelCenter.add(panelGuestData.getPanelGuestData());
        mainPanelCenter.add(panelHoldingAlreadyPaidAndStillToPay.getPanelForGuestOverview());
        mainPanelCenter.add(panelForAllCosts.getPanelForAllCosts());

    }


    private JButton plusEditGuestButton(){

        String absPath = new File("").getAbsolutePath() + "//Sources/EditGuestIcon.png";
        ImageIcon plusImage = new ImageIcon(absPath);
        Image image = plusImage.getImage();
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        plusImage = new ImageIcon(newimg);
        JButton btnEditGuest = new JButton(plusImage);
        btnEditGuest.setToolTipText("edit selected Guest");

        return btnEditGuest;

    }

    private JButton plusGuestButton(){

        String absPath = new File("").getAbsolutePath() + "//Sources/PlusGuestIcon.png";
        ImageIcon plusImage = new ImageIcon(absPath);
        Image image = plusImage.getImage();
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        plusImage = new ImageIcon(newimg);
        JButton btnPlusGuest = new JButton(plusImage);
        btnPlusGuest.setToolTipText("add new Guest");

        return btnPlusGuest;
    }

    private JButton plusProjectButton(){

        String absPath = new File("").getAbsolutePath() + "//Sources/PlusHouseIcon.png";
        ImageIcon plusImage = new ImageIcon(absPath);
        Image image = plusImage.getImage();
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        plusImage = new ImageIcon(newimg);
        JButton btnPlusProject = new JButton(plusImage);
        btnPlusProject.setToolTipText("add new Trip");

        return btnPlusProject;

    }


    public static void main(String[] args) {
        try {

            // select Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            // start application
            new MainFrame();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}





