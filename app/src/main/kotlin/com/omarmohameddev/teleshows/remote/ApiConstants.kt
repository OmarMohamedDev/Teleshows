package com.omarmohameddev.teleshows.remote

object ApiConstants {
    //Base url for the movie DB (Version 3)
    const val BASE_URL_V3 = "https://api.themoviedb.org/3/"

    //REST call timeout
    const val CONNECTION_TIMEOUT: Long = 120

    //Date format
    const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

    //Path parameters used in the app REST calls
    const val PATH_PARAMETER_MOVIE_ID = "movie_id"

    //Query keys used in the app REST calls
    const val QUERY_KEY_API_KEY = "api_key"
    const val QUERY_KEY_LANGUAGE = "language"
    const val QUERY_KEY_PAGE = "page"
    const val QUERY_KEY_REGION = "region"
}