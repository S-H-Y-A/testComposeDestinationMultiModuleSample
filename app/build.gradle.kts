plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.devtools.ksp")
    id("myplugin.compose")
    id("myplugin.default")
}

android {
    kotlinOptions {
        jvmTarget = BuildInfo.javaVersion.toString()
    }
}

dependencies {
    implementation(KotlinX.coroutines.android)
    implementation(AndroidX.Core.ktx)
    implementation(Google.android.material)
    testImplementation(Testing.junit4)
    androidTestImplementation(AndroidX.test.ext.junit)
    androidTestImplementation(AndroidX.test.espresso.core)
    implementation(Deps.ComposeDestination.core)
    ksp(Deps.ComposeDestination.ksp)

    implementation(project(":core"))
    implementation(project(":download"))
    implementation(project(":home"))
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
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "app")
}
