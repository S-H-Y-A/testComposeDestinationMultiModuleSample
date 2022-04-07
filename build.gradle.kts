// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(Google.dagger.hilt.android.gradlePlugin)
        classpath("com.squareup:javapoet:_")
        classpath("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:_") // ktlint-disable max-line-length
    }
}

plugins {
    id("com.android.application") apply false
    id("com.android.library") apply false
    id("org.jetbrains.kotlin.android") apply false
}
task<Delete>("clean") {
    delete(rootProject.buildDir)
}
