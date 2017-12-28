package com.omarmohameddev.teleshows.remote

import com.omarmohameddev.teleshows.data.repository.TeleshowsRemote
import com.omarmohameddev.teleshows.model.Teleshow
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Remote implementation for retrieving Teleshows instances. This class implements the
 * [TeleshowsRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class TeleshowsRemoteImpl @Inject constructor(private val teleshowsService: TeleshowsService):
        TeleshowsRemote {

    /**
     * Retrieve a list of [TeleshowsEntity] instances from the [TeleshowsService].
     */
    override fun getTeleshows(): Flowable<List<Teleshow>> {
        return teleshowsService.getTeleshows(
                "aed4610f733bbcee200e6185cb81a7f0",
                1,
                "en-US",
                "us"
        )
                .map { it.teleshows }
    }

}