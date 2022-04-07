
import org.gradle.api.JavaVersion
import org.gradle.api.Project

object BuildInfo {
    const val compileSdk = 32
    const val minSdk = 21
    const val targetSdk = compileSdk
    const val baseAppId = "com.s_h_y_a.composeMultiModuleSample"
    const val versionCode = 1
    const val versionName = "1.0"

    val javaVersion = JavaVersion.VERSION_11
}
