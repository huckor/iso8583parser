package com.huckor.isoparser;

import java.nio.charset.StandardCharsets;

public class Helpers {
    private static final byte[] HEX_ARRAY = "0123456789ABCDEF".getBytes(StandardCharsets.US_ASCII);
    public static String binToAscii(byte[] data) {
        if(data == null || data.length <= 0) {
            return "";
        }
        byte[] hexChars = new byte[data.length * 2];
        for (int j = 0; j < data.length; j++) {
            int v = data[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars, StandardCharsets.UTF_8);
    }

    public static byte[] asciiToBin(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static boolean isBitSetInByte(byte Byte, int position) {
        if(position < 1 || position > 8) {
            return false;
        }
        return ((Byte << (~position & 31)) < 0);
    }
}
