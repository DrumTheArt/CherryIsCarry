package com.wachs.main.viewLayerJavaFX.GUISetup;

public class GUIDialogs {

    public static String saveExpensesDialogError() {

        String errorMessage = "Die Änderungen konnten nicht gespeichert werden";

        return errorMessage;
    }

    public static String saveExpensesDialogSuccess(String[] changes) {

        String generalMessage = "Die folgenden Ausgaben wurden gespeichert:";
        StringBuilder messageValue = new StringBuilder();

        for (String value : changes) {
            messageValue.append(value + "\n");
        }

        String successMessage = generalMessage + "\n" + messageValue.toString();

        return successMessage;
    }

    public static String saveAllDataDialogError() {

        String errorMessage = "Die Änderungen konnten nicht gespeichert werden";

        return errorMessage;
    }

    public static String saveAllDataDialogSuccess() {

        String successMessage = "Die Änderungen konnten nicht gespeichert werden";

        return successMessage;
    }

}
