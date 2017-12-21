package com.kotlin.lvicto.whetherapp.domain.command

import com.kotlin.lvicto.whetherapp.domain.model.ForecastList
import com.kotlin.lvicto.whetherapp.data.ForecastRequest
import com.kotlin.lvicto.whetherapp.domain.mappers.ForecastDataMapper


class RequestForecastCommand(private val zipCode: String): Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}