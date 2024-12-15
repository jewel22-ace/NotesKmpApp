package org.mosaif.ali

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.mosaif.ali.di.androidModule
import org.mosaif.ali.di.initKoin

class MainApplicaiton: Application(),KoinComponent {
    override fun onCreate() {
        super.onCreate()
//        startKoin {
//            androidContext(this@MainApplicaiton)
//            modules(listOf(androidModule(this@MainApplicaiton)))
//        }
        initKoin {
            androidLogger()
            androidContext(this@MainApplicaiton)
        }
    }
}