package com.omarmohameddev.teleshows.data.repository

import com.omarmohameddev.teleshows.model.Teleshow
import io.reactivex.Flowable


/**
 * Interface defining methods for retrieving the Teleshows remotely. This is to be implemented by the
 * remote layer, using this interface as a way of communicating.
 */
interface TeleshowsRemote {

    /**
     * Retrieve a list of Teleshows, from the cache
     */
    fun getTeleshows(): Flowable<List<Teleshow>>

    fun getApiKey(): String

    fun getPage(): Int

    fun getLanguage(): String

    fun getRegion(): String
}