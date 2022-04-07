package com.s_h_y_a.composeMultiModuleSample.core.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.DialogProperties
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.spec.DestinationStyle

@Destination(navGraph = "download", style = ErrorDialogStyle::class)
@Composable
fun ErrorDialog(
    @StringRes
    title: Int,
    @StringRes
    message: Int
) {
    Column {
        Text(text = stringResource(title))
        Text(text = stringResource(message))
    }
}

object ErrorDialogStyle : DestinationStyle.Dialog {
    override val properties = DialogProperties(
        dismissOnClickOutside = true,
        dismissOnBackPress = true,
    )
}
