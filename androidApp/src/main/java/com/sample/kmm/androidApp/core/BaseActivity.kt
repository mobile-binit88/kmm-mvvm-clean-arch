package com.sample.kmm.androidApp.core


import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.sample.kmm.androidApp.R
import com.sample.kmm.androidApp.uicomponent.toolbar.ToolBarHost
import com.sample.kmm.shared.viewmodel.BaseViewModel


abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity(), ToolBarHost {

    lateinit var viewModel: VM
    lateinit var progressBar: ProgressBar

    lateinit var progressAlertDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpToolBar(this)
        progressAlertDialog =
            getAlertDialog(this, R.layout.progress_layout, setCancellationOnTouchOutside = false)
    }

    open fun showProgressBar() {
        if (progressAlertDialog.isShowing == false) {
            progressAlertDialog.show()
        }
    }

    open fun hideProgressBar() {
        if (progressAlertDialog.isShowing == true) {
            progressAlertDialog.hide()
        }
    }


    fun getAlertDialog(
        context: Context, layout: Int, setCancellationOnTouchOutside: Boolean
    ): AlertDialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        val customLayout: View = layoutInflater.inflate(layout, null)
        builder.setView(customLayout)
        val dialog = builder.create()
        dialog.setCanceledOnTouchOutside(setCancellationOnTouchOutside)
        return dialog
    }
}