package com.kotlin.lvicto.whetherapp.net

import android.util.Log
import java.net.URL

class Request(private val url: String) {

    fun run() {
        val forestcastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forestcastJsonStr)
    }
}