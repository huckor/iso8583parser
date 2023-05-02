package com.huckor.isoparser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.net.URL;

public class IsoParserTests {
    private final String msg0210 = "0210303801000E80021000000000000000050000001610071401100246303030303030303633343639333131333136303037383030303030320025720B860984180000041AE72C2B910A4F680847C1790AED303000124872756D4079624972642020";

    @Test
    @DisplayName("Parse message 0210")
    void parseMessage0210() {
        IsoParser parser = new IsoParser();
        String out = parser.parseMessage(msg0210, 0, IsoParserApplication.class.getResource(AppConstants.DEFAULT_ISO_SPEC_FILE));
        String fld = AppConstants.FIELD_NAMES.get(3);
        assertTrue(out.contains(fld), "Parsed message have to contains " + fld);
        fld = AppConstants.FIELD_NAMES.get(4);
        assertTrue(out.contains(fld), "Parsed message have to contains " + fld);
        fld = AppConstants.FIELD_NAMES.get(11);
        assertTrue(out.contains(fld), "Parsed message have to contains " + fld);
        fld = AppConstants.FIELD_NAMES.get(12);
        assertTrue(out.contains(fld), "Parsed message have to contains " + fld);
        fld = AppConstants.FIELD_NAMES.get(13);
        assertTrue(out.contains(fld), "Parsed message have to contains " + fld);
        fld = AppConstants.FIELD_NAMES.get(24);
        assertTrue(out.contains(fld), "Parsed message have to contains " + fld);
        fld = AppConstants.FIELD_NAMES.get(37);
        assertTrue(out.contains(fld), "Parsed message have to contains " + fld);
        fld = AppConstants.FIELD_NAMES.get(38);
        assertTrue(out.contains(fld), "Parsed message have to contains " + fld);
        fld = AppConstants.FIELD_NAMES.get(39);
        assertTrue(out.contains(fld), "Parsed message have to contains " + fld);
        fld = AppConstants.FIELD_NAMES.get(41);
        assertTrue(out.contains(fld), "Parsed message have to contains " + fld);
        fld = AppConstants.FIELD_NAMES.get(55);
        assertTrue(out.contains(fld), "Parsed message have to contains " + fld);
        fld = AppConstants.FIELD_NAMES.get(60);
        assertTrue(out.contains(fld), "Parsed message have to contains " + fld);
    }

    @ParameterizedTest(name = "Null input parameters")
    @CsvSource({
            ",      0,      ,   ''",
            "'',    0,      ,   ''"
    })
    void nullInputParameters(String first, int second, URL third, String expectedResult) {
        IsoParser parser = new IsoParser();
        String out = parser.parseMessage(first, second, third);
        assertEquals(expectedResult, out, "Return should an empty string");
    }
}
