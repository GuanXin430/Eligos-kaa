pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "Eligos"
include("eligos-plugin")
// 暂时跳过eligos-cli模块，因为它在Kotlin 2.3.0中存在兼容性问题
// include("eligos-cli")
include("eligos-core")
include("eligos-processor")
// 暂时跳过kt-references-analysis模块，因为它在Kotlin 2.3.0中存在兼容性问题
// include(
//     ":kt-references-analysis:analysis-api",
//     ":kt-references-analysis:analysis-api-fe10",
//     ":kt-references-analysis:analysis-api-impl-base",
//     ":kt-references-analysis:analysis-internal-utils",
//     ":kt-references-analysis:kt-references-fe10")
include("eligos-issues")
include("eligos-formatter")
