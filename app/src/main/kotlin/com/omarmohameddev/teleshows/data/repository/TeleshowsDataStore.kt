package com.omarmohameddev.teleshows.data.repository

import com.omarmohameddev.teleshows.model.Teleshow
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Interface defining methods for the data operations related to Teleshows.
 * This is to be implemented by external data source layers, setting the requirements for the
 * operations that need to be implemented
 */
interface TeleshowsDataStore {

    fun clearTeleshows(): Completable

    fun saveTeleshows(teleshows: List<Teleshow>): Completable

    fun getTeleshows(): Flowable<List<Teleshow>>

    fun isCached(): Single<Boolean>

}