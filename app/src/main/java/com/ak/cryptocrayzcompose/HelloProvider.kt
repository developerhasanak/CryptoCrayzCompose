package com.ak.cryptocrayzcompose

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class HelloProvider : PreviewParameterProvider<String> {
    override val values: Sequence<String>
        get() = listOf("PreviewParameterProvider").asSequence()
}