package com.omarmohameddev.teleshows.di.module

import android.app.ListActivity
import com.omarmohameddev.teleshows.di.scope.ActivityScope
import com.omarmohameddev.teleshows.ui.detail.DetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(ListModule::class, DetailModule::class))
    abstract fun bindListActivity(): ListActivity
    abstract fun bindDetailActivity(): DetailActivity
}