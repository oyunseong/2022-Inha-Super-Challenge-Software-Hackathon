package com.miggle.miggle.ui.community

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miggle.miggle.BottomSheetFragment
import com.miggle.miggle.R
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentCommunityBinding
import com.miggle.miggle.model.Post
import com.miggle.miggle.model.PostCase
import com.miggle.miggle.ui.CommunityViewModel

class CommunityTapFragment : BaseFragment<FragmentCommunityBinding>() {
    private lateinit var communityAdapter: CommunityAdapter

    val viewModel by lazy {
        ViewModelProvider(this).get(CommunityViewModel::class.java)
    }

    val TAG = "TAG1"
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCommunityBinding {
        return FragmentCommunityBinding.inflate(inflater, container, false)
    }

    override fun initClickListener() {
        binding.communityAppbar.appbarSearchButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.SearchFragment)
        }
        binding.communityAppbar.appbarBellButton.setOnClickListener {
//            view?.findNavController()?.navigate(R.id.NotionFragment)
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(parentFragmentManager,bottomSheetFragment.tag)
        }
        binding.stockInfoButton.setOnClickListener{
            showToast("미연동")
        }
        /*binding.stockInfoButton.setOnClickListener{
            showToast("종목버튼 클릭")
            communityAdapter = CommunityAdapter(PostCase.STOCK_INFO)
            communityAdapter.notifyDataSetChanged()
        }
        binding.freeboardButton.setOnClickListener{
            showToast("자유게시판 버튼 클릭")    // 클릭
            communityAdapter = CommunityAdapter(PostCase.FREE_BOARD)
            communityAdapter.notifyDataSetChanged()
        }*/
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.communityAppbar.appbarSettingButton.visibility = View.INVISIBLE

        communityAdapter = CommunityAdapter(PostCase.STOCK_INFO)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(layoutInflater.context)
        binding.communityRecycler.layoutManager = layoutManager
        binding.communityRecycler.adapter = communityAdapter
        binding.communityRecycler.setHasFixedSize(true)

        viewModel.getPost() //
//        viewModel.getPosts2() // 불러오기
//        viewModel.getUsers()
        viewModel.singlePost.observe(viewLifecycleOwner, Observer {
            Log.d("single post", it.title)
        })

        viewModel.getPosts() //
        viewModel.postList.observe(viewLifecycleOwner, Observer {
            communityAdapter.submitList(it)

            for (post in it) {
                Log.d(TAG, post.id.toString())
                Log.d(TAG, post.userId.toString())
            }
        })
    }
}