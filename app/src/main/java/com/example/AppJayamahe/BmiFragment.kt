package com.example.AppJayamahe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlin.math.pow
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BmiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BmiFragment : Fragment() {
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
        var _view = inflater.inflate(R.layout.fragment_bmi, container, false)
        val editTextWeight: EditText = _view.findViewById(R.id.editTextWeight)
        val editTextHeight: EditText = _view.findViewById(R.id.editTextHeight)

        val textViewBMI: TextView = _view.findViewById(R.id.textViewBMI)
        val textViewStatus: TextView = _view.findViewById(R.id.textViewStatus)

        val buttonCalculate:Button = _view.findViewById(R.id.buttonCalculate)
        val buttonReset:Button = _view.findViewById(R.id.buttonReset)

        val imageViewBMI: ImageView = _view.findViewById(R.id.imageViewBMI)

        buttonCalculate.setOnClickListener{

            if(editTextWeight.text.isBlank()){
                editTextWeight.setError(getString(R.string.value_required))
                return@setOnClickListener //to stop program execution~
            }

            if(editTextHeight.text.isBlank()){
                editTextHeight.setError(getString(R.string.value_required))
                return@setOnClickListener //to stop program execution~
            }

            val weight:Float = editTextWeight.text.toString().toFloat()
            val height:Float = editTextHeight.text.toString().toFloat()
            val bmi = weight/ (height/100).pow(2)

            textViewBMI.text = String.format("%s : %.2f", getString(R.string.bmi), bmi)

            if(bmi < 18.5){
                textViewStatus.text = String.format("%s : %s", getString(R.string.status), getString(R.string.underweight))
                imageViewBMI.setImageResource(R.drawable.under)
            }
            else if(bmi > 18.5 && bmi < 24.9){
                textViewStatus.text = String.format("%s : %s", getString(R.string.status), getString(R.string.normal))
                imageViewBMI.setImageResource(R.drawable.normal)
            }
            else{
                textViewStatus.text = String.format("%s : %s", getString(R.string.status), getString(R.string.overweight))
                imageViewBMI.setImageResource(R.drawable.over)
            }
        }

        buttonReset.setOnClickListener {
            editTextWeight.setText("")
            editTextHeight.setText("")
            textViewBMI.text = getString(R.string.bmi)
            textViewStatus.text = getString(R.string.status)
            imageViewBMI.setImageResource(R.drawable.empty)
        }


        return _view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BmiFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BmiFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}