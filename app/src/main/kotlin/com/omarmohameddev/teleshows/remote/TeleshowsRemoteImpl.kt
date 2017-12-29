package com.omarmohameddev.teleshows.remote

import android.content.Context
import com.omarmohameddev.teleshows.cache.PreferencesHelper
import com.omarmohameddev.teleshows.data.repository.TeleshowsRemote
import com.omarmohameddev.teleshows.model.Teleshow
import io.reactivex.Flowable
import java.util.*
import javax.inject.Inject

/**
 * Remote implementation for retrieving Teleshows instances. This class implements the
 * [TeleshowsRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class TeleshowsRemoteImpl @Inject constructor(private val teleshowsService: TeleshowsService,
                                              private val context: Context):
        TeleshowsRemote {

    /**
     * Current page
     */
    private var page = 1

    /**
     * Retrieve a list of [Teleshows] instances from the [TeleshowsService].
     */
    override fun getTeleshows(loadMore: Boolean): Flowable<List<Teleshow>> {
        if (loadMore) page++

        return teleshowsService.getTeleshows(
                getApiKey(),
                page,
                getLanguage(),
                getRegion()
        ).map { it.teleshows }
    }

    override fun getApiKey(): String {
        return PreferencesHelper(context)
                .moviedbApiKey
    }

    override fun getLanguage(): String {
        return Locale.getDefault().displayLanguage
    }

    override fun getRegion(): String {
        return Locale.getDefault().displayCountry
    }

}