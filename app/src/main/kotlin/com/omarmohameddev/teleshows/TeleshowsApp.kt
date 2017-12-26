package com.omarmohameddev.teleshows

import android.app.Application
import com.omarmohameddev.teleshows.di.component.AppComponent
import com.omarmohameddev.teleshows.di.component.DaggerAppComponent
import com.omarmohameddev.teleshows.di.module.AppModule
import timber.log.Timber
import dagger.Lazy
import javax.inject.Inject

class TeleshowsApp : Application() {

    @Inject
    lateinit var debugTree: Lazy<Timber.DebugTree>

    companion object {
        lateinit var graph: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initDependencyGraph()

        if (BuildConfig.DEBUG) {
            Timber.plant(debugTree.get())
        }
    }

    private fun initDependencyGraph() {
        graph = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        graph.injectTo(this)
    }
}