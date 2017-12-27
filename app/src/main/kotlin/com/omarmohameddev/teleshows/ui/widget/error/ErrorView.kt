package com.omarmohameddev.teleshows.ui.widget.error

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.omarmohameddev.teleshows.R
import kotlinx.android.synthetic.main.list_error_view.view.*

/**
 * Widget used to display an empty state to the user
 */
class ErrorView : RelativeLayout {

    var errorListener: ErrorListener? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        LayoutInflater.from(context).inflate(R.layout.list_error_view, this)
        button_try_again.setOnClickListener { errorListener?.onTryAgainClicked() }
    }

}