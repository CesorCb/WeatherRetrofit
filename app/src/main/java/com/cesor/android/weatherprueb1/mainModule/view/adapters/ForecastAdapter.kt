package com.cesor.android.weatherprueb1.mainModule.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cesor.android.weatherprueb1.BR
import com.cesor.android.weatherprueb1.R
import com.cesor.android.weatherprueb1.common.entities.Forecast
import com.cesor.android.weatherprueb1.databinding.ItemWeatherBinding

/****
 * Project: Weather Prueb1
 * From: com.cesor.android.weatherprueb1.mainModule.view.adapters
 * Created by: César Castro on 10/08/2022 at 19:13.
 ***/

class ForecastAdapter(private val listener: OnClickListener) : ListAdapter<Forecast, RecyclerView.ViewHolder>(ForecastDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val forecast = getItem(position)
        with(holder as ViewHolder){
            binding?.setVariable(BR.forecast, forecast)
            binding?.executePendingBindings()

            setListener(forecast)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = DataBindingUtil.bind<ItemWeatherBinding>(view)

        fun setListener(forecast: Forecast){
            binding?.root?.setOnClickListener {
                listener.onClick(forecast)
            }
        }
    }

    class ForecastDiffCallback: DiffUtil.ItemCallback<Forecast>(){
        override fun areItemsTheSame(oldItem: Forecast, newItem: Forecast): Boolean = newItem.dt == oldItem.dt

        override fun areContentsTheSame(oldItem: Forecast, newItem: Forecast): Boolean = newItem == oldItem
    }
}