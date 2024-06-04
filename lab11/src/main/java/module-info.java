module org.example.lab11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.swing;
    requires javafx.media;

    opens org.example.lab11 to javafx.fxml;
    exports org.example.lab11;
}