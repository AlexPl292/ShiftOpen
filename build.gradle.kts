plugins {
    id("org.jetbrains.intellij") version "0.4.10"
    kotlin("jvm") version "1.3.50"
}

group = "dev.feedforward"
version = "1.0"

repositories {
    mavenCentral()
}

intellij {
    version = "2019.2"
    pluginName = "ShiftOpen"
    updateSinceUntilBuild = false
    downloadSources = true
    instrumentCode = true
}
