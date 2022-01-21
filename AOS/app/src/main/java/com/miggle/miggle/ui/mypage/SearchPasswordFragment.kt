package com.miggle.miggle.ui.mypage

import android.view.LayoutInflater
import android.view.ViewGroup
import com.miggle.miggle.MessageDialog
import com.miggle.miggle.R
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentSearchPasswordBinding

class SearchPasswordFragment : BaseFragment<FragmentSearchPasswordBinding>() {
    override fun initClickListener() {
        binding.searchPasswordSendButton.setOnClickListener {
            val dialog = MessageDialog(
                context = activity ?: return@setOnClickListener,
                title = R.string.sent_to_email_new_password
            )
            dialog.show()
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchPasswordBinding {
        return FragmentSearchPasswordBinding.inflate(inflater,container,false)
    }
}