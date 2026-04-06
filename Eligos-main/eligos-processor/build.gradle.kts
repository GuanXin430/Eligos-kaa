
dependencies {
    api(project(":eligos-core"))
    compileOnly("org.jetbrains.kotlin:kotlin-compiler:1.9.22")
    implementation(project(":eligos-issues"))
    compileOnly(project(":kt-references-analysis:kt-references-fe10"))
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    compileOnly("org.jetbrains.kotlin:analysis-api-k2-for-ide:2.3.0") {
        isTransitive = false
    }
    compileOnly("org.jetbrains.kotlin:analysis-api-for-ide:2.3.0") {
        isTransitive = false
    }
}
