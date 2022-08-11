package com.cesor.android.weatherprueb1.common.entities


/****
 * Project: Weather Prueb1
 * From: com.cesor.android.weatherprueb1
 * Created by: César Castro on 8/08/2022 at 22:42.
 ***/
data class WeatherForecastEntity(
    val timezone: String, val current: Current, val hourly: List<Forecast>?)
