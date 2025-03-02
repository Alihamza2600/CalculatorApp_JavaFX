module org.example.calculatorapp_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens org.example.calculatorapp_javafx to javafx.fxml;
    exports org.example.calculatorapp_javafx;
}