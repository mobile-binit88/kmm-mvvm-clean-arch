buildscript {
    val kotlin_version by extra("1.3.72")
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
        maven(url = "https://dl.bintray.com/kodein-framework/Kodein-DI/org/kodein/di/")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
        classpath("com.android.tools.build:gradle:4.1.2")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        jcenter()
        maven(url = "https://dl.bintray.com/florent37/maven")
        maven(url = "https://dl.bintray.com/icerockdev/moko")
        maven(url = "https://dl.bintray.com/kodein-framework/Kodein-DI")
    }
}
