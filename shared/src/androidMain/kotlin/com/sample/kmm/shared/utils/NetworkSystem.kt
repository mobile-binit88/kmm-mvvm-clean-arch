package com.sample.kmm.shared.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import com.sample.kmm.shared.di.InjectorCommon

actual class ContextArgs(var mContext: Context)


actual fun isNetworkAvailable(): Boolean{
    var isNetworkAvailable: Boolean = false
    val context = InjectorCommon.mContextArgs.mContext
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
            as ConnectivityManager
    val builder: NetworkRequest.Builder = NetworkRequest.Builder()
    connectivityManager.registerNetworkCallback(builder.build(),
        object: ConnectivityManager.NetworkCallback(){
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                isNetworkAvailable = true
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                isNetworkAvailable = false
            }
        })
    return isNetworkAvailable
}