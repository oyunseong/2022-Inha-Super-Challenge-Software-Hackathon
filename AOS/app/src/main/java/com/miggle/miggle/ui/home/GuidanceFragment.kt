package com.miggle.miggle.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentGuidanceBinding

class GuidanceFragment : BaseFragment<FragmentGuidanceBinding>() {
    override fun initClickListener() {

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.guidanceAppbar.appbarSearchButton.visibility = View.INVISIBLE
        binding.guidanceAppbar.appbarSettingButton.visibility = View.INVISIBLE
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGuidanceBinding {
        return FragmentGuidanceBinding.inflate(inflater,container,false)
    }
}