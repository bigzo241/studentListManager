module com.example.studentlistmanaging {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.persistence;
    requires jakarta.validation;

    opens com.example.studentlistmanaging to javafx.fxml;
    exports com.example.studentlistmanaging;
    exports com.example.studentlistmanaging.controller;
    opens com.example.studentlistmanaging.controller to javafx.fxml;
}