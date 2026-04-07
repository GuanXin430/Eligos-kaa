
dependencies {
    api(project(":kt-references-analysis:analysis-api-impl-base"))
    api(project(":kt-references-analysis:analysis-internal-utils"))
    api(project(":kt-references-analysis:kt-references-fe10"))
    api("org.jetbrains.kotlin:kotlin-compiler:2.3.0")
}


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        freeCompilerArgs.add("-opt-in=kotlin.RequiresOptIn")
        freeCompilerArgs.add("-Xcontext-receivers")
        freeCompilerArgs.add("-opt-in=org.jetbrains.kotlin.analysis.api.KtAnalysisApiInternals")
    }
}

sourceSets {
    main {

    }
}


