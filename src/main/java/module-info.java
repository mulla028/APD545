module ca.seneca.workshop2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ca.seneca.workshop2 to javafx.fxml;
    exports ca.seneca.workshop2.controllers to javafx.graphics;
    exports ca.seneca.workshop2;
}