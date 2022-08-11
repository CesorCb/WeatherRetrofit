package com.cesor.android.weatherprueb1.mainModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesor.android.weatherprueb1.R
import com.cesor.android.weatherprueb1.common.entities.WeatherForecastEntity
import com.cesor.android.weatherprueb1.mainModule.model.MainRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

/****
 * Project: Weather Prueb1
 * From: com.cesor.android.weatherprueb1.mainModule.viewModel
 * Created by: César Castro on 9/08/2022 at 13:55.
 ***/
class MainViewModel : ViewModel(){
    private val repository = MainRepository()

    private val result = MutableLiveData<WeatherForecastEntity>()
    fun getResult(): LiveData<WeatherForecastEntity> = result

    private val snackbarMsg = MutableLiveData<Int>()
    fun getSnackbarMsg() = snackbarMsg

    private val loaded = MutableLiveData<Boolean>()
    fun isLoaded() = loaded

    suspend fun getWeatherAndForecast(lat: Double, lon: Double, appId: String, exclude: String, units: String,
                                      lang: String){
        viewModelScope.launch {
            try {
                loaded.value = false
                val resultServer = repository.getWeatherAndForecast(lat, lon, appId, exclude, units, lang)
                result.value = resultServer
                if(resultServer.hourly == null || resultServer.hourly.isEmpty()){
                    snackbarMsg.value = R.string.main_error_empty_forecast
                }
            } catch (e: Exception) {
                snackbarMsg.value = R.string.main_error_server
            } finally {
                loaded.value = true
            }
        }
    }
}