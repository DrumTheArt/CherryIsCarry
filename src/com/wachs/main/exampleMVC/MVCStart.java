package com.wachs.main.exampleMVC;

public class MVCStart {

    public static void main(String[] args) {

        View theView = new View();
        Model theModel = new Model();

        Controller controller = new Controller(theView, theModel);

        theView.setVisible(true);

    }


}
