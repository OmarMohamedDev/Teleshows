package com.omarmohameddev.teleshows.data.repository

import com.omarmohameddev.teleshows.model.Teleshow
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Interface defining methods for the caching of Teleshows. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface TeleshowsCache {

    /**
     * Clear all Teleshows from the cache.
     */
    fun clearTeleshows(): Completable

    /**
     * Save a given list of Teleshows to the cache.
     */
    fun saveTeleshows(teleshows: List<Teleshow>): Completable

    /**
     * Retrieve a list of Teleshows, from the cache.
     */
    fun getTeleshows(): Flowable<List<Teleshow>>

    /**
     * Check whether there is a list of Teleshow stored in the cache.
     *
     * @return true if the list is cached, otherwise false
     */
    fun isCached(): Single<Boolean>

    /**
     * Set a point in time at when the cache was last updated.
     *
     * @param lastCache the point in time at when the cache was last updated
     */
    fun setLastCacheTime(lastCache: Long)

    /**
     * Check if the cache is expired.
     *
     * @return true if the cache is expired, otherwise false
     */
    fun isExpired(): Boolean

}