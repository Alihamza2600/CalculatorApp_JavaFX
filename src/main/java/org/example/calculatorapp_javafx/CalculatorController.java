package org.example.calculatorapp_javafx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CalculatorController {
    @FXML
    private Label welcomeText;
    private double input1=0;
    private String operator = "";
    private boolean startNewInput = true;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    private void handleNumber(ActionEvent actionEvent) {
        if(startNewInput){
            display.setText("");
            startNewInput = false;
        }
    }

    private void handleOperation(ActionEvent actionEvent) {
    }

    private void handleEquals(ActionEvent actionEvent) {
    }

    private void handlePercent(ActionEvent actionEvent) {
    }

    private void handleClearEntry(ActionEvent actionEvent) {
        display.setText("0");
        startNewInput = true;
    }

    private void handleInverse(ActionEvent actionEvent) {
    }

    private void handleSquare(ActionEvent actionEvent) {
    }

    private void handleClear(ActionEvent actionEvent) {
        display.setText("0");
        input1 = 0;
        operator = "";
        startNewInput = true;
    }

    private void handleSqrt(ActionEvent actionEvent) {
        double value = Double.parseDouble(display.getText());
        display.setText(String.valueOf(value*value));
    }

    private void handleBackspace(ActionEvent actionEvent) {
    }

    private void handlePlusMinus(ActionEvent actionEvent) {
    }

    private void handleDecimal(ActionEvent actionEvent) {
    }
}