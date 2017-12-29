package com.kotlin.lvicto.whetherapp.domain.commands

import com.kotlin.lvicto.whetherapp.domain.datasource.ForecastProvider
import com.kotlin.lvicto.whetherapp.domain.model.ForecastList


class RequestForecastCommand(private val zipCode: Long,
                             private val forecastProvider: ForecastProvider = ForecastProvider()) : Command<ForecastList> {
     companion object {
             val DAYS = 7
     }

     override fun execute(): ForecastList = forecastProvider.requestByZipCode(zipCode, DAYS)
}