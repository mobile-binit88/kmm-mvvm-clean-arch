plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
}
apply(from = "../versions.gradle.kts")

val androidMaterialVersion: String by extra
val appcompatVersion: String by extra
val constraintlayoutVersion: String by extra
val viewpagerVersion: String by extra
val intuitVersion: String by extra
val navigationVersion: String by extra
val mokoMvvmVersion: String by extra
val coilVersion: String by extra

dependencies {
    implementation(project(":shared"))
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationVersion")
    implementation("com.google.android.material:material:$androidMaterialVersion")
    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    implementation("androidx.constraintlayout:constraintlayout:$constraintlayoutVersion")
    implementation("androidx.viewpager:viewpager:$viewpagerVersion")
    implementation("com.intuit.sdp:sdp-android:$intuitVersion")
    implementation("dev.icerock.moko:mvvm:$mokoMvvmVersion")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    // MOKO - MVVM
    implementation("dev.icerock.moko:mvvm:$mokoMvvmVersion")
    implementation("dev.icerock.moko:resources:0.13.0")
    implementation("dev.icerock.moko:parcelize:0.4.0")
    implementation("dev.icerock.moko:graphics:0.4.0")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "com.ecommerce.aapka_interior.androidApp"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        viewBinding = true
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
