package ru.lnv.smediabox.extensions

import android.widget.ImageView
import coil.load
import ru.lnv.smediabox.R


fun ImageView.displayImageWithCenterCrop(
    url: String?,
    placeholder: Int = R.drawable.placeholder_transparent
) {
    scaleType = ImageView.ScaleType.CENTER_CROP

    load(url) {
        placeholder(placeholder)
        error(placeholder)
    }
}