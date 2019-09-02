package com.wachs.main.exceptions;

import javax.swing.*;

public class NotInDataBaseException extends RuntimeException {

    public NotInDataBaseException(){

        super("NotInDataBaseException");

    }

    public NotInDataBaseException(String errorMessage){

        super(errorMessage);
        JOptionPane.showMessageDialog(null, "Dieser Wert ist in der DB nicht vorhanden");

    }

}
