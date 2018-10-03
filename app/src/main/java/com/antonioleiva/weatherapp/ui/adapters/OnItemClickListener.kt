package com.antonioleiva.weatherapp.ui.adapters

import com.antonioleiva.weatherapp.domain.model.Forecast

interface OnItemClickListener {
    operator fun invoke(forecast: Forecast)
}