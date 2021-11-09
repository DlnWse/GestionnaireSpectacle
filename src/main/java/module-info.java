module fr.dylan.unairdejava {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;



    opens fr.dylan.unairdejava to javafx.fxml;
    exports fr.dylan.unairdejava;
}