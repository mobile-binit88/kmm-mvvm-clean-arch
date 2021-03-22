package com.sample.kmm.shared

import io.ktor.client.engine.*
import kotlin.coroutines.CoroutineContext

internal expect val ApplicationDispatcher: CoroutineContext

expect val httpClientEngine: HttpClientEngine
