package com.example.meetaptravel

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_rows_place.view.*
import java.text.NumberFormat

class PlaceAdapter(list:List<PlaceModel>) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    var listModels:List<PlaceModel> = list

    override fun onCreateViewHolder(viewgroup: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(viewgroup.context)
                .inflate(
                    R.layout.item_rows_place,
                    viewgroup,
                    false))
    }

    override fun getItemCount(): Int = listModels.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindHolder(listModels.get(position))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.tvNameItemPlace
        val tvDistance = itemView.tvDistanceItemPlace
        val tvPrice = itemView.tvPriceItemPlace
        val tvDistrict = itemView.tvDistrictItemPlace
        val imgPlace = itemView.imgItemPlace
        val rlitemPlace = itemView.rlItemPlace

        fun bindHolder(placeModel: PlaceModel){
            tvName.text = placeModel.name
            tvDistance.text = "Jarak: " + placeModel.distance + "Km"
            tvPrice.text = "Harga: Rp." +
                    NumberFormat.getInstance().format(placeModel.price)
            tvDistrict.text = "Kecamatan: " + placeModel.district
            Picasso.with(itemView.context).load(placeModel.image).into(imgPlace)
            rlitemPlace.setOnClickListener {
                var sendData: Intent = Intent(itemView.context, DetailActivity::class.java)
                sendData.putExtra(DetailActivity.ExtraData, placeModel)
                itemView.context.startActivity(sendData)
            }
        }
    }
}
