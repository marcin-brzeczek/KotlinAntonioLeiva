package com.antonioleiva.weatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.antonioleiva.weatherapp.R
import com.antonioleiva.weatherapp.domain.commands.RequestForecastCommand
import com.antonioleiva.weatherapp.domain.model.Forecast
import com.antonioleiva.weatherapp.ui.adapters.ForecastListAdapter
import com.antonioleiva.weatherapp.ui.adapters.OnItemClickListener
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(), OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList = find<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result, this@MainActivity)
            }
        }
    }

    override fun invoke(forecast: Forecast) {
        toast("Clicked ${forecast.description}")
    }
}
