package com.kotlin.lvicto.whetherapp.domain.mappers

import com.kotlin.lvicto.whetherapp.data.server.Forecast
import com.kotlin.lvicto.whetherapp.data.server.ForecastResult
import com.kotlin.lvicto.whetherapp.domain.model.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit
import com.kotlin.lvicto.whetherapp.domain.model.Forecast as ModelForecast


class ForecastDataMapper {

    fun convertFromDataModel(zipCode: Long, forecast: ForecastResult): ForecastList {
        return ForecastList(zipCode,
                forecast.city.name,
                forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed {
            i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis((i.toLong()))
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(forecast.dt,
                forecast.weather[0].description,
                forecast.temp.max.toInt(),
                forecast.temp.min.toInt(),
                generateIconUrl(forecast.weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String  = "http://openweathermap.org/img/w/$iconCode.png"
}