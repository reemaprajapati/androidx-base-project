package com.example.baseapplicationjetpack.ui.fragments

import android.os.Bundle
import com.example.baseapplicationjetpack.R
import com.example.baseapplicationjetpack.databinding.FragmentHomeBinding
import com.example.baseapplicationjetpack.ui.base.BaseFragment

class HomeFragment: BaseFragment<FragmentHomeBinding>() {
    override fun getLayout() = R.layout.fragment_home
    override fun isDataBindingEnabled(): Boolean  = true
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}