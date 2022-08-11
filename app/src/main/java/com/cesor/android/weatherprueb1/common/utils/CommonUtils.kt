package com.cesor.android.weatherprueb1.common.utils

import com.cesor.android.weatherprueb1.common.entities.Weather
import java.text.SimpleDateFormat
import java.util.*

/****
 * Project: Weather Prueb1
 * From: com.cesor.android.weatherprueb1.common.utils
 * Created by: César Castro on 10/08/2022 at 14:14.
 ***/
object CommonUtils {

    fun getHour(epoch: Long): String = getFormatedTime(epoch, "HH:mm")
    fun getFullDate(epoch: Long): String = getFormatedTime(epoch, "dd/MM/yy HH:mm")
    fun getPop(pop: Double): Int = (pop * 100).toInt()

    private fun getFormatedTime(epoch: Long, pattern: String): String {
        return SimpleDateFormat(pattern, Locale.getDefault()).format(epoch * 1_000)
    }
    fun getWeatherMain(weather: List<Weather>?): String {
        return if (weather != null && weather.isNotEmpty()) weather[0].main else "-"
    }

    fun getWeatherDescription(weather: List<Weather>?): String {
        return if (weather != null && weather.isNotEmpty()) weather[0].description else "-"
    }
}