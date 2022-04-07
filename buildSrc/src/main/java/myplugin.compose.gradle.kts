
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.InternalApplicationExtension
import com.android.build.gradle.internal.dsl.InternalLibraryExtension
import de.fayard.refreshVersions.core.versionFor

val extension = project.extensions.findByType(BaseExtension::class)

extension?.run {
    when (this) {
        is InternalApplicationExtension -> {
            buildFeatures {
                compose = true
            }
        }
        is InternalLibraryExtension -> {
            buildFeatures {
                compose = true
            }
        }
    }
    composeOptions {
        kotlinCompilerExtensionVersion = versionFor(AndroidX.compose.ui)
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val composeVersion = versionFor(AndroidX.Compose.ui)
    add("implementation", AndroidX.Compose.ui)
    listOf(
        AndroidX.Activity.compose,
        AndroidX.Compose.foundation,
        AndroidX.Compose.animation,
        AndroidX.Compose.Material.Icons.core,
        AndroidX.Compose.Material.Icons.extended,
        AndroidX.Compose.Material.ripple,
        AndroidX.Compose.Ui.toolingPreview
    ).forEach { add("implementation", it.withVersion(composeVersion)) }

    add("implementation", AndroidX.Compose.material)
    add("debugImplementation", AndroidX.Compose.Ui.tooling.withVersion(composeVersion))
    add("androidTestImplementation", AndroidX.Compose.Ui.testJunit4.withVersion(composeVersion))
}
