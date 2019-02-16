package com.example.meetaptravel

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import java.text.NumberFormat

class DetailActivity : AppCompatActivity() {

    companion object {
        val ExtraData: String = "extradata"
        val RequestCode: Int = 123
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        /* Get Place Model from intent */
        val placeModel: PlaceModel = intent.getParcelableExtra(ExtraData)
        Picasso.with(this).load(placeModel.image).into(imgDetailPlace)
        tvDetailNamePlace.text = placeModel.name
        tvPriceDetailPlace.text = "Rp. " + NumberFormat.getInstance().format(placeModel.price)
        tvTlpDetailPlace.text = if (placeModel.numbTelp == null) "-" else placeModel.numbTelp
        tvDistrictDetailPlace.text = placeModel.district
        tvAddressDetailPlace.text = placeModel.address
        tvDescDetailPlace.text = placeModel.desc
        spOperationalTime.adapter =
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, placeModel.operationalTime)
        spOperationalTime.setSelection(0)
        btnShowMap.setOnClickListener {
            var uriImage: Uri = Uri.parse("geo:" + placeModel.latlong)
            var mapIntent: Intent = Intent(Intent.ACTION_VIEW, uriImage)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
        btnGetTicket.setOnClickListener {
            var getTikcetIntent: Intent = Intent(this, GetTicketActivity::class.java)
            startActivityForResult(getTikcetIntent, RequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RequestCode) {
            if (resultCode == GetTicketActivity.resultCode && data != null) {
                var ticket: Int = data.getIntExtra(GetTicketActivity.sendResultData, 0)
                Toast.makeText(this, "Anda berhasil memesan " + ticket + " tiket", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
