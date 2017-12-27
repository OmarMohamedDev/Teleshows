package com.omarmohameddev.teleshows.presentation.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.omarmohameddev.teleshows.domain.interactor.list.GetTeleshows
import com.omarmohameddev.teleshows.model.Teleshow
import com.omarmohameddev.teleshows.presentation.data.Resource
import com.omarmohameddev.teleshows.presentation.data.ResourceState
import io.reactivex.subscribers.DisposableSubscriber
import javax.inject.Inject

open class ListTeleshowsViewModel @Inject internal constructor(
        private val getTeleshows: GetTeleshows) : ViewModel() {

    private val teleshowsLiveData: MutableLiveData<Resource<List<Teleshow>>> =
            MutableLiveData()

    init {
        fetchTeleshows()
    }

    override fun onCleared() {
        getTeleshows.dispose()
        super.onCleared()
    }

    fun getTeleshows(): LiveData<Resource<List<Teleshow>>> {
        return teleshowsLiveData
    }

    fun fetchTeleshows() {
        teleshowsLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        return getTeleshows.execute(TeleshowsSubscriber())
    }

    inner class TeleshowsSubscriber : DisposableSubscriber<List<Teleshow>>() {

        override fun onComplete() { }

        override fun onNext(t: List<Teleshow>) {
            teleshowsLiveData.postValue(Resource(ResourceState.SUCCESS,
                    t.map { it }, null))
        }

        override fun onError(exception: Throwable) {
            teleshowsLiveData.postValue(Resource(ResourceState.ERROR, null, exception.message))
        }

    }

}