# Spigot Plugin Project

This is a basic Spigot plugin project created with Java 21, Gradle, and Kotlin DSL.

## Setup

To build this project, make sure you have Gradle installed and run:

```bash
./gradlew build
```

Your plugin JAR will be created in the `build/libs` directory.

## Structure

- `src/main/java/com/example/plugin/` - Main plugin source code
- `src/main/resources/plugin.yml` - Plugin configuration file
- `build.gradle.kts` - Gradle build configuration using Kotlin DSL
- `settings.gradle.kts` - Gradle settings

## Requirements

- Java 21
- Gradle
- Spigot API 1.20.6

## Customization

To customize this plugin for your needs:

1. Change the package name in the source files
2. Update the `main` class in `plugin.yml`
3. Modify the plugin information in `plugin.yml`
4. Add your functionality to the main plugin class