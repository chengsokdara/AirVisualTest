package com.sokdara.cheng.airvisualtest.lib

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sokdara.cheng.airvisualtest.R
import com.sokdara.cheng.airvisualtest.mock.Places
import kotlinx.android.synthetic.main.item_places_card.view.*

class PlaceListAdapter(private val mDataset: ArrayList<Places.Place>) :
    RecyclerView.Adapter<PlaceListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_places_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (expandable, forecast, location, name, status, temperature, time) = mDataset[position]
        holder.itemView.itemPlaceExpandableButton.visibility = if (expandable) View.VISIBLE else View.GONE
        holder.itemView.itemPlaceExpandableButtonSeparator.visibility = if (expandable) View.VISIBLE else View.GONE
        holder.itemView.itemPlaceDay1Date.text = forecast[0].date
        holder.itemView.itemPlaceDay1MaxTemp.text = forecast[0].max
        holder.itemView.itemPlaceDay1MinTemp.text = forecast[0].min
        holder.itemView.itemPlaceDay2Date.text = forecast[1].date
        holder.itemView.itemPlaceDay2MaxTemp.text = forecast[1].max
        holder.itemView.itemPlaceDay2MinTemp.text = forecast[1].min
        holder.itemView.itemPlaceDay3Date.text = forecast[2].date
        holder.itemView.itemPlaceDay3MaxTemp.text = forecast[2].max
        holder.itemView.itemPlaceDay3MinTemp.text = forecast[2].min
        holder.itemView.itemPlaceLocation.text = location
        holder.itemView.itemPlaceName.text = name
        holder.itemView.itemPlaceStatus.text = status
        holder.itemView.itemPlaceTemperature.text = temperature
        holder.itemView.itemPlaceTime.text = time
    }

    override fun getItemCount(): Int = mDataset.size
}