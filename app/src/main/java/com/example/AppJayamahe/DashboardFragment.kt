package com.example.AppJayamahe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {
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


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var _view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        var go_home: CardView
        var go_profile: CardView
        var go_todolist: CardView
        var go_convert: CardView
        var go_calculator: CardView
        var go_bmi: CardView

        go_home = _view.findViewById(R.id.goHome)
        go_profile = _view.findViewById(R.id.goProfile)
        go_todolist = _view.findViewById(R.id.goToDoList)
//        go_convert = _view.findViewById(R.id.goConversionCurrent)
//        go_calculator = _view.findViewById(R.id.goCalculator)
//        go_bmi = _view.findViewById(R.id.goBMI)

        go_home.setOnClickListener {
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
        }

        go_profile.setOnClickListener {
            val intent = Intent(requireContext(), ProfileActivity::class.java)
            startActivity(intent)
        }

        go_todolist.setOnClickListener {
            val intent = Intent(requireContext(), ToDoListActivity::class.java)
            startActivity(intent)
        }

//        go_convert.setOnClickListener {
//            val intent = Intent(requireContext(), ConvertCurrentFragment::class.java)
//            startActivity(intent)
//        }
//
//        go_calculator.setOnClickListener {
//            val intent = Intent(requireContext(), CalculatorFragment::class.java)
//            startActivity(intent)
//        }
//
//        go_bmi.setOnClickListener {
//            val intent = Intent(requireContext(), BmiFragment::class.java)
//            startActivity(intent)
//        }


        return _view
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashboardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}