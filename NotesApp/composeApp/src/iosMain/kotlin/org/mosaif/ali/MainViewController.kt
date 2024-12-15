package org.mosaif.ali

import androidx.compose.ui.window.ComposeUIViewController
import org.mosaif.ali.di.initKoin


fun MainViewController() = ComposeUIViewController(
    content = {
        initKoin()
    }
){
    App()
}