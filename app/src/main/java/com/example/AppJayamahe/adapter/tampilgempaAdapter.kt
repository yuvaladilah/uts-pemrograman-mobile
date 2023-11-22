package com.example.AppJayamahe.adapter

import android.app.Activity
import android.graphics.ColorSpace.Model
import android.widget.ArrayAdapter
import com.example.AppJayamahe.R
import com.example.AppJayamahe.datamodel.ModelListGempa
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.AppJayamahe.datamodel.GempaItem

class tampilgempaAdapter(val data : ModelListGempa?, val context: Activity, val _g : List<GempaItem?>)
    : ArrayAdapter<GempaItem>(context, R.layout.activity_list_view_costum, _g){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.activity_list_view_costum, null, true)

        // definisi komponen UI - widget
        // indexing
        var _idx = rowView.findViewById<TextView>(R.id.list_nomor)
        // tanggal
        var _tgl = rowView.findViewById<TextView>(R.id.list_tanggal)
        // koordinat
        var _koo = rowView.findViewById<TextView>(R.id.list_koordinat)
        // wilayah
        var _wlh = rowView.findViewById<TextView>(R.id.list_wilayah)

        _idx.setText("#" + (position + 1).toString())
        Log.d("yuvaladilah", "posisi: " + (position + 1))
        // tanggal
        _tgl.setText(data?.infogempa?.gempa?.get(position)?.tanggal)
        Log.d("yuvaladilah", "tanggal: " + data?.infogempa?.gempa?.get(position)?.tanggal)
        // koordinat
        _koo.setText(data?.infogempa?.gempa?.get(position)?.coordinates)
        Log.d("yuvaladilah", "koordinat: " + data?.infogempa?.gempa?.get(position)?.coordinates)
        // wilayah
        _wlh.setText(data?.infogempa?.gempa?.get(position)?.wilayah)
        Log.d("yuvaladilah", "wilayah: " + data?.infogempa?.gempa?.get(position)?.wilayah)

        return rowView

    }
}