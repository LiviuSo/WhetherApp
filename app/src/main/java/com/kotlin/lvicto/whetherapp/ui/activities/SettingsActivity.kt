package com.kotlin.lvicto.whetherapp.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.kotlin.lvicto.whetherapp.R
import com.kotlin.lvicto.whetherapp.extensions.DelegatesExt
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.ctx

class SettingsActivity : AppCompatActivity() {


    companion object {
        val ZIP_CODE = "zipCode"
        val DEFAULT_ZIP = 94043L
    }

    private var zipCode: Long by DelegatesExt.longPreference(ctx, ZIP_CODE, DEFAULT_ZIP)

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setSupportActionBar(toolbar)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        cityCode.setText(zipCode.toString())
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> false
    }

    override fun onBackPressed() {
        super.onBackPressed()
        zipCode = cityCode.text.toString().toLong()
    }
}