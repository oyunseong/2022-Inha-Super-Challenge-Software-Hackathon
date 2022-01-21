package com.miggle.miggle

import android.app.Activity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.miggle.miggle.base.BaseActivity
import com.miggle.miggle.databinding.ActivityGuideBinding

class GuideActivity : BaseActivity<ActivityGuideBinding>({ ActivityGuideBinding.inflate(it) }) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewPager2()
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
        val pagerAdapter = GuideAdapter(this)
        binding.guideViewpager2.adapter = pagerAdapter

        TabLayoutMediator(binding.valueationTabLayout, binding.guideViewpager2){tab, position ->
            when(position){
                0 ->tab.text = ""
                1 ->tab.text = ""
                2 ->tab.text = ""

            }
        }.attach()
    }
}