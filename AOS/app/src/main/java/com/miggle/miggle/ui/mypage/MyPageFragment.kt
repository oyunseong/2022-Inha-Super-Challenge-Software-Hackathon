package com.miggle.miggle.ui.mypage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.miggle.miggle.R
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentMypageBinding

class MyPageFragment: BaseFragment<FragmentMypageBinding>() {
    override fun initClickListener() {
        binding.logoutCard.setOnClickListener {
            view?.findNavController()?.navigate(R.id.LoginFragment)
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMypageBinding {
        return FragmentMypageBinding.inflate(inflater,container,false)
    }
}