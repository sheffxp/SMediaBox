package ru.lnv.smediabox.screen.dialogs

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.format.Formatter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import ru.lnv.smediabox.R
import ru.lnv.smediabox.databinding.DialogClearcacheBinding
import ru.lnv.smediabox.extensions.APP_ACTIVITY
import ru.lnv.smediabox.extensions.calculateCache

class ClearCacheDialog : DialogFragment() {
    private var _mbinding: DialogClearcacheBinding? = null
    private val mBinding get() = _mbinding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _mbinding = DialogClearcacheBinding.inflate(layoutInflater, container, false)
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
        mBinding.cacheSize.text = "Размер: " + Formatter.formatShortFileSize(APP_ACTIVITY, calculateCache())

        mBinding.btnCancel.setOnClickListener {
            dismiss()
        }

        mBinding.btnClearNow.setOnClickListener {
            if (APP_ACTIVITY.cacheDir.deleteRecursively()) {
                APP_ACTIVITY.findViewById<TextView>(R.id.settings_cache_size).text = Formatter.formatShortFileSize(APP_ACTIVITY, calculateCache())
                dismiss()
            }

        }
    }


}