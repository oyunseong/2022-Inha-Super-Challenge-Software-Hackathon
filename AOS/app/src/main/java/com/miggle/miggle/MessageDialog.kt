package com.miggle.miggle

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import com.miggle.miggle.databinding.DialogMessageBinding
import com.miggle.miggle.utils.setMargin

/**
 * https://thdev.tech/kotlin/2017/03/09/Kotlin-Constructor-Init/
 */

class MessageDialog(
    context: Context,
    @StringRes title: Int,
    @StringRes buttonText: Int = R.string.close,
    @StyleRes themeResId: Int = R.style.BasicDialogStyle
) : Dialog(context, themeResId) {

    private val binding = DialogMessageBinding.inflate(layoutInflater)

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)
        window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

        binding.root.setMargin(left = 40f, right = 40f)

        binding.messageDialogTitle.text = getContext().getString(title)
        binding.messageDialogButtonText.text = getContext().getString(buttonText)

        binding.messageDialogButton.setOnClickListener {
//            Toast.makeText(context, "cancel button", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }

}