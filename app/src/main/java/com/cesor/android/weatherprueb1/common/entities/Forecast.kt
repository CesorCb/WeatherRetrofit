package com.cesor.android.weatherprueb1.common.entities

/****
 * Project: Weather Prueb1
 * From: com.cesor.android.weatherprueb1
 * Created by: César Castro on 8/08/2022 at 22:37.
 ***/
data class Forecast(
    val dt: Long,
    val humidity: Int,
    val temp: Double,
    val weather: List<Weather>,
    val pop: Double
): WeatherBase(dt, humidity, temp, weather)