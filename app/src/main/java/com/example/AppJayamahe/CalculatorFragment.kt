package com.example.AppJayamahe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CalculatorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalculatorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val _view = inflater.inflate(R.layout.fragment_calculator, container, false)
        var pilihan = 0

        var gEdt1 = _view.findViewById<EditText>(R.id.edt_bil1)
        // 2. edt 2
        var gEdt2 = _view.findViewById<EditText>(R.id.edt_bil2)
        // 3. spinner
        var gSpin = _view.findViewById<Spinner>(R.id.myspinner)
        // 4. button
        var gBtnCal = _view.findViewById<Button>(R.id.btn_calculate)
        // 5. textview
        var gTvHasil = _view.findViewById<TextView>(R.id.tv_hasil)

        gBtnCal.setOnClickListener {
            // 3
            var nilai1 = gEdt1.text.toString().toDouble()
            var nilai2 = gEdt2.text.toString().toDouble()
            var hasil = 0.0

            Log.d("Upay", "nilai1: " + nilai1 +
                    ", nilai2: " + nilai2)

            if(pilihan.equals(0)){ // tambah
                hasil = nilai1 + nilai2
            }
            else if( pilihan.equals(1)){
                hasil = nilai1 - nilai2
            }
            else if( pilihan.equals(2)){
                hasil = nilai1 * nilai2
            }
            else if( pilihan.equals(3)){
                hasil = nilai1/nilai2
            }

            gTvHasil.text = hasil.toString()
        }

        gSpin.setOnItemSelectedListener(
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                    Log.d("galih", "pilih item: " + p2)
                    pilihan = p2
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            })

        return _view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CalcFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CalculatorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}