package com.sample.kmm.androidApp.uicomponent.toolbar

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.sample.kmm.androidApp.R

interface ToolBarHost {

//    var aapkaInteriorToolbar: AapkaInteriorToolbar

    fun setUpToolBar(activity: AppCompatActivity) {
        activity.supportActionBar?.let { _actionBar ->
            if (!_actionBar.isShowing) {
                _actionBar.show()
            }
            _actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            _actionBar.setDisplayShowCustomEnabled(true)
            _actionBar.setCustomView(R.layout.main_toolbar)
            _actionBar.customView?.let { view ->
                val toolbar = view.parent as? Toolbar
                toolbar?.setContentInsetsAbsolute(0, 0)
                val aapkaInteriorToolbar = AapkaInteriorToolbar()
                aapkaInteriorToolbar.drawCustomToolBar(
                    context = activity,
                    toolBarView = view,
                    toolBarModel = getToolBarData()
                )
            }
        }
    }


    fun getToolBarData(): ToolBarModel = ToolBarModel(
        titleResId = R.string.app_name,
        toolBarColorType = ToolBarModel.ToolBarColorType.LIGHT
    )
}