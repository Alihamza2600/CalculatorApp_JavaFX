package org.example.calculatorapp_javafx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.AudioClip;

public class CalculatorController {
    @FXML
    private TextField display;
    private double input1 = 0;
    private String operator = "";
    private boolean startNewInput = true;
    private Button selectedOperator = null;

    private final AudioClip buttonsound = new AudioClip(getClass().getResource("/sounds/button.wav").toString());


    @FXML
    public void handleButtonClick() {
        buttonsound.play();
    }

    @FXML
    private void handleNumber(ActionEvent actionEvent) {
        if (startNewInput) {
            display.setText("");
            startNewInput = false;
        }

        buttonsound.play();
        Button btn = (Button) actionEvent.getSource();
        display.setText(display.getText() + btn.getText());


    }

    @FXML
    private void handleOperation(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource(); // find out which button were pressed
        operator = btn.getText(); // saves the operator that we just pressed
        input1 = Double.parseDouble(display.getText());
        startNewInput = true;

        if (selectedOperator != null) {
            selectedOperator.setStyle("-fx-background-color: #ff9500; -fx-text-fill: white; -fx-font-size: 32px");
        }

        selectedOperator = btn;
        selectedOperator.setStyle("-fx-background-color: #A0A0A0; -fx-text-fill: white; -fx-font-size: 32px");


    }

    @FXML
    private void handleEquals(ActionEvent actionEvent) {
        double input2 = Double.parseDouble(display.getText()); // we convert the second input to double and save it
        double result = 0;

        switch (operator) {
            case "+":
                result = input1 + input2;
                break;
            case "-":
                result = input1 - input2;
                break;
            case "*":
                result = input1 * input2;
                break;
            case "/":
                if (input2 != 0) result = input1 / input2;
                else display.setText("Error");
                return;
        }

        display.setText(String.valueOf(result));
        startNewInput = true;


        if (selectedOperator != null) {
            selectedOperator.setStyle("-fx-background-color: #ff9500; -fx-text-fill: white; -fx-font-size: 32px");
            selectedOperator = null;
        }


    }

    @FXML
    private void handlePercent(ActionEvent actionEvent) {
        double percentValue = input1 * (Double.parseDouble(display.getText())) / 100;
        display.setText(String.valueOf(percentValue));


    }

    @FXML
    private void handleClearEntry(ActionEvent actionEvent) {
        display.setText("0");
        startNewInput = true;
    }

    @FXML
    private void handleInverse(ActionEvent actionEvent) {
        double value = Double.parseDouble(display.getText());
        if (value != 0) {
            display.setText(String.valueOf(1 / value));
        }

    }

    @FXML
    private void handleSquare(ActionEvent actionEvent) {
        double value = Double.parseDouble(display.getText());
        display.setText(String.valueOf(value * value));
    }

    @FXML
    private void handleClear(ActionEvent actionEvent) {
        display.setText("0");
        input1 = 0;
        operator = "";
        startNewInput = true;
    }

    @FXML
    private void handleSqrt(ActionEvent actionEvent) {
        double value = Double.parseDouble(display.getText());
        display.setText(String.valueOf(Math.sqrt(value)));
    }

    @FXML
    private void handleBackspace(ActionEvent actionEvent) {
        String text = display.getText();
        if (!text.isEmpty()) {
            display.setText(text.substring(0, text.length() - 1));
        }


    }

    @FXML
    private void handlePlusMinus(ActionEvent actionEvent) {
        double value = Double.parseDouble(display.getText());
        display.setText(String.valueOf(value * -1));


    }

    @FXML
    private void handleDecimal(ActionEvent actionEvent) {
        if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
        }

    }
}