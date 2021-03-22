import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-android-extensions")
    kotlin("plugin.serialization") version "1.4.21"
}
apply(from = "../versions.gradle.kts")

val kodeinVersion: String by extra
val coroutineVersion: String by extra
val serializerVersion: String by extra
val ktorVersion: String by extra
val mockkVersion: String by extra
val mokoMvvmVersion: String by extra

kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    sourceSets {
        val commonMain by getting{
            dependencies{

                // KODE IN
                implementation("org.kodein.di:kodein-di:$kodeinVersion")

                //COROUTINE
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")

                // SERIALIZATION
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializerVersion")

                //KTOR
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-json:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")

                //Mockk
                implementation("io.mockk:mockk:$mockkVersion")


                // MOKO - MVVM
                implementation("dev.icerock.moko:mvvm:$mokoMvvmVersion")
                implementation("dev.icerock.moko:resources:0.13.0")
                implementation("dev.icerock.moko:parcelize:0.4.0")
                implementation("dev.icerock.moko:graphics:0.4.0")


            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.google.android.material:material:1.2.1")

                //COROUTINE
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion")

                //KTOR
                implementation("io.ktor:ktor-client-android:$ktorVersion")

            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13")
            }
        }
        val iosMain by getting {
            dependencies{

                //COROUTINE
//                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$coroutineVersion")

                //KTOR
                implementation("io.ktor:ktor-client-ios:$ktorVersion")
            }
        }
        val iosTest by getting
    }
}

android {
    compileSdkVersion(29)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}

tasks.getByName("build").dependsOn(packForXcode)