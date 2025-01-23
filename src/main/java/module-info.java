module org.calma.ui {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.calma.ui to javafx.fxml;
    exports org.calma.ui;
}