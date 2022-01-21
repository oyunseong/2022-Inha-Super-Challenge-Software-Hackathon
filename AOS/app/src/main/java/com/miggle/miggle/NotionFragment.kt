package com.miggle.miggle

import android.view.LayoutInflater
import android.view.ViewGroup
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentNotionBinding

class NotionFragment : BaseFragment<FragmentNotionBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotionBinding {
        return FragmentNotionBinding.inflate(inflater, container, false)
    }

    override fun initClickListener() {

    }
}