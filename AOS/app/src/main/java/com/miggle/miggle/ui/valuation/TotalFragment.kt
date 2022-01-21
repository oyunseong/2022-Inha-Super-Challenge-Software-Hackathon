package com.miggle.miggle.ui.valuation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentTotalBinding
import com.miggle.miggle.model.total

class TotalFragment : BaseFragment<FragmentTotalBinding>() {
    lateinit var totalAdapter: TotalAdapter
    val datas = mutableListOf<total>()

    override fun initClickListener() {
        initRecycler()
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTotalBinding {
        return FragmentTotalBinding.inflate(inflater, container, false)
    }

    fun initRecycler() {
        totalAdapter = TotalAdapter(requireContext())
        binding.totalRecycler.adapter = totalAdapter

        binding.totalRecycler.layoutManager = LinearLayoutManager(context)

        totalAdapter.apply {
            addItem()
            addItem()
            totalAdapter.notifyDataSetChanged()
        }

    }

}