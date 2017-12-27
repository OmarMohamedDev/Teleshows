package com.omarmohameddev.teleshows.di.module

import android.app.Application
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import com.omarmohameddev.teleshows.BuildConfig
import com.omarmohameddev.teleshows.TeleshowsApp
import com.omarmohameddev.teleshows.cache.PreferencesHelper
import com.omarmohameddev.teleshows.cache.TeleshowsCacheImpl
import com.omarmohameddev.teleshows.cache.db.TeleshowsDatabase
import com.omarmohameddev.teleshows.cache.db.TeleshowsDbConstants
import com.omarmohameddev.teleshows.data.executor.JobExecutor
import com.omarmohameddev.teleshows.data.repository.TeleshowsCache
import com.omarmohameddev.teleshows.data.repository.TeleshowsDataRepository
import com.omarmohameddev.teleshows.data.repository.TeleshowsRemote
import com.omarmohameddev.teleshows.data.source.TeleshowsDataStoreFactory
import com.omarmohameddev.teleshows.di.qualifier.ApplicationQualifier
import com.omarmohameddev.teleshows.di.scope.ApplicationScope
import com.omarmohameddev.teleshows.domain.executor.PostExecutionThread
import com.omarmohameddev.teleshows.domain.executor.ThreadExecutor
import com.omarmohameddev.teleshows.domain.repository.TeleshowsRepository
import com.omarmohameddev.teleshows.remote.TeleshowsRemoteImpl
import com.omarmohameddev.teleshows.remote.TeleshowsService
import com.omarmohameddev.teleshows.remote.TeleshowsServiceFactory
import com.omarmohameddev.teleshows.ui.UiThread
import dagger.Module
import dagger.Provides
import timber.log.Timber
import javax.inject.Singleton

@Module
class AppModule(private val app: TeleshowsApp) {

    @Provides
    @ApplicationScope
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @ApplicationScope
    internal fun providePreferencesHelper(context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }


    @Provides
    @ApplicationScope
    internal fun provideTeleshowsRepository(factory: TeleshowsDataStoreFactory): TeleshowsRepository {
        return TeleshowsDataRepository(factory)
    }

    @Provides
    @ApplicationScope
    internal fun provideTeleshowsCache(database: TeleshowsDatabase,
                                       helper: PreferencesHelper): TeleshowsCache {
        return TeleshowsCacheImpl(database, helper)
    }

    @Provides
    @ApplicationScope
    internal fun provideTeleshowsRemote(service: TeleshowsService): TeleshowsRemote {
        return TeleshowsRemoteImpl(service)
    }

    @Provides
    @ApplicationScope
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @ApplicationScope
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @ApplicationScope
    internal fun provideTeleshowsService(): TeleshowsService {
        return TeleshowsServiceFactory.makeTeleshowsService(BuildConfig.DEBUG)
    }

    @Provides
    @ApplicationScope
    internal fun provideViewModelFactory(): ViewModelProvider.Factory {
        return ViewModelProvider.NewInstanceFactory()
    }

    @Provides
    @ApplicationScope
    internal fun provideTeleshowsDatabase(application: Application): TeleshowsDatabase {
        return Room.databaseBuilder(application.applicationContext,
                TeleshowsDatabase::class.java, TeleshowsDbConstants.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
    }
    @Provides
    @ApplicationScope
    fun provideDebugTree(): Timber.DebugTree = Timber.DebugTree()
}