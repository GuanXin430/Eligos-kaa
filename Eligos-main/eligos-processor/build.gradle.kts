
dependencies {
    api(project(":eligos-core"))
    compileOnly("org.jetbrains.kotlin:kotlin-compiler:2.3.0")
    implementation(project(":eligos-issues"))
    // 暂时移除对kt-references-analysis模块的依赖
    // compileOnly(project(":kt-references-analysis:kt-references-fe10"))
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}
