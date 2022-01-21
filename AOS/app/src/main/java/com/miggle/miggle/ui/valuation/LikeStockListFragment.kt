package com.miggle.miggle.ui.valuation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentLikeStockBinding

class LikeStockListFragment :BaseFragment<FragmentLikeStockBinding>(){
    override fun initClickListener() {

    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLikeStockBinding {
        return FragmentLikeStockBinding.inflate(inflater,container,false)
    }
}