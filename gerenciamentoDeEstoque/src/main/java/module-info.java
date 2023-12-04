module com.mycompany.gerenciamentodeestoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.gerenciamentodeestoque to javafx.fxml;
    exports com.mycompany.gerenciamentodeestoque;
    exports com.mycompany.gerenciamentodeestoque.data;
    exports com.mycompany.gerenciamentodeestoque.model;
}
