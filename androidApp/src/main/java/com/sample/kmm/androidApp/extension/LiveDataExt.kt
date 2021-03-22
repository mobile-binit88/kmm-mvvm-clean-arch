package com.sample.kmm.androidApp.extension

import androidx.lifecycle.LifecycleOwner
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData


fun <T> LifecycleOwner.observe(liveData: MutableLiveData<T>, action: (t: T) -> Unit) {
    liveData.addObserver { it?.let { t -> action(t) } }
}