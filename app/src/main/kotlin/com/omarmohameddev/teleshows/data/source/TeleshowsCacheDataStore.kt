package com.omarmohameddev.teleshows.data.source

import com.omarmohameddev.teleshows.data.repository.TeleshowsCache
import com.omarmohameddev.teleshows.data.repository.TeleshowsDataStore
import com.omarmohameddev.teleshows.domain.model.Teleshow
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Implementation of the [TeleshowsDataStore] interface to provide a means of communicating
 * with the local data source
 */
open class TeleshowsCacheDataStore @Inject constructor(private val teleshowsCache: TeleshowsCache) :
        TeleshowsDataStore {

    /**
     * Clear all Teleshows from the cache
     */
    override fun clearTeleshows(): Completable {
        return teleshowsCache.clearTeleshows()
    }

    /**
     * Save a given [List] of [Teleshow] instances to the cache
     */
    override fun saveTeleshows(teleshows: List<Teleshow>): Completable {
        return teleshowsCache.saveTeleshows(teleshows)
                .doOnComplete {
                    teleshowsCache.setLastCacheTime(System.currentTimeMillis())
                }
    }

    /**
     * Retrieve a list of [Teleshow] instance from the cache
     */
    override fun getTeleshows(): Flowable<List<Teleshow>> {
        return teleshowsCache.getTeleshows()
    }

    /**
     * Retrieve a list of [Teleshow] instance from the cache
     */
    override fun isCached(): Single<Boolean> {
        return teleshowsCache.isCached()
    }

}