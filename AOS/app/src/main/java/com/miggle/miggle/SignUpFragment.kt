package com.miggle.miggle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.forEachIndexed
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentSignUpBinding

class SignUpFragment :BaseFragment<FragmentSignUpBinding>(){
//    private val items = resources.getStringArray(R.array.nation_array)

    override fun initClickListener() {
        binding.signUpButton.setOnClickListener {
            val dialog = MessageDialog(
                context = activity ?: return@setOnClickListener,
                title = R.string.server_offline
            )
            dialog.show()
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignUpBinding {
        return FragmentSignUpBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSpinner()
    }



    private fun setupSpinner(){
//        val mAdapter = ArrayAdapter(requireActivity(), R.layout.item_spinner,items)
        binding.nationSpinner.adapter = ArrayAdapter(requireContext(), R.layout.item_spinner,resources.getStringArray(R.array.nation_array))
        binding.nationSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }
}