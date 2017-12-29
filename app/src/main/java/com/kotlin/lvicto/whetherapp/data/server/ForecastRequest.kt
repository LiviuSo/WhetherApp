package com.kotlin.lvicto.whetherapp.data.server

import com.google.gson.Gson
import java.net.URL

class ForecastRequest(private val zipCode: Long) {

    companion object {
        private val APP_ID = "f637e584acb8529afb2e0d7a30497337"
        private val BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric"
        private val COMPLETE_URL = "${BASE_URL}&APPID=${APP_ID}&zip="
    }

    fun execute(): ForecastResult {
        val forecastJsonBytes = URL(COMPLETE_URL + zipCode).readBytes()
        val forecastJsonStr =  String(forecastJsonBytes)
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}