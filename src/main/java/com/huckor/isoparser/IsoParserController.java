package com.huckor.isoparser;


import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class IsoParserController {
    public TextArea isoIn;
    public TextArea isoOut;
    public Spinner<Integer> startPoint;
    private static Stage appStage;
    private URL isoSpecFile = IsoParserApplication.class.getResource(AppConstants.DEFAULT_ISO_SPEC_FILE);

    public static void setStage(Stage stage) {
        appStage = stage;
    }

    @FXML
    protected void onOpenIso8583SpecButtonClick() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(appStage);
        if(file == null) {
            return;
        }
        try {
            isoSpecFile = file.toURI().toURL();
        } catch (SecurityException | MalformedURLException | IllegalArgumentException e) {
            isoOut.setText(e.getMessage());
        }
    }

    @FXML
    protected void onParseButtonClick() {
        isoOut.setText(new IsoParser().parseMessage(isoIn.getText(), startPoint.getValue(), isoSpecFile));
    }
}