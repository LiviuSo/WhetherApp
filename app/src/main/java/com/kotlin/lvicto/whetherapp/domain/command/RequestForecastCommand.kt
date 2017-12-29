package com.kotlin.lvicto.whetherapp.domain.command

import com.kotlin.lvicto.whetherapp.data.server.ForecastRequest
import com.kotlin.lvicto.whetherapp.domain.mappers.ForecastDataMapper
import com.kotlin.lvicto.whetherapp.domain.model.ForecastList


class RequestForecastCommand(private val zipCode: Long): Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(zipCode, forecastRequest.execute())
    }
}