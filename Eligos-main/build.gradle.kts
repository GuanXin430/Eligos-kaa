import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm") version "1.9.22"
}

repositories {
    mavenLocal()
    mavenCentral()
}

allprojects {
    group = "com.github.tnoalex"
    version = "1.0-SNAPSHOT"
}

tasks.jar {
    enabled = false
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    kotlin {
        jvmToolchain(17)
    }

    // ========== 新增：添加 KAA 依赖（PSI 迁移核心） ==========
    dependencies {
        // KAA 核心 API（与 Kotlin 版本 1.9.22 严格匹配）
        implementation("org.jetbrains.kotlin:kotlin-analysis-api:1.9.22")
        // 若需 KAA 实现层（非仅 API，多数场景需要）
        implementation("org.jetbrains.kotlin:kotlin-analysis-api-impl:1.9.22")

        // 若项目原本依赖 PSI 相关库（比如 intellij PSI），需在此移除/排除：
        // 示例（根据实际情况调整）：
        // implementation("com.intellij:psi-api:2023.1") { exclude(group = "com.intellij") }
    }


    tasks.test {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    configurations.forEach {
        it.exclude(group = "org.slf4j", module = "slf4j-reload4j")
    }

    tasks.withType<Jar> {
        isZip64 = true
    }

    repositories {
        mavenLocal()
        maven {
            url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-ide-plugin-dependencies/")
        }
        maven {
        url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/")
    }
        maven {
        url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-coroutines/")
        }
        maven {
            url = uri("https://www.jetbrains.com/intellij-repository/releases/")
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/public/")
        }
        mavenCentral()
    }
}

