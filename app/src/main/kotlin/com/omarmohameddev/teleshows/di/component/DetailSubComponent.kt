package com.omarmohameddev.teleshows.di.component

import com.omarmohameddev.teleshows.ui.detail.DetailActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface DetailSubComponent : AndroidInjector<DetailActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<DetailActivity>()
}