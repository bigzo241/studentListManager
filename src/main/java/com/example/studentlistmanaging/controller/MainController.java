package com.example.studentlistmanaging.controller;

import com.example.studentlistmanaging.Main;
import com.example.studentlistmanaging.model.Student;
import com.example.studentlistmanaging.repository.StudentRepository;
import com.example.studentlistmanaging.util.StageFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class MainController {
    @FXML
    private FlowPane body;

    @FXML
    private VBox header;

    private final StudentRepository repository = StudentRepository.getInstance();

    public MainController() {}

    @FXML
    public void initialize() {
        Button btnAjouter = new Button("Ajouter");
        btnAjouter.getStyleClass().addAll("btn", "btn-primary");
        btnAjouter.setOnAction((e) -> {
            try {
                onAjouterBtnClick();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        header.getChildren().add(btnAjouter);

        List<Student> studentList = repository.findAll();
        for ( Student student: studentList ) {
            Image image = new Image(this.getClass().getResource("/img/img1.png").toString(), 188, 225, false, true);
            ImageView imageView = new ImageView(image);
            VBox vBox1 = new VBox(imageView);
            vBox1.getStyleClass().add("student_img");
            vBox1.setAlignment(Pos.CENTER);

            Label matricule = new Label(student.getMatricule());
            matricule.getStyleClass().add("studentProperty");
            Label nom = new Label(student.getNom());
            nom.getStyleClass().add("studentProperty");
            Label prenom = new Label(student.getPrenom());
            prenom.getStyleClass().add("studentProperty");
            Label date_lieu_naissance = new Label(student.getDate_naissance() + " à " + student.getLieu_naissance());
            date_lieu_naissance.getStyleClass().add("studentProperty");
            Label email = new Label(student.getEmail());
            email.getStyleClass().add("studentProperty");
            Label tel = new Label(student.getTel());
            tel.getStyleClass().add("studentProperty");
            Label nationalite = new Label(student.getNationalite());
            nationalite.getStyleClass().add("studentProperty");
            VBox vBox2 = new VBox(matricule, nom, prenom, date_lieu_naissance, email);
            vBox2.setAlignment(Pos.CENTER_LEFT);
            vBox2.setSpacing(15);

            HBox hBox = new HBox(vBox1, vBox2);
            hBox.setPrefWidth(560);
            hBox.getStyleClass().add("container");
            hBox.setAlignment(Pos.CENTER);
            hBox.setSpacing(30);
            hBox.setPadding(new Insets(20));

            body.getChildren().add(hBox);
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        LocalDate date = LocalDate.of(1998, 8, 17);

        Student student = new Student();
        student.setMatricule("1234A");
        student.setNom("ZO");
        student.setPrenom("Mamadou");
        student.setDate_naissance(date);
        student.setLieu_naissance("Livreville");
        student.setNationalite("Burkinabè");
        student.setEmail("zomamadou9@gmail.com");
        student.setTel("64774850");
        student.setPhoto("C:/user/BIGZO/img1.jpg");

        repository.save(student);

    }

    protected void onAjouterBtnClick() throws IOException {
        Parent root = header.getScene().getRoot();

        StageFactory stageFactory = StageFactory.getInstance();
        Stage registerFormStage = stageFactory.createStage(header.getScene().getWindow(), StageStyle.UNDECORATED, Modality.APPLICATION_MODAL);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("registerForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        registerFormStage.setScene(scene);

        appyBlurEffect(5.0, 5.0, 2, root);

        registerFormStage.show();
    }

    protected void appyBlurEffect(double width, double height, int iteration, Node node) {
        BoxBlur boxBlur = new BoxBlur(width, height, iteration);
        node.setEffect(boxBlur);
    }
}