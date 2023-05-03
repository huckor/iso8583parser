package com.huckor.isoparser;

import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.IsoValue;
import com.solab.iso8583.MessageFactory;
import com.solab.iso8583.parse.ConfigParser;

import java.net.URL;
import java.util.Objects;

public class IsoParser {
    public String parseMessage(final String isoMessage, final int messageStartPoint, final URL isoSpecFile) {
        if(isoMessage == null || isoMessage.isEmpty()) {
            return "";
        }

        String clearIsoMessage;
        if(messageStartPoint > 0) {
            clearIsoMessage = isoMessage.substring(messageStartPoint);
        } else {
            clearIsoMessage = isoMessage;
        }

        MessageFactory<IsoMessage> messageFactory = new MessageFactory<>();
        messageFactory.setBinaryFields(true);
        messageFactory.setBinaryHeader(true);
        messageFactory.setIgnoreLastMissingField(true);

        try {
            ConfigParser.configureFromUrl(messageFactory, Objects.requireNonNullElseGet(isoSpecFile, () ->
                    Objects.requireNonNull(IsoParserApplication.class.getResource(AppConstants.DEFAULT_ISO_SPEC_FILE))));

            IsoMessage message = messageFactory.parseMessage(Helpers.asciiToBin(clearIsoMessage), 0);
            if(message == null) {
                return "";
            }

            //Message type
            StringBuilder out = new StringBuilder();
            out.append(String.format("%03d ", 0));
            out.append(String.format("%-40s : ", AppConstants.FIELD_NAMES.get(0) == null ? AppConstants.UNKNOWN_FIELD_NAME : AppConstants.FIELD_NAMES.get(0)));
            out.append(String.format("%04X ", message.getType())).append("\n");

            //Loop through all ISO fields
            for (int i=AppConstants.FIRST_FIELD;i<=AppConstants.LAST_FIELD;i++) {
                IsoValue<?> field = message.getField(i);
                if(field == null) {
                    continue;
                }
                //Field number
                out.append(String.format("%03d ", i));
                //Field name
                out.append(String.format("%-40s : ", AppConstants.FIELD_NAMES.get(i) == null ? AppConstants.UNKNOWN_FIELD_NAME : AppConstants.FIELD_NAMES.get(i)));
                //Field value
                try {
                    out.append(field).append("\n");
                } catch (Exception e) {
                    out.append(e.getMessage()).append("\n");
                }
            }
            return out.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
