package com.omarmohameddev.teleshows.di.component

import com.omarmohameddev.teleshows.TeleshowsApp
import com.omarmohameddev.teleshows.di.module.AppModule
import com.omarmohameddev.teleshows.di.module.DetailModule
import com.omarmohameddev.teleshows.di.module.ListModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class
))

interface AppComponent {

    // Injectors
    fun injectTo(app: TeleshowsApp)

    // Submodule methods
    // Every screen is its own submodule of the graph and must be added here.
    fun plus(module: ListModule): ListComponent
    fun plus(module: DetailModule): DetailComponent
}