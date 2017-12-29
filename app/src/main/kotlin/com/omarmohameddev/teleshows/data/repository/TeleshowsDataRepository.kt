package com.omarmohameddev.teleshows.data.repository

import android.annotation.SuppressLint
import android.util.Log
import com.omarmohameddev.teleshows.data.source.TeleshowsDataStoreFactory
import com.omarmohameddev.teleshows.model.Teleshow
import com.omarmohameddev.teleshows.domain.repository.TeleshowsRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import timber.log.Timber
import javax.inject.Inject

/**
 * Provides an implementation of the [Teleshows] interface for communicating to and from
 * data sources
 */
class TeleshowsDataRepository @Inject constructor(private val factory: TeleshowsDataStoreFactory):
        TeleshowsRepository {

    private val TAG = TeleshowsDataRepository::class.java.simpleName

    override fun clearTeleshows(): Completable {
        return factory.retrieveCacheDataStore().clearTeleshows()
    }

    override fun saveTeleshows(teleshows: List<Teleshow>): Completable {
        return factory.retrieveCacheDataStore().saveTeleshows(teleshows)
    }

    override fun getTeleshows(loadMore: Boolean): Flowable<List<Teleshow>> {
        return factory.retrieveCacheDataStore().isCached()
                    .flatMapPublisher {
                            factory.retrieveDataStore(false).getTeleshows(true)
                        }.doOnError { t: Throwable? -> Timber.e(TAG, t?.message) }
                    .flatMap {
                            saveTeleshows(it).toSingle { it }.toFlowable()
                        }
    }

}