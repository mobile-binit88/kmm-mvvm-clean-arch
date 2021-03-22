package com.sample.kmm.androidApp.uicomponent.toolbar

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.sample.kmm.androidApp.R

class AapkaInteriorToolbar() {

    fun drawCustomToolBar(context: Context, toolBarView: View, toolBarModel: ToolBarModel?) {
        designBackGround(context, toolBarView, toolBarModel)
        designTextColor(context, toolBarView, toolBarModel)
        designLeftActionText(context, toolBarView, toolBarModel)
        designRightActionText(context, toolBarView, toolBarModel)
        designLeftActionImage(context, toolBarView, toolBarModel)
        designRightActionImage(context, toolBarView, toolBarModel)

    }

    private fun designBackGround(context: Context, toolBarView: View, toolBarModel: ToolBarModel?) {
        if (toolBarModel?.toolBarColorType == ToolBarModel.ToolBarColorType.LIGHT) {
            val toolbar = toolBarView.findViewById<Toolbar>(R.id.main_toolbar)
            toolbar?.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.colorWhite
                )
            )
        }
    }


    private fun designTextColor(context: Context, toolBarView: View, toolBarModel: ToolBarModel?) {
        if (toolBarModel?.toolBarColorType == ToolBarModel.ToolBarColorType.LIGHT) {
            toolBarModel.titleResId?.let {
                val screenName = toolBarView.findViewById<TextView>(R.id.txt_screen_name)
                screenName?.text = context.getText(it)
            }
        }
    }

    private fun designLeftActionText(
        context: Context,
        toolBarView: View,
        toolBarModel: ToolBarModel?
    ) {
        val resId = toolBarModel?.leftAction?.actionResId ?: null
        val stringResId = toolBarModel?.leftAction?.stringResId ?: null
        if (resId == null || stringResId == null)
            return

        val textView = toolBarView.findViewById<TextView>(resId)
        textView.visibility = View.VISIBLE
        textView.text = context.getString(stringResId)

        textView?.setOnClickListener {
            toolBarModel?.leftAction?.callBack?.invoke()
        }

    }

    private fun designRightActionText(
        context: Context,
        toolBarView: View,
        toolBarModel: ToolBarModel?
    ) {
        val resId = toolBarModel?.rightAction?.actionResId ?: null
        val stringResId = toolBarModel?.rightAction?.stringResId ?: null
        if (resId == null || stringResId == null)
            return

        val textView = toolBarView.findViewById<TextView>(resId)
        textView.visibility = View.VISIBLE
        textView.text = context.getString(stringResId)

        textView?.setOnClickListener {
            toolBarModel?.rightAction?.callBack?.invoke()
        }

    }


    private fun designLeftActionImage(
        context: Context,
        toolBarView: View,
        toolBarModel: ToolBarModel?
    ) {
        val resId = toolBarModel?.leftActionImage?.actionResId ?: null
        val drawableResId = toolBarModel?.leftActionImage?.drawableResId ?: null
        if (resId == null || drawableResId == null)
            return

        val imageView = toolBarView.findViewById<ImageView>(resId)
        imageView.visibility = View.VISIBLE
        imageView.setImageDrawable(context.getDrawable(drawableResId))

        imageView?.setOnClickListener {
            toolBarModel?.leftActionImage?.callBack?.invoke()
        }

    }


    private fun designRightActionImage(
        context: Context,
        toolBarView: View,
        toolBarModel: ToolBarModel?
    ) {
        val resId = toolBarModel?.rightActionImage?.actionResId ?: null
        val drawableResId = toolBarModel?.rightActionImage?.drawableResId ?: null
        if (resId == null || drawableResId == null)
            return

        val imageView = toolBarView.findViewById<ImageView>(resId)
        imageView.visibility = View.VISIBLE
        imageView.setImageDrawable(context.getDrawable(drawableResId))

        imageView?.setOnClickListener {
            toolBarModel?.rightActionImage?.callBack?.invoke()
        }

    }
}
