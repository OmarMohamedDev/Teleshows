package com.omarmohameddev.teleshows.cache.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.omarmohameddev.teleshows.cache.db.TeleshowsDbConstants
import com.omarmohameddev.teleshows.model.Teleshow

@Dao
abstract class TeleshowDao {

    @Query(TeleshowsDbConstants.QUERY_TELESHOWS)
    abstract fun getTeleshows(): List<Teleshow>

    @Query(TeleshowsDbConstants.DELETE_ALL_TELESHOWS)
    abstract fun clearTeleshows()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertTeleshows(teleshow: Teleshow)

}