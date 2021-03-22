package com.sample.kmm.shared.di

import com.sample.kmm.shared.utils.ContextArgs

object InjectorCommon {

    lateinit var mContextArgs: ContextArgs

    fun provideContextArgs(contextArgs: ContextArgs): ContextArgs{
        mContextArgs = contextArgs
        return mContextArgs
    }

}