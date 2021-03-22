package com.bbl.common.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * base class of view holder used with this adapter
 *
 * @param <M> the model type
 * @param <C> the callback type
</C></M> */
abstract class SimpleViewHolder<M, C>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun getItemView(): View {
        return itemView
    }

    abstract fun bind(model: M, callback: C)
    protected fun getString(stringResId: Int): String {
        return itemView.getContext().getString(stringResId)
    }

    protected fun getString(stringResId: Int, vararg params: Any?): String {
        return itemView.getContext().getString(stringResId, *params)
    }

    init {
        itemView.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View) {
                //no op
            }

            override fun onViewDetachedFromWindow(v: View) {
                //no op
            }
        })
    }
}