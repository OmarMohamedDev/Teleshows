package com.omarmohameddev.teleshows.data.repository

import com.omarmohameddev.teleshows.model.Teleshow
import io.reactivex.Flowable


/**
 * Interface defining methods for the caching of Teleshows. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface TeleshowsRemote {

    /**
     * Retrieve a list of Teleshows, from the cache
     */
    fun getTeleshows(): Flowable<List<Teleshow>>
}