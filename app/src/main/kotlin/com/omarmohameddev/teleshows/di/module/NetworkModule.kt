package com.omarmohameddev.teleshows.di.module

import android.content.Context
import android.net.ConnectivityManager
import com.omarmohameddev.teleshows.data.network.NetworkInteractor
import com.omarmohameddev.teleshows.data.network.NetworkInteractorImpl
import com.omarmohameddev.teleshows.di.qualifier.ApplicationQualifier
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideConnectivityManager(@ApplicationQualifier context: Context): ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    @Provides @Singleton
    fun provideNetworkInteractor(networkInteractorImpl: NetworkInteractorImpl): NetworkInteractor = networkInteractorImpl
}