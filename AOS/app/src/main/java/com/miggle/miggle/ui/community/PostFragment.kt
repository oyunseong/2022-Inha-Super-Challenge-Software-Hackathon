package com.miggle.miggle.ui.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentPostBinding
import com.miggle.miggle.model.Post
import com.miggle.miggle.model.PostCase
import java.util.ArrayList

class PostFragment : BaseFragment<FragmentPostBinding>(){
    private var mAdapter: CommunityAdapter? = null
    private var postList: ArrayList<Post>? = null

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPostBinding {
        return FragmentPostBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postList = ArrayList()
        mAdapter = CommunityAdapter( PostCase.STOCK_INFO)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(layoutInflater.context)
        binding!!.postRecycler.layoutManager = layoutManager
//        binding!!.postRecycler.addItemDecoration(RecyclerDecorationHeight(3))
        binding!!.postRecycler.adapter = mAdapter
//        posts
        mAdapter!!.notifyDataSetChanged()
        swipeRefresh()
    }

    override fun initClickListener() {

    }
    private fun addList(){
//        postList.add()
    }

    private fun swipeRefresh() {
        binding!!.postRefreshLayout.setOnRefreshListener {
            postList!!.clear()
//            posts
            showToast("새로고침 완료")
            binding!!.postRefreshLayout.isRefreshing = false
        }
    }

}