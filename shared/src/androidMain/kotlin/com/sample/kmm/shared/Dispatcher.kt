package com.sample.kmm.shared

import io.ktor.client.*
import io.ktor.client.engine.*
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

internal actual val ApplicationDispatcher: CoroutineContext = Dispatchers.Default

actual val httpClientEngine: HttpClientEngine = HttpClient().engine