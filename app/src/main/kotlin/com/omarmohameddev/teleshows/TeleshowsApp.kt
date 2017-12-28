package com.omarmohameddev.teleshows

import android.app.Activity
import android.app.Application
import com.omarmohameddev.teleshows.di.component.DaggerAppComponent
import com.omarmohameddev.teleshows.di.module.AppModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject
import com.akaita.java.rxjava2debug.RxJava2Debug



class TeleshowsApp : Application(), HasActivityInjector {

    @Inject lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
        setupTimber()
        setupRxJava2Debug()

    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun setupRxJava2Debug() {
        // Enable RxJava assembly stack collection, to make RxJava crash reports clear and unique
        // Make sure this is called AFTER setting up any Crash reporting mechanism as Crashlytics
        RxJava2Debug
                .enableRxJava2AssemblyTracking(
                        arrayOf("com.omarmohameddev.teleshows"))
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}