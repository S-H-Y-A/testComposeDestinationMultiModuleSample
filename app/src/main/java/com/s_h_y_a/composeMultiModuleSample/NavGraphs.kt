package com.s_h_y_a.composeMultiModuleSample

import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.s_h_y_a.composeMultiModuleSample.core.ui.destinations.ErrorDialogDestination
import com.s_h_y_a.composeMultiModuleSample.download.ui.destinations.ApkDownloadDialogDestination
import com.s_h_y_a.composeMultiModuleSample.home.ui.destinations.HomeScreenDestination

object NavGraphs {

    val download = object : NavGraphSpec {
        override val route = "download"
        override val startRoute = ApkDownloadDialogDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            ApkDownloadDialogDestination,
            ErrorDialogDestination,
        ).routedIn(this)
            .associateBy { it.route }
    }

    val home = object : NavGraphSpec {
        override val route = "home"

        override val startRoute = HomeScreenDestination routedIn this

        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            HomeScreenDestination
        ).routedIn(this)
            .associateBy { it.route }

        // 一時的に設定
        override val nestedNavGraphs = listOf(download)
    }
}
