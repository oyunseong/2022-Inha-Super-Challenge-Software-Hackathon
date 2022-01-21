package com.miggle.miggle.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentDailyReportBinding
import com.miggle.miggle.model.PostCase
import com.miggle.miggle.ui.CommunityViewModel
import com.miggle.miggle.ui.community.CommunityAdapter

class DailyReportFragment:BaseFragment<FragmentDailyReportBinding>() {
    private lateinit var communityAdapter: CommunityAdapter
    val viewModel by lazy {
        ViewModelProvider(this).get(CommunityViewModel::class.java)
    }
    override fun initClickListener() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.dailReportAppbar.appbarSearchButton.visibility = View.INVISIBLE
        binding.dailReportAppbar.appbarSettingButton.visibility = View.INVISIBLE

        communityAdapter = CommunityAdapter(PostCase.STOCK_INFO)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(layoutInflater.context)
        binding.dailyRecycer.layoutManager = layoutManager
        binding.dailyRecycer.adapter = communityAdapter
        binding.dailyRecycer.setHasFixedSize(true)

        viewModel.getPost() //
//        viewModel.getPosts2() // 불러오기
//        viewModel.getUsers()
        viewModel.singlePost.observe(viewLifecycleOwner, Observer {
            Log.d("single post", it.title)
        })

        viewModel.getPosts() //
        viewModel.postList.observe(viewLifecycleOwner, Observer {
            communityAdapter.submitList(it)

        })
    }
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDailyReportBinding {
        return FragmentDailyReportBinding.inflate(inflater,container,false)
    }
}