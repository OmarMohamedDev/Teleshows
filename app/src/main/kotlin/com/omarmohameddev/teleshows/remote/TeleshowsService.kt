package com.omarmohameddev.teleshows.remote

import com.omarmohameddev.teleshows.model.Teleshow
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Defines the abstract methods used for interacting with the Teleshows API
 */
interface TeleshowsService {

    @GET("movie/top_rated")
    fun getTeleshows(): Flowable<TeleshowsResponse>

    class TeleshowsResponse {
        lateinit var teleshows: List<Teleshow>
    }

}