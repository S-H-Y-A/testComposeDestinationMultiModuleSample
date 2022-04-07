import de.fayard.refreshVersions.core.DependencyNotation

enum class ComposeOption(val dependency: DependencyNotation) {
    ConstraintLayout(AndroidX.ConstraintLayout.compose),
    Animation(AndroidX.Compose.animation),
    Graphics(AndroidX.Compose.Animation.graphics),
    ViewModel(AndroidX.Lifecycle.viewModelCompose),
    LiveData(AndroidX.Compose.Runtime.liveData),
    HiltNavigationViewModel(AndroidX.Hilt.navigationCompose)
}
