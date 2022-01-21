package com.miggle.miggle.ui.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.miggle.miggle.MessageDialog
import com.miggle.miggle.R
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentPreferencesBinding

class PreferencesFragment : BaseFragment<FragmentPreferencesBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPreferencesBinding {
        return FragmentPreferencesBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.preferencesAppbar.appbarSearchButton.visibility = View.INVISIBLE
        binding.preferencesAppbar.appbarBellButton.visibility = View.INVISIBLE
        binding.preferencesAppbar.appbarSettingButton.visibility = View.INVISIBLE
        binding.myPageInfoSetting.setOnClickListener {
            view?.findNavController()?.navigate(R.id.ProfileEditFragment)
        }
        binding.preferencesMarketingCard.setOnClickListener {
            val dialog = MessageDialog(
                context = activity ?: return@setOnClickListener,
                title = R.string.comming_soon
            )
            dialog.show()
        }
        binding.preferencesRevokeCard.setOnClickListener {
            val dialog = MessageDialog(
                context = activity ?: return@setOnClickListener,
                title = R.string.comming_soon
            )
            dialog.show()
        }
    }

    override fun initClickListener() {

    }
}