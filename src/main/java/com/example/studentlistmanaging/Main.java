package com.example.studentlistmanaging;

import com.example.studentlistmanaging.repository.StudentRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Screen primaryScreen = Screen.getPrimary();
        Rectangle2D primaryScreenVisualBounds = primaryScreen.getVisualBounds();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("Hello!");
        stage.setWidth(primaryScreenVisualBounds.getWidth());
        stage.setHeight(primaryScreenVisualBounds.getHeight());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        StudentRepository.getEm().close();
        StudentRepository.getEmf().close();
    }

    public static void main(String[] args) {
        launch();
    }
}