package com.omarmohameddev.teleshows.di.module

import android.arch.lifecycle.ViewModelProvider
import com.omarmohameddev.teleshows.presentation.list.ListTeleshowsViewModel
import com.omarmohameddev.teleshows.presentation.util.ViewModelUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class ListModule {

    @Singleton
    @Provides
    fun provideViewModel(viewModelUtil: ViewModelUtil, viewModel: ListTeleshowsViewModel):
            ViewModelProvider.Factory {
        return viewModelUtil.createFor(viewModel)
    }
}