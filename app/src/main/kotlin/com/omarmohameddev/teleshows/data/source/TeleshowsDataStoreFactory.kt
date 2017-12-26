package com.omarmohameddev.teleshows.data.source

import com.omarmohameddev.teleshows.data.repository.TeleshowsCache
import com.omarmohameddev.teleshows.data.repository.TeleshowsDataStore
import javax.inject.Inject

/**
 * Create an instance of a TeleshowsDataStore
 */
open class TeleshowsDataStoreFactory @Inject constructor(
        private val teleshowsCache: TeleshowsCache,
        private val teleshowsCacheDataStore: TeleshowsCacheDataStore,
        private val teleshowsRemoteDataStore: TeleshowsRemoteDataStore) {

    /**
     * Returns a DataStore based on whether or not there is content in the cache and the cache
     * has not expired
     */
    open fun retrieveDataStore(isCached: Boolean): TeleshowsDataStore {
        if (isCached && !teleshowsCache.isExpired()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }

    /**
     * Return an instance of the Cache Data Store
     */
    open fun retrieveCacheDataStore(): TeleshowsDataStore {
        return teleshowsCacheDataStore
    }

    /**
     * Return an instance of the Remote Data Store
     */
    open fun retrieveRemoteDataStore(): TeleshowsDataStore {
        return teleshowsRemoteDataStore
    }

}