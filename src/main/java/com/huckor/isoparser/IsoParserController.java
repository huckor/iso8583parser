package com.huckor.isoparser;


import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.IsoValue;
import com.solab.iso8583.MessageFactory;
import com.solab.iso8583.parse.ConfigParser;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;

import java.net.URL;

public class IsoParserController {
    public TextArea textAreaIsoIn;
    public TextArea textAreaIsoOut;
    public Spinner startingPointLeft;

    @FXML
    protected void onPasteButtonClick() {
        String in = textAreaIsoIn.getText();
        if(in == null || in.isEmpty()) {
            return;
        }

        try {
            MessageFactory<IsoMessage> messageFactory = new MessageFactory<>();
            messageFactory.setBinaryFields(true);
            messageFactory.setBinaryHeader(true);
            messageFactory.setIgnoreLastMissingField(true);

            URL templateFile = IsoParserApplication.class.getResource("parser-template.xml");
            if(templateFile == null) {
                ConfigParser.configureFromDefault(messageFactory);
            } else {
                ConfigParser.configureFromUrl(messageFactory, templateFile);
            }

            if(((int)startingPointLeft.getValue()) > 0) {
                in = in.substring((int)startingPointLeft.getValue());
            }

            IsoMessage message = messageFactory.parseMessage(Helpers.asciiToBin(in), 0);
            if(message != null) {
                StringBuilder isoOut = new StringBuilder();
                for (int i = 2; i <= 128; i++) {
                    IsoValue<?> field = message.getField(i);
                    if (field != null) {
                        isoOut.append(String.format("%03d ", i));
                        isoOut.append(String.format("%-40s : ", AppConstants.isoFieldNames.get(i) == null ? "Unknown name" : AppConstants.isoFieldNames.get(i)));
                        try {
                            isoOut.append(field).append("\n");
                        } catch (Exception e) {
                            isoOut.append(e.getMessage()).append("\n");
                        }
                    }
                }
                textAreaIsoOut.setText(isoOut.toString());
            }
        } catch (Exception e) {
            textAreaIsoOut.setText(e.getMessage());
        }
    }
}