package com.omarmohameddev.teleshows.di.module

import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import com.omarmohameddev.teleshows.TeleshowsApp
import com.omarmohameddev.teleshows.di.qualifier.ApplicationQualifier
import dagger.Module
import dagger.Provides
import timber.log.Timber
import javax.inject.Singleton

@Module
class AppModule(private val app: TeleshowsApp) {

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides @Singleton @ApplicationQualifier
    fun provideContext(): Context = app.baseContext

    @Provides @Singleton
    fun provideResources(): Resources = app.resources

    @Provides @Singleton
    fun provideLayoutInflater(@ApplicationQualifier context: Context): LayoutInflater {
        return LayoutInflater.from(context)
    }

    @Provides
    fun provideDebugTree(): Timber.DebugTree = Timber.DebugTree()
}