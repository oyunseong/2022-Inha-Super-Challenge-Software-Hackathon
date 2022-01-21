package com.miggle.miggle.ui.valuation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentRankingBinding

class RankingFragment :BaseFragment<FragmentRankingBinding>(){
    override fun initClickListener() {
        viewPager2()
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRankingBinding {
        return FragmentRankingBinding.inflate(inflater,container, false)
    }

    fun viewPager2(){
        binding.valueationTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // 탭이 선택되었을 때
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // 탭이 선택되지 않은 상태로 변경 되었을 때
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // 이미 선태된 탭이 다시 선택 되었을 때
            }
        })
        binding.valueationViewpager.adapter = RankingAdapter(requireActivity())

        TabLayoutMediator(binding.valueationTabLayout, binding.valueationViewpager){tab, position ->
            when(position){
                0 ->tab.text = "종합"
                1 ->tab.text = "PER"
                2 ->tab.text = "PBR"
                3 ->tab.text = "PSR"
            }
        }.attach()
    }
}