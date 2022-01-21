package com.miggle.miggle.ui.valuation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class RankingAdapter (fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TotalFragment()
            1 -> TotalFragment()
            2 -> TotalFragment()
            3 -> TotalFragment()
            else-> TotalFragment()
        }
    }
}