package com.omarmohameddev.teleshows.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.omarmohameddev.teleshows.cache.db.TeleshowsDbConstants

/**
 * Representation for a [Teleshow]
 */

@Entity(tableName = TeleshowsDbConstants.TABLE_NAME)
data class Teleshow(
        @PrimaryKey
        @SerializedName("id")
        val id: Long,
        @SerializedName("title")
        val title: String,
        @SerializedName("overview")
        val overview: String,
        @SerializedName("vote_average")
        val voteAverage: Float,
        @SerializedName("poster_path")
        val posterPath: String)
