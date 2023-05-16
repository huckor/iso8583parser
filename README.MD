# ISO8583 Parser with GUI

A simple ISO8583 parser with graphical user interface written in Java using JavaFX and j8583 library.

## Build, test and packaging status
![workflow](https://github.com/huckor/iso8583parser/actions/workflows/build-linux.yml/badge.svg)
![workflow](https://github.com/huckor/iso8583parser/actions/workflows/build-mac.yml/badge.svg)
![workflow](https://github.com/huckor/iso8583parser/actions/workflows/build-win.yml/badge.svg)

## Features

- Parsing of ISO8583 messages using graphical user interface.
- Support for ISO8583 versions 1987, 1993 and 2003.
- Support for primary and secondary ISO8583 bitmaps.
- Configuration options to handle various message formats and field layouts.
- Automatic validation and error detection for ISO8583 messages.

## Usage

This application expecting input data in HEX format. Message should start with MTI or use (5) spinner to skip first 'n' characters.

1. Paste your ISO8583 message in HEX format to this text box
2. Parsed output will appear in this text box
3. Press this button to parse your ISO8583 message
4. Use this button to load your custom ISO8583 template
5. Use spinner to skip first 'n' characters of your ISO8583 message. This is useful to skip message header.

By default this application using ISO8583 specs as defined in file [parser-template.xml](src/main/resources/com/huckor/isoparser/parser-template.xml).
In case your ISO8583 specs are different then you need to adjust template file accordingly.