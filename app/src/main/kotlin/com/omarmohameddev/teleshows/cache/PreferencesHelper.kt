package com.omarmohameddev.teleshows.cache

import android.content.Context
import android.content.SharedPreferences
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


/**
 * General Preferences Helper class, used for storing preference values using the Preference API
 */
@Singleton
open class PreferencesHelper @Inject constructor(context: Context) {

    companion object {
        private val PREF_TELESHOWS_PACKAGE_NAME = "com.omarmohameddev.teleshows.preferences"

        private val PREF_KEY_LAST_CACHE = "last_cache"
        private val PREF_KEY_TELESHOWS_API_KEY = "teleshows_api_key"
    }

    private val teleshowsPref: SharedPreferences
    private var contextInjected: Context

    init {
        contextInjected = context
        teleshowsPref = contextInjected.getSharedPreferences(PREF_TELESHOWS_PACKAGE_NAME, Context.MODE_PRIVATE)
    }

    /**
     * Store and retrieve the last time data was cached
     */
    var lastCacheTime: Long
        get() = teleshowsPref.getLong(PREF_KEY_LAST_CACHE, 0)
        set(lastCache) = teleshowsPref.edit().putLong(PREF_KEY_LAST_CACHE, lastCache).apply()

    var moviedbApiKey: String = ""
        get() = teleshowsPref.getString(PREF_KEY_TELESHOWS_API_KEY,
                retrieveApiKeyFromProperties(contextInjected, "moviedb_apikey"))

    private fun retrieveApiKeyFromProperties(context: Context, keyName: String): String? {
        val properties = Properties()
        val assetManager = context.assets
        val inputStream = assetManager.open("apikeys.properties")
        properties.load(inputStream)
        return properties.getProperty(keyName)
    }
}
