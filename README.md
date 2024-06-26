# Mastermind 

[![Build Status](https://github.com/doppelganger9/mastermind/actions/workflows/maven.yml/badge.svg)](https://github.com/doppelganger9/mastermind/actions) [![Coverage Status](https://coveralls.io/repos/github/doppelganger9/mastermind/badge.svg?branch=master)](https://coveralls.io/github/doppelganger9/mastermind?branch=master) [![BCH compliance](https://bettercodehub.com/edge/badge/doppelganger9/mastermind?branch=master)](https://bettercodehub.com/) [![Maintainability](https://api.codeclimate.com/v1/badges/85d4fe610960fbf03604/maintainability)](https://codeclimate.com/github/doppelganger9/mastermind/maintainability) [![Known Vulnerabilities](https://snyk.io/test/github/doppelganger9/mastermind/badge.svg?targetFile=pom.xml)](https://snyk.io/test/github/doppelganger9/mastermind?targetFile=pom.xml) [![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fdoppelganger9%2Fmastermind.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2Fdoppelganger9%2Fmastermind?ref=badge_shield)

This project aims to replicate the classic board game [Mastermind](https://en.wikipedia.org/wiki/Mastermind_(board_game))
Sample code provided in Java language.

You are the player.

## How to use

- Prerequisite: Java 21 (or else use old version 1.0)
- `mvn package && java --enable-preview -jar target/mastermind-1.1-SNAPSHOT.jar`
- give answers through STDIN + ENTER key to validate.
  Use **R**ed **J**=Yellow, **B**lue, **O**range, **V**=Green, **N**=Black.
- win 😎 !

## Bonus: Running & Debugging on VSCode

I used this project as a Test Drive for Java support on **Visual Studo Code**.

I used these extensions:

- Language Support for Java by RedHat,
- Debugger for Java,
- Java Test Runner,

For Lombok support, I had to tweak my config:

```json
  "java.jdt.ls.vmargs":
    "-javaagent:/path/to/.m2/repository/org/projectlombok/lombok/1.16.18/lombok-1.16.18.jar -Xbootclasspath/a:/path/to/.m2/repository/org/projectlombok/lombok/1.16.18/lombok-1.16.18.jar",
```

After that VSCode was able to correctly pick up `@Getter`, `@Setter`, etc.

Then, to debug:

- `mvn -Dmaven.surefire.debug test`
- Then use the `Debug (Attach)` launch configuration in Visual Studio Code to debug step by step.

Or use the integrated terminal window and run maven commands.

## Future

In the future I will add auto-play to try the **Five-guess algorithm** and the **Genetic Algorithm**

## License

MIT see [LICENSE](LICENSE).

[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fdoppelganger9%2Fmastermind.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2Fdoppelganger9%2Fmastermind?ref=badge_large)
