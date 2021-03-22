package com.sample.kmm.shared.utils.coroutines

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun launchSilent(
    context: CoroutineContext = Dispatchers.Main,
    exceptionHandler: CoroutineExceptionHandler? = null,
    job: Job,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
){
    val coroutineScope = if (exceptionHandler!=null){
        CoroutineScope(
            context + job + exceptionHandler
        )

    }else{
        CoroutineScope(
            context + job
        )

    }

    coroutineScope.launch(context,start,block)
}