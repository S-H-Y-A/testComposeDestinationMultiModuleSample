package com.s_h_y_a.composeMultiModuleSample.home.ui

import NavigateToDownload
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(navGraph = "home")
@Composable
fun HomeScreen(
    navigateToDowload: NavigateToDownload,
    navigator: DestinationsNavigator
) {
    Box {
        Button(onClick = { navigateToDowload.navigate(navigator) }) {
            Text("Navigate")
        }
    }
}

