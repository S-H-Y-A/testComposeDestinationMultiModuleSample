
import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension

val androidExtension = project.extensions.findByType(BaseExtension::class)
androidExtension?.run {
    compileSdkVersion(BuildInfo.compileSdk)
    defaultConfig {
        targetSdk = BuildInfo.targetSdk
        minSdk = BuildInfo.minSdk
        if (androidExtension is AppExtension) {
            applicationId = BuildInfo.baseAppId
            versionCode = BuildInfo.versionCode
            versionName = BuildInfo.versionName
        }
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        if (androidExtension is LibraryExtension) {
            consumerProguardFiles("proguard-rules.pro")
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            if (androidExtension is AppExtension) {
                isShrinkResources = true
            }
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true

        sourceCompatibility = BuildInfo.javaVersion
        targetCompatibility = BuildInfo.javaVersion
    }
}

dependencies {
    add("coreLibraryDesugaring", Android.tools.desugarJdkLibs)
}
