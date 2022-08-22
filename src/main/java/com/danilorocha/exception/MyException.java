package com.danilorocha.exception;

import javax.swing.*;

import static com.danilorocha.util.UtilView.messageDialog;

public class MyException extends RuntimeException {

    public MyException(JRootPane rootPane, String message) {
        super(message);
        messageDialog(rootPane, message);
    }

}
