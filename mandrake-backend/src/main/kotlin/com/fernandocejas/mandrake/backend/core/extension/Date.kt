package com.fernandocejas.mandrake.backend.core.extension

import java.text.*
import java.util.*

/**
 * Output a date with the desired format.
 *
 * Usage:
 * "2018-09-10 22:01:00".toDate().formatTo("dd MMM yyyy")
 *
 * Output:
 * "11 Sep 2018"
 */
fun Date.formatTo(dateFormat: String, timeZone: TimeZone = TimeZone.getDefault()): String {
    val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
    formatter.timeZone = timeZone
    return formatter.format(this)
}