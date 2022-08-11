package com.cesor.android.weatherprueb1.common.dataAccess

import com.cesor.android.weatherprueb1.common.entities.WeatherForecastEntity
import com.cesor.android.weatherprueb1.common.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

/****
 * Project: Weather Prueb1
 * From: com.cesor.android.weatherprueb1.common.dataAccess
 * Created by: César Castro on 9/08/2022 at 12:25.
 ***/
interface WeatherService {
    @GET(Constants.ONE_CALL_PATH)
    suspend fun getWeatherByCoordinates(
        @Query(Constants.LATITUDE_PARAM) lat: Double,
        @Query(Constants.LONGITUDE_PARAM) lon: Double,
        @Query(Constants.APP_ID_PARAM) appId: String,
        @Query(Constants.EXCLUDE_PARAM) exclude: String,
        @Query(Constants.UNITS_PARAM) units: String,
        @Query(Constants.LANGUAGE_PARAM) lang: String
    ) : WeatherForecastEntity
}