package org.mosaif.ali

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.mosaif.ali.di.initKoin

class MainApplicaiton: Application(),KoinComponent {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@MainApplicaiton)
        }
    }
}