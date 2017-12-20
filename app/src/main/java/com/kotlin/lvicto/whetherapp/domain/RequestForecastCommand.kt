package com.kotlin.lvicto.whetherapp.domain

import com.kotlin.lvicto.whetherapp.domain.model.ForecastList
import com.kotlin.lvicto.whetherapp.net.ForecastRequest


class RequestForecastCommand(private val zipCode: String): Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}