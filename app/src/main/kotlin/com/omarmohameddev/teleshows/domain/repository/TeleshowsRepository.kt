package com.omarmohameddev.teleshows.domain.repository

import com.omarmohameddev.teleshows.domain.model.Teleshow
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Interface defining methods for how the data layer can pass data to and from the Domain layer.
 * This is to be implemented by the data layer, setting the requirements for the
 * operations that need to be implemented
 */
interface TeleshowsRepository {

    fun clearTeleshows(): Completable

    fun saveTeleshows(teleshows: List<Teleshow>): Completable

    fun getTeleshows(): Flowable<List<Teleshow>>

}