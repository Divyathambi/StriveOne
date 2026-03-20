plugins {
    id("org.jetbrains.intellij") version "1.17.2"
    kotlin("jvm") version "1.9.22"
}

group = "org.example"
version = "1.0.0"

repositories {
    mavenCentral()
}

intellij {
    type.set("AI")
    version.set("2023.1.1.28")
}

kotlin {
    jvmToolchain(21)
}