package com.omarmohameddev.teleshows.data.network

import io.reactivex.Completable

/**
 * Interface that defines the method that should be implemented by our Network Interactor
 * to handle network requests
 */
interface NetworkInteractor {

    fun hasNetworkConnection(): Boolean

    fun hasNetworkConnectionCompletable(): Completable

    class NetworkUnavailableException : Throwable("No network available!")
}