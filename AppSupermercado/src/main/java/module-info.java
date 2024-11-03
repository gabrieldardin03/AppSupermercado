module com.example.appsupermercado {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.appsupermercado to javafx.fxml;
    exports com.example.appsupermercado;
}