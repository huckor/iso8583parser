package com.huckor.isoparser;


import com.solab.iso8583.IsoValue;
import com.solab.iso8583.MessageFactory;
import com.solab.iso8583.parse.ConfigParser;
import com.solab.iso8583.IsoMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;

import java.net.URL;

public class IsoParserController {
    public TextArea isoIn;
    public TextArea isoOut;
    public Spinner startPoint;

    @FXML
    protected void onPasteButtonClick() {
        String in = isoIn.getText();
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

            if(((int) startPoint.getValue()) > 0) {
                in = in.substring((int) startPoint.getValue());
            }

            IsoMessage message = messageFactory.parseMessage(Helpers.asciiToBin(in), 0);
            if(message == null) {
                return;
            }

            StringBuilder out = new StringBuilder();
            for (int i = 2; i <= 128; i++) {
                IsoValue<?> field = message.getField(i);
                if(field == null) {
                    continue;
                }
                //Iso field number
                out.append(String.format("%03d ", i));
                //Iso field name
                out.append(String.format("%-40s : ", AppConstants.isoFieldNames.get(i) == null ? "Unknown name" : AppConstants.isoFieldNames.get(i)));
                //Iso field value
                try {
                    out.append(field).append("\n");
                } catch (Exception e) {
                    out.append(e.getMessage()).append("\n");
                }
            }
            this.isoOut.setText(out.toString());
        } catch (Exception e) {
            isoOut.setText(e.getMessage());
        }
    }
}