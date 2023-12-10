package com.news.aware.common

fun String.decode() : String{
    val key = "XyoloaFjVlHgMquO"
    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    val sb = StringBuilder()

    for (i in this.indices) {
        val c = this[i]
        val k = key[i % key.length]

        val m = alphabet.indexOf(c.toLowerCase())
        val n = alphabet.indexOf(k.toLowerCase())

        if (m != -1) {
            val index = (m - n + alphabet.length) % alphabet.length
            sb.append(if (c.isUpperCase()) alphabet[index].toUpperCase() else alphabet[index])
        } else {
            sb.append(c)
        }
    }

    return sb.toString()
}