package com.miggle.miggle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentLoginBinding

class LoginFragment :BaseFragment<FragmentLoginBinding>(){
    override fun initClickListener() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.navigation_home)
        }
        binding.loginSearchPassword.setOnClickListener {
            view?.findNavController()?.navigate(R.id.SearchPasswordFragment)
        }
        binding.loginSignup.setOnClickListener{
            view?.findNavController()?.navigate(R.id.SignUpFragment)
        }
        binding.googleButton.setOnClickListener {
            val dialog = MessageDialog(
                context = activity ?: return@setOnClickListener,
                title = R.string.comming_soon
            )
            dialog.show()//
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater,container,false)
    }
}