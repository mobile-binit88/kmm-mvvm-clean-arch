package com.sample.kmm.androidApp.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sample.kmm.androidApp.uicomponent.toolbar.ToolBarHost
import com.sample.kmm.shared.viewmodel.BaseViewModel

abstract class BaseFragment<VM : BaseViewModel> : Fragment(), ToolBarHost {
    lateinit var viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolBar(activity as AppCompatActivity)
    }

    open fun showProgressBar() {
        (activity as? BaseActivity<*>)?.showProgressBar()
    }

    open fun hideProgressBar() {
        (activity as? BaseActivity<*>)?.hideProgressBar()
    }

}