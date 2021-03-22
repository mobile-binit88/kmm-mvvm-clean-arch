package com.sample.kmm.androidApp

import android.app.Application
import com.sample.kmm.shared.di.InjectorCommon
import com.sample.kmm.shared.utils.ContextArgs

open class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        InjectorCommon.provideContextArgs(ContextArgs(this))
    }
}