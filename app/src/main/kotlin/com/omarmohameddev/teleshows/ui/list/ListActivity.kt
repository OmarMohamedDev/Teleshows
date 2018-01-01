package com.omarmohameddev.teleshows.ui.list

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.omarmohameddev.teleshows.R
import com.omarmohameddev.teleshows.model.Teleshow
import com.omarmohameddev.teleshows.presentation.data.Resource
import com.omarmohameddev.teleshows.presentation.data.ResourceState
import com.omarmohameddev.teleshows.presentation.list.ListTeleshowsViewModel
import com.omarmohameddev.teleshows.ui.widget.empty.EmptyListener
import com.omarmohameddev.teleshows.ui.widget.error.ErrorListener
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_list.*
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class ListActivity: AppCompatActivity() {

    @Inject lateinit var listAdapter: ListAdapter
    @Inject lateinit var listTeleshowsViewModel: ListTeleshowsViewModel
    private val LIST_COLUMNS = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        AndroidInjection.inject(this)
        setupListRecyclerView()
        setupViewListeners()
    }

    override fun onStart() {
        super.onStart()
        listTeleshowsViewModel.getTeleshows().observe(this,
                Observer<Resource<List<Teleshow>>> {
                    if (it != null) this.handleDataState(it.status, it.data, it.message) })
    }

    private fun setupListRecyclerView() {
        list_recyclerview.layoutManager = GridLayoutManager(this, LIST_COLUMNS)
        list_recyclerview.adapter = listAdapter
    }

    private fun handleDataState(resourceState: ResourceState, data: List<Teleshow>?,
                                message: String?) {
        when (resourceState) {
            ResourceState.LOADING -> setupScreenForLoadingState()
            ResourceState.SUCCESS -> setupScreenForSuccess(data)
            ResourceState.ERROR -> setupScreenForError(message)
        }
    }

    private fun setupScreenForLoadingState() {
        list_progress.visibility = View.VISIBLE
        list_recyclerview.visibility = View.GONE
        list_empty_view.visibility = View.GONE
        list_error_view.visibility = View.GONE
    }

    private fun setupScreenForSuccess(data: List<Teleshow>?) {
        list_error_view.visibility = View.GONE
        list_progress.visibility = View.GONE
        if (data!= null && data.isNotEmpty()) {
            updateListView(data)
            list_recyclerview.visibility = View.VISIBLE
        } else {
            list_empty_view.visibility = View.VISIBLE
        }
    }

    private fun updateListView(teleshows: List<Teleshow>) {
        listAdapter.teleshows.addAll(teleshows)
        listAdapter.notifyDataSetChanged()
    }

    private fun setupScreenForError(message: String?) {
        list_progress.visibility = View.GONE
        list_recyclerview.visibility = View.GONE
        list_empty_view.visibility = View.GONE
        list_error_view.visibility = View.VISIBLE
    }

    private fun setupViewListeners() {
        list_empty_view.emptyListener = emptyListener
        list_error_view.errorListener = errorListener
        list_recyclerview.addOnScrollListener(scrollListener)
    }

    private val emptyListener = object : EmptyListener {
        override fun onCheckAgainClicked() {
            listTeleshowsViewModel.fetchTeleshows(false)
        }
    }

    private val errorListener = object : ErrorListener {
        override fun onTryAgainClicked() {
            listTeleshowsViewModel.fetchTeleshows(false)
        }
    }

    private val scrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            var loadMore = true

            if (dy > 0) { //Check for scrolldown
                val visibleItemCount = list_recyclerview.layoutManager.childCount
                val totalItemCount = list_recyclerview.layoutManager.itemCount
                val pastVisibleItems = (list_recyclerview.layoutManager as GridLayoutManager)
                        .findFirstVisibleItemPosition()

                if (loadMore) {
                    if ((visibleItemCount + pastVisibleItems) >=  totalItemCount) {
                        loadMore = false
                        Timber.e("Last Item reached")
                        listTeleshowsViewModel.fetchTeleshows(true)
                    }
                }
            }
        }
    }
}