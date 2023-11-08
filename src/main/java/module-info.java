module com.example.yacht_dice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.yacht_dice to javafx.fxml;
    exports com.example.yacht_dice;
}