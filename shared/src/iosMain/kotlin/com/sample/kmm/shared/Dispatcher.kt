package com.sample.kmm.shared

import io.ktor.client.engine.*
import io.ktor.client.engine.ios.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext

internal actual val ApplicationDispatcher: CoroutineContext = NsQueueDispatcher(
    dispatch_get_main_queue())

internal class NsQueueDispatcher(
    private val dispatchQueue: dispatch_queue_t
): CoroutineDispatcher(){

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue){
            block.run()
        }
    }
}

actual val httpClientEngine: HttpClientEngine
     get() = Ios.create()


