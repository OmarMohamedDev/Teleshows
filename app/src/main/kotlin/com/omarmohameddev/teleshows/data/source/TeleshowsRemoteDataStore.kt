package com.omarmohameddev.teleshows.data.source

import com.omarmohameddev.teleshows.data.repository.TeleshowsDataStore
import com.omarmohameddev.teleshows.data.repository.TeleshowsRemote
import com.omarmohameddev.teleshows.model.Teleshow
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject


/**
 * Implementation of the [TeleshowsDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class TeleshowsRemoteDataStore @Inject constructor(private val teleshowsRemote: TeleshowsRemote) :
        TeleshowsDataStore {

    override fun clearTeleshows(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveTeleshows(teleshows: List<Teleshow>): Completable {
        throw UnsupportedOperationException()
    }

    /**
     * Retrieve a list of [TeleshowEntity] instances from the API
     */
    override fun getTeleshows(): Flowable<List<Teleshow>> {
        return teleshowsRemote.getTeleshows()
    }

    override fun isCached(): Single<Boolean> {
        throw UnsupportedOperationException()
    }

}
