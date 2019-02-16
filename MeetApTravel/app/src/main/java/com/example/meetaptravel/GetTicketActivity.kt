package com.example.meetaptravel

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_get_ticket.*

class GetTicketActivity : AppCompatActivity() {

    companion object {
        val resultCode: Int = 123
        val sendResultData: String = "sendresultdata"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_ticket)
        btnGetTicket.setOnClickListener {
            var data: Int = 0
            if (edtGetTicket.text.toString() != "" && edtGetTicket.text != null)
                data = edtGetTicket.text.toString().toInt()

            if (data == 0)
                edtGetTicket.setError("Pastikan anda sudah mengisi jumlah tiket")
            else {
                var sendIntent: Intent = Intent()
                sendIntent.putExtra(sendResultData, data)
                setResult(resultCode, sendIntent)
                finish()
            }
        }
    }
}
