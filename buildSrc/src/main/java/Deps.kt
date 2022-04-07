import org.gradle.api.artifacts.dsl.DependencyHandler

object Deps {

    object ComposeDestination {
        const val core = "io.github.raamcosta.compose-destinations:core:_"
        const val ksp = "io.github.raamcosta.compose-destinations:ksp:_"
    }
}

fun DependencyHandler.implementationComposeOptions(
    vararg options: ComposeOption
) {
    options.forEach {
        add("implementation", it.dependency)
    }
}
