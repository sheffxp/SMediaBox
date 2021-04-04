package ru.lnv.smediabox.screen.dialogs

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import ru.lnv.smediabox.R
import ru.lnv.smediabox.databinding.DialogLogoutBinding
import ru.lnv.smediabox.extensions.APP_ACTIVITY
import ru.lnv.smediabox.extensions.clearAll
import ru.lnv.smediabox.extensions.restartActivity


class LogoutDialog: DialogFragment() {
    private var _mbinding: DialogLogoutBinding? = null
    private val mBinding get() = _mbinding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _mbinding = DialogLogoutBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _mbinding = null
    }

    override fun onStart() {
        super.onStart()

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.btnCancel.setOnClickListener {
            dismiss()
        }

        mBinding.btnLogoutConfirm.setOnClickListener {
            clearAll()
            restartActivity()
            dismiss()
        }
    }
}