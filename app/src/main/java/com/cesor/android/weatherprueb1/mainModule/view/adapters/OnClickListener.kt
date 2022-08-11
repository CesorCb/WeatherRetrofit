package com.cesor.android.weatherprueb1.mainModule.view.adapters

import com.cesor.android.weatherprueb1.common.entities.Forecast

/****
 * Project: Weather Prueb1
 * From: com.cesor.android.weatherprueb1.mainModule.view.adapters
 * Created by: César Castro on 10/08/2022 at 19:13.
 ***/
interface OnClickListener {
    fun onClick(forecast: Forecast)
}