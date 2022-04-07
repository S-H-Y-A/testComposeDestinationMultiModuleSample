package com.s_h_y_a.composeMultiModuleSample.download.ui

import NavigateToError
import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.DialogProperties
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.spec.DestinationStyle
import kotlinx.coroutines.delay

@Destination(navGraph = "download", style = ApkDownloadDialogStyle::class)
@Composable
fun ApkDownloadDialog(
    navigateToError: NavigateToError,
    navigator: DestinationsNavigator
) {
    LaunchedEffect(key1 = navigator) {
        delay(2000L)
        navigateToError.navigate(navigator)
    }
    Column {
        CircularProgressIndicator()
        Text("Downloading")
    }
}

object ApkDownloadDialogStyle : DestinationStyle.Dialog {
    override val properties = DialogProperties(
        dismissOnClickOutside = true,
        dismissOnBackPress = true,
    )
}
