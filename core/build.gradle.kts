
plugins {
    id("com.android.library")
    id("kotlin-android")
    id("com.google.devtools.ksp")
    id("myplugin.default")
    id("myplugin.compose")
}

android {
    kotlinOptions {
        jvmTarget = BuildInfo.javaVersion.toString()
    }
}

dependencies {
    implementation(Deps.ComposeDestination.core)
    ksp(Deps.ComposeDestination.ksp)
}

kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}

ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "core")
}

