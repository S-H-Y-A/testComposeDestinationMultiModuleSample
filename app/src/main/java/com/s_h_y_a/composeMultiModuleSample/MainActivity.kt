package com.s_h_y_a.composeMultiModuleSample

import NavigateToDownload
import NavigateToError
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.s_h_y_a.composeMultiModuleSample.core.ui.destinations.ErrorDialogDestination
import com.s_h_y_a.composeMultiModuleSample.download.ui.ApkDownloadDialog
import com.s_h_y_a.composeMultiModuleSample.download.ui.destinations.ApkDownloadDialogDestination
import com.s_h_y_a.composeMultiModuleSample.home.ui.HomeScreen
import com.s_h_y_a.composeMultiModuleSample.home.ui.destinations.HomeScreenDestination
import com.s_h_y_a.composeMultiModuleSample.ui.theme.ComposeMultiModuleSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMultiModuleSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DestinationsNavHost(navGraph = NavGraphs.home) {
                        composable(HomeScreenDestination) {
                            HomeScreen(
                                navigateToDowload = object : NavigateToDownload {
                                    override fun navigate(navigator: DestinationsNavigator) {
                                        navigator.navigate(ApkDownloadDialogDestination)
                                    }
                                },
                                navigator = destinationsNavigator
                            )
                        }

                        composable(ApkDownloadDialogDestination) {
                            ApkDownloadDialog(
                                navigateToError = object : NavigateToError {
                                    override fun navigate(navigator: DestinationsNavigator) {
                                        navigator.navigate(
                                            ErrorDialogDestination.invoke(
                                                title = R.string.app_error_title,
                                                message = R.string.app_error_message
                                            )
                                        )
                                    }
                                },
                                navigator = destinationsNavigator
                            )
                        }
                    }
                }
            }
        }
    }
}
