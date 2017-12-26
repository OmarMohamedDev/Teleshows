package com.omarmohameddev.teleshows.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.omarmohameddev.teleshows.cache.db.TeleshowsDbConstants

/**
 * Representation for a [Teleshow]
 */

@Entity(tableName = TeleshowsDbConstants.TABLE_NAME)
data class Teleshow(
        @PrimaryKey val id: Long,
        val title: String,
        val overview: String,
        val voteAverage: Int,
        val posterPath: String)
