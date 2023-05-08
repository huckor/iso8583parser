package com.huckor.isoparser;

import java.util.HashMap;
import java.util.Map;

public class AppConstants {
    public static String DEFAULT_ISO_SPEC_FILE = "parser-template.xml";
    public static String UNKNOWN_FIELD_NAME = "Unknown name";
    public static int FIRST_FIELD = 2;
    public static int LAST_FIELD = 128;
    public static int PRIMARY_BITMAP_START = 4;
    public static int PRIMARY_BITMAP_END = 4 + 16;
    public static int SECONDARY_BITMAP_START = 4 + 16;
    public static int SECONDARY_BITMAP_END = 4 + 16 + 16;
    public static int PRIMARY_BITMAP_FIRST_FIELD = 4 + 2;
    public static Map<Integer, String> FIELD_NAMES;
    static {
        FIELD_NAMES = new HashMap<>();
        FIELD_NAMES.put(0, "Message type");
        FIELD_NAMES.put(1, "Bitmap");
        FIELD_NAMES.put(2, "Primary account number (PAN)");
        FIELD_NAMES.put(3, "Processing Code");
        FIELD_NAMES.put(4, "Amount Transaction");
        FIELD_NAMES.put(5, "Amount, settlement");
        FIELD_NAMES.put(6, "Amount, cardholder billing");
        FIELD_NAMES.put(7, "Transmission date & time");
        FIELD_NAMES.put(8, "Amount, cardholder billing fee");
        FIELD_NAMES.put(9, "Conversion rate, settlement");
        FIELD_NAMES.put(10, "Conversion rate, cardholder billing");
        FIELD_NAMES.put(11, "System trace audit number (STAN)");
        FIELD_NAMES.put(12, "Local transaction time");
        FIELD_NAMES.put(13, "Local transaction date");
        FIELD_NAMES.put(14, "Expiration date");
        FIELD_NAMES.put(15, "Settlement date");
        FIELD_NAMES.put(16, "Currency conversion date");
        FIELD_NAMES.put(17, "Capture date");
        FIELD_NAMES.put(18, "Merchant type, or merchant category code");
        FIELD_NAMES.put(19, "Acquiring institution (country code)");
        FIELD_NAMES.put(20, "PAN extended (country code)");
        FIELD_NAMES.put(21, "Forwarding institution (country code)");
        FIELD_NAMES.put(22, "Point of service entry mode");
        FIELD_NAMES.put(23, "Application PAN sequence number");
        FIELD_NAMES.put(24, "Network international identifier (NII)");
        FIELD_NAMES.put(25, "Point of service condition code");
        FIELD_NAMES.put(26, "Point of service capture code");
        FIELD_NAMES.put(27, "Authorizing identification response length");
        FIELD_NAMES.put(28, "Amount, transaction fee");
        FIELD_NAMES.put(29, "Amount, settlement fee");
        FIELD_NAMES.put(30, "Amount, transaction processing fee");
        FIELD_NAMES.put(31, "Amount, settlement processing fee");
        FIELD_NAMES.put(32, "Acquiring institution identification code");
        FIELD_NAMES.put(33, "Forwarding institution identification code");
        FIELD_NAMES.put(34, "Primary account number, extended");
        FIELD_NAMES.put(35, "Track 2 data");
        FIELD_NAMES.put(36, "Track 3 data");
        FIELD_NAMES.put(37, "Retrieval reference number");
        FIELD_NAMES.put(38, "Authorization identification response");
        FIELD_NAMES.put(39, "Response code");
        FIELD_NAMES.put(40, "Service restriction code");
        FIELD_NAMES.put(41, "Card acceptor terminal identification");
        FIELD_NAMES.put(42, "Card acceptor identification code");
        FIELD_NAMES.put(43, "Card acceptor name/location");
        FIELD_NAMES.put(44, "Additional response data");
        FIELD_NAMES.put(45, "Track 1 data");
        FIELD_NAMES.put(46, "Additional data (ISO)");
        FIELD_NAMES.put(47, "Additional data (national)");
        FIELD_NAMES.put(48, "Additional data (private)");
        FIELD_NAMES.put(49, "Currency code, transaction");
        FIELD_NAMES.put(50, "Currency code, settlement");
        FIELD_NAMES.put(51, "Currency code, cardholder billing");
        FIELD_NAMES.put(52, "Personal identification number data");
        FIELD_NAMES.put(53, "Security related control information");
        FIELD_NAMES.put(54, "Additional amounts");
        FIELD_NAMES.put(55, "ICC data");
        FIELD_NAMES.put(56, "Reserved (ISO)");
        FIELD_NAMES.put(57, "Reserved (national)");
        FIELD_NAMES.put(58, "Reserved (national)");
        FIELD_NAMES.put(59, "Reserved (national)");
        FIELD_NAMES.put(60, "Reserved (national)");
        FIELD_NAMES.put(61, "Reserved (private)");
        FIELD_NAMES.put(62, "Reserved (private)");
        FIELD_NAMES.put(63, "Reserved (private)");
        FIELD_NAMES.put(64, "Message authentication code (MAC)");
        FIELD_NAMES.put(65, "Extended bitmap indicator");
        FIELD_NAMES.put(66, "Settlement code");
        FIELD_NAMES.put(67, "Extended payment code");
        FIELD_NAMES.put(68, "Receiving institution country code");
        FIELD_NAMES.put(69, "Settlement institution country code");
        FIELD_NAMES.put(70, "Network management information code");
        FIELD_NAMES.put(71, "Message number");
        FIELD_NAMES.put(72, "Last message's number");
        FIELD_NAMES.put(73, "Action date (YYMMDD)");
        FIELD_NAMES.put(74, "Number of credits");
        FIELD_NAMES.put(75, "Credits, reversal number");
        FIELD_NAMES.put(76, "Number of debits");
        FIELD_NAMES.put(77, "Debits, reversal number");
        FIELD_NAMES.put(78, "Transfer number");
        FIELD_NAMES.put(79, "Transfer, reversal number");
        FIELD_NAMES.put(80, "Number of inquiries");
        FIELD_NAMES.put(81, "Number of authorizations");
        FIELD_NAMES.put(82, "Credits, processing fee amount");
        FIELD_NAMES.put(83, "Credits, transaction fee amount");
        FIELD_NAMES.put(84, "Debits, processing fee amount");
        FIELD_NAMES.put(85, "Debits, transaction fee amount");
        FIELD_NAMES.put(86, "Total amount of credits");
        FIELD_NAMES.put(87, "Credits, reversal amount");
        FIELD_NAMES.put(88, "Total amount of debits");
        FIELD_NAMES.put(89, "Debits, reversal amount");
        FIELD_NAMES.put(90, "Original data elements");
        FIELD_NAMES.put(91, "File update code");
        FIELD_NAMES.put(92, "File security code");
        FIELD_NAMES.put(93, "Response indicator");
        FIELD_NAMES.put(94, "Service indicator");
        FIELD_NAMES.put(95, "Replacement amounts");
        FIELD_NAMES.put(96, "Message security code");
        FIELD_NAMES.put(97, "Net settlement amount");
        FIELD_NAMES.put(98, "Payee");
        FIELD_NAMES.put(99, "Settlement institution identification code");
        FIELD_NAMES.put(100, "Receiving institution identification code");
        FIELD_NAMES.put(101, "File name");
        FIELD_NAMES.put(102, "Account identification 1");
        FIELD_NAMES.put(103, "Account identification 2");
        FIELD_NAMES.put(104, "Transaction description");
        FIELD_NAMES.put(105, "Reserved for ISO use");
        FIELD_NAMES.put(106, "Reserved for ISO use");
        FIELD_NAMES.put(107, "Reserved for ISO use");
        FIELD_NAMES.put(108, "Reserved for ISO use");
        FIELD_NAMES.put(109, "Reserved for ISO use");
        FIELD_NAMES.put(110, "Reserved for ISO use");
        FIELD_NAMES.put(111, "Reserved for ISO use");
        FIELD_NAMES.put(112, "Reserved for national use");
        FIELD_NAMES.put(113, "Reserved for national use");
        FIELD_NAMES.put(114, "Reserved for national use");
        FIELD_NAMES.put(115, "Reserved for national use");
        FIELD_NAMES.put(116, "Reserved for national use");
        FIELD_NAMES.put(117, "Reserved for national use");
        FIELD_NAMES.put(118, "Reserved for national use");
        FIELD_NAMES.put(119, "Reserved for national use");
        FIELD_NAMES.put(120, "Reserved for private use");
        FIELD_NAMES.put(121, "Reserved for private use");
        FIELD_NAMES.put(122, "Reserved for private use");
        FIELD_NAMES.put(123, "Reserved for private use");
        FIELD_NAMES.put(124, "Reserved for private use");
        FIELD_NAMES.put(125, "Reserved for private use");
        FIELD_NAMES.put(126, "Reserved for private use");
        FIELD_NAMES.put(127, "Reserved for private use");
        FIELD_NAMES.put(128, "Message authentication code");
    }
}
