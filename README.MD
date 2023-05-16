# ISO8583 Parser with GUI

A simple ISO8583 parser with graphical user interface written in Java using JavaFX and j8583 library.

# Download binaries

- [Windows x64](https://github.com/huckor/iso8583parser/releases/download/1.0.0/IsoParser-Win_x64.zip)
- [Linux x64](https://github.com/huckor/iso8583parser/releases/download/1.0.0/IsoParser-Linux_x64.zip)
- [MacOS x64](https://github.com/huckor/iso8583parser/releases/download/1.0.0/IsoParser-MacOS_x64.zip)

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

<img width="793" alt="gui-prewiev" src="https://github.com/huckor/iso8583parser/assets/20068605/1a8c8899-7815-48ed-87e0-9efff901c90c">

1. Paste your ISO8583 message in HEX format to this text box
2. Parsed output will appear in this text box
3. Press this button to parse your ISO8583 message
4. Use this button to load your custom ISO8583 template
5. Use spinner to skip first 'n' characters of your ISO8583 message. This is useful to skip message header.

This application expecting input data to be in HEX format. Message should start with MTI or use (5) spinner to skip first 'n' characters.

By default, this application using ISO8583 specs as defined in file [parser-template.xml](src/main/resources/com/huckor/isoparser/parser-template.xml).
In case your ISO8583 specs are different than you need to adjust template file accordingly [j8583 xml doc](https://j8583.sourceforge.net/xmlconf.html).

## How to Contribute

Contributions are highly encouraged and appreciated! If you have any ideas, suggestions, or bug fixes, please feel free to contribute. Here's how you can get started:

1. Fork this repository to your GitHub account.
2. Make the desired changes or add new features to your forked repository.
3. Write test cases for your changes.
4. Submit a pull request, explaining the changes you have made and why they are beneficial.
5. I will review your pull request as soon as possible and provide feedback if needed.
6. Once your changes are approved, they will be merged into the main repository.
7. Congratulations! You have successfully contributed to this project.

## Code Style and Guidelines

To maintain code consistency and readability, please adhere to the following guidelines:

- Write clean and self-explanatory code.
- Use meaningful variable and function names.
- Follow the established coding style and formatting.
- Add comments where necessary to improve code understanding.

## Issues and Bug Reports

If you come across any issues or bugs while using this project, please report them using the GitHub issue tracker. Include a detailed description of the problem, steps to reproduce it, and any relevant information that might help in resolving the issue.

## Support

If you need any assistance or have questions regarding this project, feel free to reach out to me. I'll do my best to help you.

## Spread the Word

If you find this project helpful or interesting, consider giving it a star on GitHub. Also, sharing it with others who might benefit from it would be greatly appreciated.

Thank you for your interest in this project.