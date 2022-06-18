package com.example.studentlistmanaging.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class RegisterFormController {

    @FXML private Label matricule;
    @FXML private HBox zoneButton;
    @FXML private Label img_path;


    public RegisterFormController() {}

    public void initialize() {
        Button btnEnregistrer = new Button("Enregistrer");
        Button btnAnnuler = new Button("Annuler");
        btnEnregistrer.getStyleClass().addAll("btn", "btn-success");
        btnAnnuler.getStyleClass().addAll("btn", "btn-danger");
        btnAnnuler.setOnAction((e) -> onAnnulerBtnClick());
        zoneButton.getChildren().addAll(btnEnregistrer, btnAnnuler);
    }

    @FXML
    protected void openFileChooser() {
        FileChooser fileDialog = new FileChooser();
        fileDialog.setTitle("Selectionner une photo de profil");
        fileDialog.setInitialDirectory(new File("C:\\"));
        fileDialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Pictures Files", "*.png", "*.jpg", "jpeg", "bmp"));

        Stage formStage = (Stage) matricule.getScene().getWindow();

        File file = fileDialog.showOpenDialog(formStage.getOwner());
        if (file == null)
            return;

        img_path.setText(file.toString());
    }

    @FXML
    protected void onAnnulerBtnClick() {
        Stage formStage = (Stage) matricule.getScene().getWindow();
        formStage.close();
        Stage mainStage = (Stage) formStage.getOwner();
        mainStage.getScene().getRoot().setEffect(null);
    }
}
