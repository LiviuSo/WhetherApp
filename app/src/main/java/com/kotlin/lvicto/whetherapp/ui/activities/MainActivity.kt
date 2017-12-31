package com.kotlin.lvicto.whetherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.kotlin.lvicto.whetherapp.R
import com.kotlin.lvicto.whetherapp.domain.commands.RequestForecastCommand
import com.kotlin.lvicto.whetherapp.extensions.DelegatesExt
import com.kotlin.lvicto.whetherapp.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*


class MainActivity : AppCompatActivity(), ToolbarManager {

    private val zipCode: Long by DelegatesExt.longPreference(ctx, SettingsActivity.ZIP_CODE, SettingsActivity.DEFAULT_ZIP)
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()

        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)
    }

    override fun onResume() {
        super.onResume()
        loadForeast()
    }

    private fun loadForeast() {
        doAsync {
            val forecastRes = RequestForecastCommand(zipCode).execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(forecastRes) {
                    startActivity<DetailActivity>(DetailActivity.ID to it.id,
                            DetailActivity.CITY_NAME to forecastRes.city)
                }
                toolbarTitle = "${forecastRes.city} (${forecastRes.country})"
            }
        }
    }
}