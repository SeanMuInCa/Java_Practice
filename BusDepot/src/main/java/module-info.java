module com.saskpolytech.busdepot {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.saskpolytech.busdepot to javafx.fxml;
    exports com.saskpolytech.busdepot;
}