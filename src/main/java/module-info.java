module org.example.calculatorapp_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.calculatorapp_javafx to javafx.fxml;
    exports org.example.calculatorapp_javafx;
}