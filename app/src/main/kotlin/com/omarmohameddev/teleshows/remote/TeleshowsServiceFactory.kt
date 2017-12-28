package com.omarmohameddev.teleshows.remote

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Provide "make" methods to create instances of [TeleshowsService]
 * and its related dependencies, such as OkHttpClient, Gson, etc.
 */
object TeleshowsServiceFactory {

    fun makeTeleshowsService(isDebug: Boolean): TeleshowsService {
        val okHttpClient = makeOkHttpClient(
                makeLoggingInterceptor(isDebug))

        return makeTeleshowsService(okHttpClient, makeGson())
    }

    private fun makeTeleshowsService(okHttpClient: OkHttpClient, gson: Gson): TeleshowsService {
        val retrofit = Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL_V3)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        return retrofit.create(TeleshowsService::class.java)
    }

    private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(ApiConstants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(ApiConstants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .build()
    }

    private fun makeGson(): Gson {
        return GsonBuilder()
                .setLenient()
                .setDateFormat(ApiConstants.DATE_FORMAT)
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
    }

    private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (isDebug)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return logging
    }

}