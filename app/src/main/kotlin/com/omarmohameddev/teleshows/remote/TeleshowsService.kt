package com.omarmohameddev.teleshows.remote

import com.google.gson.annotations.SerializedName
import com.omarmohameddev.teleshows.model.Teleshow
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Defines the abstract methods used for interacting with the Teleshows API
 */
interface TeleshowsService {

    @GET("movie/top_rated")
    fun getTeleshows(
            @Query(ApiConstants.QUERY_KEY_API_KEY) apiKey: String,
            @Query(ApiConstants.QUERY_KEY_PAGE) page: Int,
            @Query(ApiConstants.QUERY_KEY_LANGUAGE) language: String,
            @Query(ApiConstants.QUERY_KEY_REGION) region: String
    ): Flowable<TeleshowsResponse>

    class TeleshowsResponse {
        @SerializedName("page")
        var page: Int = -1
        @SerializedName("total_pages")
        var totalPages: Int = -1
        @SerializedName("total_results")
        var totalResults: Int = -1
        @SerializedName("results")
        lateinit var teleshows: List<Teleshow>
    }
}