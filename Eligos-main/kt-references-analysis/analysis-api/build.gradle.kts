
dependencies {
    api(project(":kt-references-analysis:analysis-internal-utils"))
    api("org.jetbrains.kotlin:kotlin-compiler:2.3.0")
}

sourceSets {
    main {

    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        freeCompilerArgs.add("-Xcontext-receivers")
    }
}