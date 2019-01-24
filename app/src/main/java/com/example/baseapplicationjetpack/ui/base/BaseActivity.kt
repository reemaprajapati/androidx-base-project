package com.example.baseapplicationjetpack.ui.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {
    protected lateinit var binding: ViewDataBinding
    abstract fun getLayout(): Int
    open fun isDataBindingEnabled(): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isDataBindingEnabled()) {
            setContentView(getLayout())
        } else {
            binding = DataBindingUtil.setContentView(this, getLayout())
        }
    }
}