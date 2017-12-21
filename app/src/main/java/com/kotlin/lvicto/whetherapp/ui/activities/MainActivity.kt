package com.kotlin.lvicto.whetherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.kotlin.lvicto.whetherapp.R
import com.kotlin.lvicto.whetherapp.domain.command.RequestForecastCommand
import com.kotlin.lvicto.whetherapp.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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