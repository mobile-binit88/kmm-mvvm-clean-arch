package com.sample.kmm.shared.viewmodel.category

import com.sample.kmm.shared.base.Response
import com.sample.kmm.shared.di.kodeinInjector
import com.sample.kmm.shared.model.response.CategoryResponse
import com.sample.kmm.shared.usecase.CategoryListUseCase
import com.sample.kmm.shared.utils.coroutines.launchSilent
import com.sample.kmm.shared.viewmodel.BaseViewModel
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import org.kodein.di.instance
import kotlin.coroutines.CoroutineContext
import com.sample.kmm.shared.model.request.CategotyRequest

class CategoryViewModel : BaseViewModel() {

    // LIVE DATA
    var mCategoryLiveData = MutableLiveData<CategoryRepoListState>(LoadingState())

    // USE CASE
    private val mCategoryUsecase by kodeinInjector.instance<CategoryListUseCase>()

    // ASYNC - COROUTINES
    private val coroutineContext by kodeinInjector.instance<CoroutineContext>()
    private var job: Job = Job()
    private val exceptionHandler = CoroutineExceptionHandler { _, _ -> }

    fun getCategoryResponse() = launchSilent(coroutineContext, exceptionHandler, job) {
        mCategoryLiveData.postValue(LoadingState())

        val request = CategotyRequest()
        val response = mCategoryUsecase.execute(request)
        processCategoryResponse(response)
    }

    private fun processCategoryResponse(response: Response<List<CategoryResponse>>) {
        if (response is Response.Success) {
            mCategoryLiveData.postValue(SuccessState(response))
        } else if (response is Response.Error) {
            mCategoryLiveData.postValue(ErrorState(response))
        }
    }

}