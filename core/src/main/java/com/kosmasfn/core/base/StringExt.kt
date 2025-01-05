package com.kosmasfn.core.base

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.TimeZone

@SuppressLint("SimpleDateFormat")
fun String.convertToLocalDateString(): String {
    return try {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        formatter.timeZone = TimeZone.getTimeZone("UTC")

        val value = formatter.parse(this)
        val dateFormatter = SimpleDateFormat("MMM dd, yyyy hh:mm a")

        dateFormatter.timeZone = TimeZone.getDefault()
        dateFormatter.format(value)

    } catch (e: java.lang.Exception) {
        ""
    }
}