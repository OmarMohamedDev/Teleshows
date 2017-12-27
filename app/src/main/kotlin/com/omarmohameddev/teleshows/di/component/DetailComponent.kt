package com.omarmohameddev.teleshows.di.component

import com.omarmohameddev.teleshows.di.module.DetailModule
import com.omarmohameddev.teleshows.di.scope.ActivityScope
import com.omarmohameddev.teleshows.ui.detail.DetailActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = arrayOf(
        DetailModule::class
))
interface DetailComponent : AndroidInjector<DetailActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<DetailActivity>()
}