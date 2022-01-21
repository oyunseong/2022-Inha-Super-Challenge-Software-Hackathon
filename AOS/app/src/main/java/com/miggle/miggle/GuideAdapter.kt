package com.miggle.miggle

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class GuideAdapter (fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> GuideFirstFragment()
            1 -> GuideSecondFragment()
            2 -> GuideThirdFragment()
            else-> GuideThirdFragment()
        }
    }
}