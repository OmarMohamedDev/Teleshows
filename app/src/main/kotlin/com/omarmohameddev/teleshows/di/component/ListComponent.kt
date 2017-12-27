package com.omarmohameddev.teleshows.di.component

import com.omarmohameddev.teleshows.di.module.ListModule
import com.omarmohameddev.teleshows.di.scope.ActivityScope
import com.omarmohameddev.teleshows.ui.list.ListActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = arrayOf(
        ListModule::class
))
interface ListComponent :AndroidInjector<ListActivity>{

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ListActivity>()
}