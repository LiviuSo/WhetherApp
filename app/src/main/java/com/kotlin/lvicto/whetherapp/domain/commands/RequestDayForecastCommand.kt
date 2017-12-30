package com.kotlin.lvicto.whetherapp.domain.commands

import com.kotlin.lvicto.whetherapp.domain.datasource.ForecastProvider
import com.kotlin.lvicto.whetherapp.domain.model.Forecast

class RequestDayForecastCommand(val id: Long,
                                private val forecastProvider: ForecastProvider = ForecastProvider()) : Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}