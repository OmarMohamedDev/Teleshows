package com.omarmohameddev.teleshows.ui.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.omarmohameddev.teleshows.R
import com.omarmohameddev.teleshows.model.Teleshow
import com.omarmohameddev.teleshows.remote.ApiConstants
import javax.inject.Inject

class ListAdapter @Inject constructor(): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    var teleshows: MutableList<Teleshow> = arrayListOf()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val teleshow = teleshows[position]
        holder.title.text = teleshow.title
        holder.voteAverage.text = teleshow.voteAverage.toString()

        Glide.with(holder.itemView.context)
                .load(ApiConstants.BASE_URL_IMAGES+teleshow.posterPath)
                .into(holder.poster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_item_teleshow, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return teleshows.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var poster: ImageView
        var title: TextView
        var voteAverage: TextView

        init {
            poster = view.findViewById(R.id.list_item_poster)
            title = view.findViewById(R.id.list_item_title)
            voteAverage = view.findViewById(R.id.list_item_vote_average)
        }
    }

}
