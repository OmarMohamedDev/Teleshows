package com.omarmohameddev.teleshows.cache.db

/**
 * Defines constants for the Teleshows Table
 */
object TeleshowsDbConstants {

    const val DATABASE_NAME = "teleshows.db"

    const val TABLE_NAME = "teleshows"

    const val QUERY_TELESHOWS = "SELECT * FROM" + " " + TABLE_NAME

    const val DELETE_ALL_TELESHOWS = "DELETE FROM" + " " + TABLE_NAME

}