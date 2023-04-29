package com.huckor.isoparser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class IsoParserApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(IsoParserApplication.class.getResource("iso-parser-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Iso Parser");
        stage.setScene(scene);
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        IsoParserController.setStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}