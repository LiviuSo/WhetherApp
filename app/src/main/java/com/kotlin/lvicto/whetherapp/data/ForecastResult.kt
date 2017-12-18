package com.kotlin.lvicto.whetherapp.data


data class ForecastResult(val city: City,
                          val code: String,
                          val message: Double,
                          val cnt: Int,
                          val list: List<Forecast>)
