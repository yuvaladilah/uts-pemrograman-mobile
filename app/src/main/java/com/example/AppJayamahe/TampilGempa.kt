package com.example.AppJayamahe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.example.AppJayamahe.adapter.tampilgempaAdapter
import com.example.AppJayamahe.config.DataConfig
import com.example.AppJayamahe.datamodel.ModelListGempa
import retrofit2.Callback
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Response

class TampilGempa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tampilgempa)

        val _listview = findViewById<ListView>(R.id.list_gempa)

        DataConfig()
            .getService()
            .getDataGempa()
            .enqueue(object : Callback<ModelListGempa>{
                override fun onResponse(
                    call: Call<ModelListGempa>,
                    response: Response<ModelListGempa>
                ) {
                    Log.d("yuvaladilah", "data json : " + response.body())
                    _listview.adapter = tampilgempaAdapter(response.body(), this@TampilGempa,
                        response.body()?.infogempa?.gempa!!
                    )
                }

                override fun onFailure(call: Call<ModelListGempa>, t: Throwable) {
                    Log.d("yuvaladilah", "error : " + t.message.toString())
                }

            })

    }
}