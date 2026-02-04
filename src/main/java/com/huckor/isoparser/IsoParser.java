package com.huckor.isoparser;

import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.IsoValue;
import com.solab.iso8583.MessageFactory;
import com.solab.iso8583.parse.ConfigParser;

import java.net.URL;
import java.util.List;
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

        List<String> availableTemplates = List.of(
                AppConstants.ISO_SPEC_FILE_1,
                AppConstants.ISO_SPEC_FILE_2,
                AppConstants.ISO_SPEC_FILE_3
        );

        String out = "";

        for (String template : availableTemplates) {
            try {
                URL specUrl = Objects.requireNonNullElseGet(
                        isoSpecFile,
                        () -> Objects.requireNonNull(
                                IsoParserApplication.class.getResource(template)
                        )
                );

                ConfigParser.configureFromUrl(messageFactory, specUrl);

                IsoMessage parsedMessage = messageFactory.parseMessage(Helpers.asciiToBin(clearIsoMessage), 0);
                if(parsedMessage == null) {
                    continue;
                }

                return getOutputMessage(clearIsoMessage, parsedMessage);
            } catch (Exception e) {
                out = e.getMessage();
            }
        }

        return out;
    }

    private String getOutputMessage(String clearIsoMessage, IsoMessage parsedMessage) {
        //ISO version
        String isoVersion = switch (clearIsoMessage.charAt(0)) {
            case '0' -> "ISO 8583:1987";
            case '1' -> "ISO 8583:1993";
            case '2' -> "ISO 8583:2003";
            case '8' -> "National use";
            case '9' -> "Private use";
            default -> "Reserved by ISO";
        };
        StringBuilder out = new StringBuilder();
        out.append("ISO version");
        out.append(String.format("%-33s : ", " "));
        out.append(isoVersion).append("\n");

        //Message type
        out.append(String.format("%03d ", 0));
        out.append(String.format("%-40s : ", AppConstants.FIELD_NAMES.get(0) == null ? AppConstants.UNKNOWN_FIELD_NAME : AppConstants.FIELD_NAMES.get(0)));
        out.append(String.format("%04X ", parsedMessage.getType())).append("\n");

        //Primary bitmap
        out.append(String.format("%03d ", 1));
        out.append(String.format("%-40s : ", AppConstants.FIELD_NAMES.get(1) == null ? AppConstants.UNKNOWN_FIELD_NAME : AppConstants.FIELD_NAMES.get(1)));
        out.append(String.format("%s", clearIsoMessage.substring(AppConstants.PRIMARY_BITMAP_START, AppConstants.PRIMARY_BITMAP_END)));

        //Secondary bitmap (if exists)
        byte [] secondBitmapIndicator = Helpers.asciiToBin(
                clearIsoMessage.substring(AppConstants.PRIMARY_BITMAP_START, AppConstants.PRIMARY_BITMAP_FIRST_FIELD)
        );
        if(Helpers.isBitSetInByte(secondBitmapIndicator[0], 8)) {
            out.append(String.format("%s", clearIsoMessage.substring(AppConstants.SECONDARY_BITMAP_START, AppConstants.SECONDARY_BITMAP_END))).append("\n");
        } else {
            out.append("\n");
        }

        //Loop through all ISO fields
        for (int i=AppConstants.FIRST_FIELD;i<=AppConstants.LAST_FIELD;i++) {
            IsoValue<?> field = parsedMessage.getField(i);
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
    }
}
