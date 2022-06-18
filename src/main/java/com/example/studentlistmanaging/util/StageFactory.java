package com.example.studentlistmanaging.util;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class StageFactory {

    private static StageFactory instance;

    private StageFactory() {}

    public static StageFactory getInstance() {
        if (instance == null)
            instance = new StageFactory();
        return instance;
    }

    public Stage createStage(Window owner, StageStyle style, Modality modality) {
        Stage stage = new Stage(style);
        stage.initOwner(owner);
        stage.initModality(modality);
        return stage;
    }
}
