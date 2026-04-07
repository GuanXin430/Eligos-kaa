import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

dependencies {
    api(project(":kt-references-analysis:analysis-api"))
    api("org.jetbrains.kotlin:kotlin-compiler:2.3.0")
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        freeCompilerArgs.add("-Xcontext-receivers")
        freeCompilerArgs.add("-opt-in=org.jetbrains.kotlin.analysis.api.KtAnalysisApiInternals")
    }
}

sourceSets {
    main {

    }
}
