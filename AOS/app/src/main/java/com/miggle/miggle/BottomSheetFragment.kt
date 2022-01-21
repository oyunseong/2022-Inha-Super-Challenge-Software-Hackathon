package com.miggle.miggle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.miggle.miggle.databinding.BottomSheetDialogBinding

class BottomSheetFragment : BottomSheetDialogFragment() {
//    lateinit var binding: BottomSheetDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_dialog,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*binding.tvNo.setOnClickListener {
            dismiss()
        }
        binding.tvYes.setOnClickListener {
            view?.findNavController()?.navigate(R.id.LoginFragment)
        }*/
    }
}