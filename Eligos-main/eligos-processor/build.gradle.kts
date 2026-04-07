
dependencies {
    api(project(":eligos-core"))
    compileOnly("org.jetbrains.kotlin:kotlin-compiler:2.3.0")
    implementation(project(":eligos-issues"))
    implementation(project(":eligos-kotlin-analysis-api"))
    // 暂时移除对kt-references-analysis模块的依赖
    // compileOnly(project(":kt-references-analysis:kt-references-fe10"))
    //compileOnly("org.jetbrains.kotlin:analysis-api-k2-for-ide:2.3.0") {isTransitive = false }
    //compileOnly("org.jetbrains.kotlin:analysis-api-for-ide:2.3.0") {isTransitive = false}
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}
