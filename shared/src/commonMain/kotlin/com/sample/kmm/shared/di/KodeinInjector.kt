package com.sample.kmm.shared.di

import com.jarroyo.kotlinmultiplatform.source.network.NewtorkService
import com.sample.kmm.shared.ApplicationDispatcher
import com.sample.kmm.shared.httpClientEngine
import com.sample.kmm.shared.network.INetworkDataSource
import com.sample.kmm.shared.network.NetworkDataSource
import com.sample.kmm.shared.repository.CategoryRepository
import com.sample.kmm.shared.usecase.CategoryListUseCase
import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import org.kodein.di.*
import kotlin.coroutines.CoroutineContext
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
val kodeinInjector = DI {

    bind<CoroutineContext>() with provider { ApplicationDispatcher }

    val client = HttpClient(httpClientEngine) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(json = kotlinx.serialization.json.Json {
                isLenient = false
                ignoreUnknownKeys = true
                allowSpecialFloatingPointValues = true
                useArrayPolymorphism = false
            })
        }
    }

    /**
     * USECASES
     */
    bind<CategoryListUseCase>() with singleton { CategoryListUseCase(instance()) }

    /**
     * REPOSITORIES
     */
    bind<CategoryRepository>() with provider { CategoryRepository(instance()) }


    /**
     * NETWORK DATA SOURCE
     */
    bind<INetworkDataSource>() with provider { NetworkDataSource(instance()) }


    /**
     * NETWORK API
     */
    bind<NewtorkService>() with provider { NewtorkService(client) }

}