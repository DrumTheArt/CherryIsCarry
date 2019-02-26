package com.wachs.main.exampleMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private View theView;
    private Model theModel;

    public Controller(View view, Model model) {

        theView = view;
        theModel = model;

        this.theView.addCalculationListener(new CalculateListener());

    }

    class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int firstNumber, secondNumber = 0;

            try {
                firstNumber = theView.getFirstNumber();
                secondNumber = theView.getSecondNumber();

                theModel.addTwoNumbers(firstNumber, secondNumber);

                theView.setCalcSolution(theModel.getCalculationValue());
            } catch (NumberFormatException ex) {

                theView.displayErrorMessage("asdasdasd");
            }
        }
    }
}
