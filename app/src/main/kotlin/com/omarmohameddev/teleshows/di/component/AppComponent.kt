package com.omarmohameddev.teleshows.di.component

import android.app.Application
import com.omarmohameddev.teleshows.TeleshowsApp
import com.omarmohameddev.teleshows.di.module.AppModule
import com.omarmohameddev.teleshows.di.module.DetailModule
import com.omarmohameddev.teleshows.di.module.ListModule
import com.omarmohameddev.teleshows.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@ApplicationScope
@Singleton
@Component(modules = arrayOf(
        AppModule::class
))
interface AppComponent {

    //Builder
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    // Injectors
    fun injectTo(app: TeleshowsApp)

    // Submodule methods
    // Every screen is its own submodule of the graph and must be added here.
    fun plus(module: ListModule): ListComponent
    fun plus(module: DetailModule): DetailComponent
}