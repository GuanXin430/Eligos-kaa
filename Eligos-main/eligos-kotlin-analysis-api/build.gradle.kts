plugins {
    kotlin("jvm")
}

group = "com.github.tnoalex"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    api("org.jetbrains.kotlin:kotlin-analysis-api:2.3.0") { isTransitive = false }
    api("org.jetbrains.kotlin:kotlin-analysis-api-k2:2.3.0") { isTransitive = false }

    implementation("org.jetbrains.kotlin:kotlin-analysis-api-impl-base:2.3.0") { isTransitive = false }
    implementation("org.jetbrains.kotlin:kotlin-analysis-api-platform-interface:2.3.0") { isTransitive = false }
    implementation("org.jetbrains.kotlin:kotlin-low-level-api-fir:2.3.0") { isTransitive = false }
    implementation("org.jetbrains.kotlin:kotlin-symbol-light-classes:2.3.0") { isTransitive = false }
    //testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}