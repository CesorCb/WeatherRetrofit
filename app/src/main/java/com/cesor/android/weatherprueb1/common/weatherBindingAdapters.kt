package com.cesor.android.weatherprueb1.common

import android.view.View
import androidx.databinding.BindingAdapter

/****
 * Project: Weather Prueb1
 * From: com.cesor.android.weatherprueb1.common
 * Created by: César Castro on 10/08/2022 at 18:10.
 ***/

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean){
    view.visibility = if (isGone) View.GONE else View.VISIBLE
}