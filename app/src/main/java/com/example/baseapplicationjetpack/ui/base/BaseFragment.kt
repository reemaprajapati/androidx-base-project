package com.example.baseapplicationjetpack.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment

abstract class BaseFragment<T : ViewDataBinding> : DaggerFragment() {
    abstract fun getLayout(): Int
    protected lateinit var binding: T
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View
        if (isDataBindingEnabled()) {
            binding = DataBindingUtil.inflate(inflater, getLayout(), container, false)
            view = binding.root
        } else {
            view = inflater.inflate(getLayout(), container, false)
        }
        setHasOptionsMenu(true)
        return view
    }

    open fun isDataBindingEnabled(): Boolean = false
}