package ru.lnv.smediabox.extensions

import com.soywiz.klock.DateFormat
import com.soywiz.klock.DateTimeTz
import com.soywiz.klock.parse

fun String.toDate(inputFormat: String = "yyyy-MM-dd"): DateTimeTz {
    val dateFormat = DateFormat(inputFormat)
    return dateFormat.parse(this)
}