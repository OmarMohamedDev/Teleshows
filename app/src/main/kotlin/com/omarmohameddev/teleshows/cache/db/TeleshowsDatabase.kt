package com.omarmohameddev.teleshows.cache.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.omarmohameddev.teleshows.cache.dao.TeleshowDao
import com.omarmohameddev.teleshows.model.Teleshow
import javax.inject.Inject

@Database(entities = arrayOf(Teleshow::class), version = 1)
abstract class TeleshowsDatabase @Inject constructor() : RoomDatabase() {

    abstract fun teleshowDao(): TeleshowDao

    private var INSTANCE: TeleshowsDatabase? = null

    private val sLock = Any()

    fun getInstance(context: Context): TeleshowsDatabase {
        if (INSTANCE == null) {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            TeleshowsDatabase::class.java, TeleshowsDbConstants.DATABASE_NAME)
                            .build()
                }
                return INSTANCE!!
            }
        }
        return INSTANCE!!
    }

}