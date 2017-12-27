package com.omarmohameddev.teleshows.presentation.list

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.omarmohameddev.teleshows.domain.interactor.list.GetTeleshows

open class ListTeleshowsViewModelFactory(
        private val getTeleshows: GetTeleshows) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListTeleshowsViewModel::class.java)) {
            return ListTeleshowsViewModel(getTeleshows) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
