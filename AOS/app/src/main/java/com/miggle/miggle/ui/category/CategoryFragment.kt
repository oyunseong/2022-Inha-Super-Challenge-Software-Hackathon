package com.miggle.miggle.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.miggle.miggle.R
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentCategoryBinding

class CategoryFragment :BaseFragment<FragmentCategoryBinding>(){
    override fun initClickListener() {

        //TODO 버튼 클릭시 상세 카테고리로 이동
        binding.movieCard.setOnClickListener {
            showToast("movie click!")
            view?.findNavController()?.navigate(R.id.detailCategoryFragment)
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCategoryBinding {
        return FragmentCategoryBinding.inflate(inflater,container,false)
    }


}