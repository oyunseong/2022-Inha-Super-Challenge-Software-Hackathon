package com.miggle.miggle.ui.valuation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import com.miggle.miggle.BottomSheetFragment
import com.miggle.miggle.R
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentValuationBinding


class ValuationTabFragment : BaseFragment<FragmentValuationBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentValuationBinding {
        return FragmentValuationBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.valueationAppbar.appbarSettingButton.visibility = View.INVISIBLE

        val transaction = childFragmentManager.beginTransaction()
            .add(R.id.valueation_frame, RankingFragment())
            transaction.commit()

    }





    override fun initClickListener() {
        binding.valueationAppbar.appbarSearchButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.SearchFragment)
        }

        binding.valueationAppbar.appbarBellButton.setOnClickListener {
//            view?.findNavController()?.navigate(R.id.NotionFragment)
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(parentFragmentManager,bottomSheetFragment.tag)
        }
        binding.valueationRankingButton.setOnClickListener {
//            view?.findNavController()?.navigate(R.id.RankingFragment)

            /*val dialog = MessageDialog(
                context = activity ?: return@setOnClickListener,
                title = R.string.comming_soon
            )
            dialog.show()*/
        }
        binding.valueationCalculatorButton.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(parentFragmentManager,bottomSheetFragment.tag)
        }
        binding.valueationLikeStockButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.LikeStockListFragment)
        }

    }


}