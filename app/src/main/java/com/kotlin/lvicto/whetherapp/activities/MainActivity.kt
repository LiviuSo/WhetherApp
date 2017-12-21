package com.kotlin.lvicto.whetherapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kotlin.lvicto.whetherapp.R
import com.kotlin.lvicto.whetherapp.adapters.ForecastListAdapter
import com.kotlin.lvicto.whetherapp.domain.RequestForecastCommand
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList = findViewById<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val forecastRes = RequestForecastCommand("97005").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(forecastRes) {
                    toast(it.date)
                }
            }
        }
    }
}