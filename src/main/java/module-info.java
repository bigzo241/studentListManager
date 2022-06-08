module com.example.studentlistmanaging {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires jakarta.validation;
    requires mysql.connector.java;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens com.example.studentlistmanaging to javafx.fxml;
    exports com.example.studentlistmanaging;
    exports com.example.studentlistmanaging.controller;
    exports com.example.studentlistmanaging.model;
    opens com.example.studentlistmanaging.controller to javafx.fxml;
    opens com.example.studentlistmanaging.model;
}