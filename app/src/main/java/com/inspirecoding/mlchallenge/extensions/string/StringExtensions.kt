package com.inspirecoding.mlchallenge.extensions.string

import com.google.gson.Gson
import com.inspirecoding.mlchallenge.domain.model.exception.GenericException
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import java.text.NumberFormat
import java.util.Locale

fun String.decode(): String = URLDecoder.decode(this, StandardCharsets.UTF_8.toString())

internal fun String?.toDefaultError() = try {
    Gson().fromJson(
        this,
        GenericException::class.java
    )
} catch (e: Exception) {
    GenericException(code = "999", message = "generic error")
}

internal fun String?.containsTagHtml() =
    (this != null && this.contains("html"))

internal fun String?.imageToSecureProtocol(): String? = if (!this.isNullOrEmpty()) {
    this.replace("http://", "https://")
} else {
    this
}

fun String?.formatToARS(): String {
    val numberFormat = NumberFormat.getCurrencyInstance(Locale("es", "AR"))
    return this?.toDouble().let { numberFormat.format(it) } ?: "N/A"
}