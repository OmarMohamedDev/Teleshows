package com.omarmohameddev.teleshows.di.component

import android.app.Application
import com.omarmohameddev.teleshows.TeleshowsApp
import com.omarmohameddev.teleshows.di.module.ActivityBindingModule
import com.omarmohameddev.teleshows.di.module.AppModule
import com.omarmohameddev.teleshows.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(modules = arrayOf(ActivityBindingModule::class,
        AppModule::class,
        AndroidSupportInjectionModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: TeleshowsApp)

}