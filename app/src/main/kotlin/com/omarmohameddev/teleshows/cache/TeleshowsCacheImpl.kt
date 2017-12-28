package com.omarmohameddev.teleshows.cache

import android.annotation.SuppressLint
import com.omarmohameddev.teleshows.cache.db.TeleshowsDatabase
import com.omarmohameddev.teleshows.data.repository.TeleshowsCache
import com.omarmohameddev.teleshows.model.Teleshow
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Cached implementation for retrieving and saving Teleshows instances. This class implements the
 * [TeleshowsCache] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class TeleshowsCacheImpl @Inject constructor(val teleshowsDatabase: TeleshowsDatabase,
                                            private val preferencesHelper: PreferencesHelper):
        TeleshowsCache {

    private val EXPIRATION_TIME = (60 * 10 * 1000).toLong()

    /**
     * Retrieve an instance from the database, used for tests
     */
    internal fun getDatabase(): TeleshowsDatabase {
        return teleshowsDatabase
    }

    /**
     * Remove all the data from all the tables in the database.
     */
    @SuppressLint("CheckResult")
    override fun clearTeleshows(): Completable {
        return Completable.defer {
            teleshowsDatabase.cachedTeleshowDao().clearTeleshows()
            Completable.complete()
        }
    }

    /**
     * Save the given list of [Teleshow] instances to the database.
     */
    @SuppressLint("CheckResult")
    override fun saveTeleshows(teleshows: List<Teleshow>): Completable {
        return Completable.defer {
            teleshows.forEach {
                teleshowsDatabase.cachedTeleshowDao().insertTeleshows(it)
            }
            Completable.complete()
        }
    }

    /**
     * Retrieve a list of [Teleshow] instances from the database.
     */
    @SuppressLint("CheckResult")
    override fun getTeleshows(): Flowable<List<Teleshow>> {
        return Flowable.defer {
            Flowable.just(teleshowsDatabase.cachedTeleshowDao().getTeleshows()) }
                .map{ it.map { it }
        }
    }

    /**
     * Checked whether there are instances of [Teleshow] stored in the cache
     */
    override fun isCached(): Single<Boolean> {
        return Single.defer {
            Single.just(teleshowsDatabase.cachedTeleshowDao().getTeleshows().isNotEmpty())
        }
    }

    /**
     * Set a point in time at when the cache was last updated
     */
    override fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTime = lastCache
    }

    /**
     * Check whether the current cached data exceeds the defined [EXPIRATION_TIME] time
     */
    override fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = this.getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
    private fun getLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTime
    }

}