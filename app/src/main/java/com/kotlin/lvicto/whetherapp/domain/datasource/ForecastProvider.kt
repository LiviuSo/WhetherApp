package com.kotlin.lvicto.whetherapp.domain.datasource

import com.kotlin.lvicto.whetherapp.data.db.ForecastDb
import com.kotlin.lvicto.whetherapp.data.server.ForecastServer
import com.kotlin.lvicto.whetherapp.domain.model.Forecast
import com.kotlin.lvicto.whetherapp.domain.model.ForecastList
import com.kotlin.lvicto.whetherapp.extensions.firstResult


class ForecastProvider(private val sources: List<ForecastDataSource> = SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = requestToSources {
             val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
             if (res != null && res.size >= days) res else null
    }

    fun requestForecast(id: Long): Forecast = requestToSources {
             it.requestDayForecast(id)
    }

    private fun <T : Any> requestToSources(f: (ForecastDataSource) -> T?): T
             = sources.firstResult { f(it) }

    private fun todayTimeSpan() = System.currentTimeMillis() /
            DAY_IN_MILLIS * DAY_IN_MILLIS
}