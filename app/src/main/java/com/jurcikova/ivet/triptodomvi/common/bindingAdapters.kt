package com.jurcikova.ivet.triptodomvi.common

import android.databinding.BindingAdapter
import android.graphics.drawable.PictureDrawable
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.jurcikova.ivet.triptodomvi.R

@BindingAdapter("show")
fun View.setShow(show: Boolean) {
    if (parent is ViewGroup)
        TransitionManager.beginDelayedTransition(parent as ViewGroup)
    visibility = if (show) View.VISIBLE else View.GONE
}

@Suppress("UNCHECKED_CAST")
@BindingAdapter("list")
fun <E> RecyclerView.setList(list: List<E>) {
    (adapter as ListAdapter<E, *>?)?.submitList(list)
}

@BindingAdapter("svg")
fun ImageView.setSvgResource(url: String) {
    GlideApp.with(context)
            .`as`(PictureDrawable::class.java)
            .listener(SvgSoftwareLayerSetter())
            .placeholder(R.drawable.world)
            .error(R.drawable.world)
            .load(url)
            .into(this)
}