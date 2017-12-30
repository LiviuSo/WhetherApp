package com.kotlin.lvicto.whetherapp.domain.datasource

import com.kotlin.lvicto.whetherapp.domain.model.Forecast
import com.kotlin.lvicto.whetherapp.domain.model.ForecastList


interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?
}