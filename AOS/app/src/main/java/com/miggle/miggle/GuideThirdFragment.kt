package com.miggle.miggle

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentImg3Binding

class GuideThirdFragment :BaseFragment<FragmentImg3Binding>(){
    override fun initClickListener() {
        binding.img3.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentImg3Binding {
        return FragmentImg3Binding.inflate(inflater,container,false)
    }
}