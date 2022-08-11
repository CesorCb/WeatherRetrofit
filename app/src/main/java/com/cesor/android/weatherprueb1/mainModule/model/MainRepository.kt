package com.cesor.android.weatherprueb1.mainModule.model

import com.cesor.android.weatherprueb1.common.entities.WeatherForecastEntity

/****
 * Project: Weather Prueb1
 * From: com.cesor.android.weatherprueb1.mainModule.model
 * Created by: César Castro on 9/08/2022 at 12:56.
 ***/
class MainRepository {
    private val weatherRemoteDataSource = WeatherRemoteDataSource()

    suspend fun getWeatherAndForecast(lat: Double, lon: Double, appId: String, exclude: String, units: String,
                                      lang: String) : WeatherForecastEntity =
        weatherRemoteDataSource.getWeatherForecastByCoordinates(lat, lon, appId, exclude, units, lang)
}