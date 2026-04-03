plugins {
    kotlin("jvm") version "1.9.22"
}

repositories {
    mavenLocal()
    mavenCentral()
}

group = "org.jetbrains.kotlin"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(17)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
    kotlinOptions.freeCompilerArgs += "-Xcontext-receivers"
}

dependencies {
    // Kotlin compiler dependencies
    compileOnly("org.jetbrains.kotlin:kotlin-compiler:1.9.22")
    compileOnly("org.jetbrains.kotlin:kotlin-compiler-embeddable:1.9.22")
}
