package com.miggle.miggle

import android.view.LayoutInflater
import android.view.ViewGroup
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentImg2Binding

class GuideSecondFragment :BaseFragment<FragmentImg2Binding>(){
    override fun initClickListener() {

    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentImg2Binding {
        return FragmentImg2Binding.inflate(inflater,container,false)
    }
}