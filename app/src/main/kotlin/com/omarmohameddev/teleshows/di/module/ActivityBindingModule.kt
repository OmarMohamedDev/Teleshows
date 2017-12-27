package com.omarmohameddev.teleshows.di.module

import com.omarmohameddev.teleshows.ui.detail.DetailActivity
import com.omarmohameddev.teleshows.ui.list.ListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindListActivity(): ListActivity

    @ContributesAndroidInjector
    abstract fun bindDetailActivity(): DetailActivity
}