package com.sample.kmm.androidApp.view.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bbl.common.recycler.SimpleRecyclerViewAdapter
import com.bbl.common.recycler.SimpleViewHolder
import com.sample.kmm.androidApp.R
import com.sample.kmm.shared.model.response.CategoryResponse

class CategoryViewHolder(itemView: View) :
    SimpleViewHolder<CategoryResponse, CategoryViewHolder.CallBack>(itemView) {

    private var textView: TextView = itemView.findViewById(R.id.item_search)


    interface CallBack {
        fun onItemClick(category: CategoryResponse, position: Int)
    }

    class CategoryItemFactory :
        SimpleRecyclerViewAdapter.SimpleViewHolderFactory<CategoryViewHolder> {
        override fun getViewHolder(parent: ViewGroup?, viewType: Int): CategoryViewHolder {
            return CategoryViewHolder(
                LayoutInflater.from(parent?.context)
                    .inflate(R.layout.item_category, parent, false)
            )
        }

    }

    override fun bind(model: CategoryResponse, callback: CallBack) {
        textView.text = model?.category?.name

        itemView.setOnClickListener {
            callback.onItemClick(model, adapterPosition)
        }
    }
}