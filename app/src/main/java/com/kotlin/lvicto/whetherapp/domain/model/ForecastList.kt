package com.kotlin.lvicto.whetherapp.domain.model

data class ForecastList(val city: String,
                        val country: String,
                        val dailyForecast: List<Forecast>)