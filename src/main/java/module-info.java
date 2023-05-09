module com.example.londonundergroundroutefinder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.londonundergroundroutefinder to javafx.fxml;
    exports com.example.londonundergroundroutefinder;
    exports com.example.londonundergroundroutefinder.Controller;
    opens com.example.londonundergroundroutefinder.Controller to javafx.fxml;
   // exports com.example.londonundergroundroutefinder.Driver;
    //opens com.example.londonundergroundroutefinder.Driver to javafx.fxml;
}