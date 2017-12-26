package com.omarmohameddev.teleshows.domain.model

/**
 * Representation for a [Teleshow] fetched from an external layer data source
 */
data class Teleshow(val id: Long,
                    val title: String,
                    val overview: String,
                    val voteAverage: Int,
                    val posterPath: String)
