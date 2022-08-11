package com.cesor.android.weatherprueb1.mainModule.model

import com.cesor.android.weatherprueb1.common.dataAccess.WeatherService
import com.cesor.android.weatherprueb1.common.entities.WeatherForecastEntity
import com.cesor.android.weatherprueb1.common.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/****
 * Project: Weather Prueb1
 * From: com.cesor.android.weatherprueb1.mainModule.model
 * Created by: César Castro on 9/08/2022 at 12:46.
 ***/
class WeatherRemoteDataSource {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service = retrofit.create(WeatherService::class.java)

    suspend fun getWeatherForecastByCoordinates(lat: Double, lon: Double, appId: String, exclude: String,
                                                units: String, lang: String) : WeatherForecastEntity =
        withContext(Dispatchers.IO){
            service.getWeatherByCoordinates(lat, lon, appId, exclude, units, lang)
        }
}