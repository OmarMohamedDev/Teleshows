package com.omarmohameddev.teleshows.di.component

import com.omarmohameddev.teleshows.ui.list.ListActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface ListSubComponent : AndroidInjector<ListActivity>{

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ListActivity>()
}
