package com.kotlin.lvicto.whetherapp.data.server

import com.kotlin.lvicto.whetherapp.data.db.ForecastDb
import com.kotlin.lvicto.whetherapp.domain.datasource.ForecastDataSource
import com.kotlin.lvicto.whetherapp.domain.model.ForecastList


class ForecastServer(private val dataMapper: ServerDataMapper = ServerDataMapper(),
                     private val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }

    override fun requestDayForecast(id: Long)
             = throw UnsupportedOperationException()

}