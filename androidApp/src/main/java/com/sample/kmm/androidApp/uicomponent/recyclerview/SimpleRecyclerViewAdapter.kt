package com.bbl.common.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

/**
 * Simple view adapter for recycler view that uses a single ViewHolder
 * type to do the bindings  and a single factory to create them
 *
 * @param <M> the model the adapter will adapt .
 * @param <C> the callback type used by the adapter
 * @param <V> the view holder used by the adapter.
</V></C></M> */
open class SimpleRecyclerViewAdapter<M, C, V : SimpleViewHolder<M, C>?> : RecyclerView.Adapter<V>() {
    protected var model: MutableList<M> = ArrayList()
    private var viewHolderFactory: SimpleViewHolderFactory<V>? = null
    private var callback: C? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): V {
        return viewHolderFactory!!.getViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: V, position: Int) {
        holder?.bind(getItem(position), callback!!)
    }

    override fun getItemCount(): Int {
        return model.size
    }

    fun getItem(position: Int): M {
        return model[position]
    }

    fun setViewHolderFactory(viewHolderFactory: SimpleViewHolderFactory<V>?) {
        this.viewHolderFactory = viewHolderFactory
    }

    fun setCallback(callback: C) {
        this.callback = callback
    }

    fun update(modelItem: M) {
        val index = model.indexOf(modelItem)
        if (index >= 0) {
            model[index] = modelItem
            notifyItemChanged(index)
        }
    }

    fun setModel(model: Collection<M>) {
        this.model.clear()
        this.model.addAll(model)
        notifyDataSetChanged()
    }

    fun remove(modelItem: M) {
        val index = model.indexOf(modelItem)
        if (index >= 0) {
            model.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    /**
     * Interface of factory used to create the appropriate view holder
     *
     * @param <V>
    </V> */
    interface SimpleViewHolderFactory<V> {
        fun getViewHolder(parent: ViewGroup?, viewType: Int): V
    }
}